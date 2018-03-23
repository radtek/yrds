package com.yrds.iris.module.hs;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kivi.framework.exception.AppException;
import com.kivi.framework.util.kit.CollectionKit;
import com.kivi.framework.util.kit.StrKit;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.constant.YrdsError;
import com.yrds.iris.module.BaseIrisModule;
import com.yrds.iris.module.IIrisModule;
import com.yrds.iris.module.hs.WhsUsbAPI.DeviceManager;
import com.yrds.iris.persist.model.IrisFeature;

public class IrisModuleHS extends BaseIrisModule implements IIrisModule {

    private static final Logger                          log              = LoggerFactory
            .getLogger(IrisModuleHS.class);
    private static final int                             HS_TEMPLATE_SIZE = 8192;

    private DeviceManager                                deviceManager    = null;
    private DeviceManager.usb_hotplug_callback           on_usb_hotplug   = null;
    private DeviceManager.sleep_mode_callback            on_sleep_mode    = null;
    private DeviceManager.error_callback                 on_error         = null;
    private DeviceManager.image_callback                 on_image         = null;
    private DeviceManager.match_callback                 on_match         = null;

    private static AtomicInteger                         currentDevIndex  = new AtomicInteger();
    private static ConcurrentHashMap<Long, List<Long>>   matchIdsMap      = new ConcurrentHashMap<>();
    private static ConcurrentLinkedDeque<CountDownLatch> matchWaitQueue   = new ConcurrentLinkedDeque<>();

    // Match Record
    public class MatchRecord {
        String         template_a_path  = new String();
        Vector<String> templates_b_path = new Vector<String>();
    };

    MatchRecord matchRecord = new MatchRecord();

    @Override
    public String sdkName() {
        return "whsusbapi.dll";
    }

    @Override
    public String vendor() {
        return "HS-武汉虹识";
    }

    @Override
    public void init() throws AppException {

        deviceManager = (DeviceManager) Native.loadLibrary(super.getSdkLibraryFilePath(vendor(), sdkName()),
                DeviceManager.class);

        on_usb_hotplug = new DeviceManager.usb_hotplug_callback() {

            @Override
            public void invoke( int index, int hotplug_event ) {
                onUsbHotplugCallback(index, hotplug_event);
            }
        };

        on_sleep_mode = new DeviceManager.sleep_mode_callback() {

            @Override
            public void invoke( int index ) {
                onSleepModeCallback(index);
            }
        };

        on_error = new DeviceManager.error_callback() {

            @Override
            public void invoke( int index, int error_code ) {
                onErrorCallback(index, error_code);
            }
        };

        on_image = new DeviceManager.image_callback() {

            @Override
            public void invoke( int index, int type, Pointer image_ptr, int width, int height, Pointer template_ptr,
                    int length ) {
                onImageCallback(index, type, image_ptr, width, height, template_ptr, length);
            }
        };

        on_match = new DeviceManager.match_callback() {

            @Override
            public void invoke( int index, Pointer id_array, int size, Boolean result ) {
                onMatchCallback(index, id_array, size, result);
            }
        };

        int ret = deviceManager.HS_Initialize();

        if (ret < 0) {
            log.error("初始化SDK Library失败！，错误：{}", this.getErrorMessage(ret));
            throw new AppException(YrdsError.E_IR_SDK_INIT, this.getErrorMessage(ret));
        }

        // Set the Callback.
        // Remember: Callback runs in the Library thread, which differs from the
        // Java Thread.
        // You must to guarantee the safety of the callback functions.
        // Pointer record = null;
        deviceManager.HS_SetUsbHotPlugCallback(on_usb_hotplug);
        deviceManager.HS_SetSleepModeCallback(on_sleep_mode);
        deviceManager.HS_SetErrorCallback(on_error);
        deviceManager.HS_SetImageCallback(on_image);
        deviceManager.HS_SetMatchCallback(on_match);

    }

    @Override
    public void close() throws AppException {
        log.info("关闭设备");
        deviceManager.HS_Finalize();
    }

    @Override
    public List<IrisFeature> match( IrisMatch req, List<IrisFeature> list ) {
        long curThreadId = Thread.currentThread().getId();
        // Create Record.
        Pointer record = deviceManager.HS_CreateMatchRecord();
        if (record == null) {
            throw new AppException(YrdsError.E_IR_SDK_CREATE_TEMPLETE, "创建模板记录失败！");
        }

        // 获取templateB
        Map<Long, byte[]> templateBList = super.getTemplateBList(list);
        Iterator<Entry<Long, byte[]>> itB = templateBList.entrySet().iterator();
        while (itB.hasNext()) {
            Entry<Long, byte[]> ent = itB.next();
            String matchId = StrKit.join(StrKit.HYPHEN, curThreadId, ent.getKey());
            int ret = deviceManager.HS_InsertTemplateB(record, ent.getValue(), HS_TEMPLATE_SIZE, matchId);
            if (ret < 0) {
                log.warn("插入模板信息失败，信息:{}", this.getErrorMessage(ret));
                continue;
            }
        }

        // 获取待匹配的虹膜
        List<byte[]> templateAList = super.getTemplateAList(req);
        Iterator<byte[]> itA = templateAList.iterator();
        while (itA.hasNext()) {
            byte[] templateA = itA.next();
            if (templateA.length != HS_TEMPLATE_SIZE) {
                log.warn("请求流水号[{}]模板数据长度为{}，不等于标准模板长度{},判定为无效模板，不使用该模板", req.getTranSeqId(), templateA.length,
                        HS_TEMPLATE_SIZE);
                continue;
            }

            int ret = deviceManager.HS_SetTemplateA(record, templateA, HS_TEMPLATE_SIZE);
            if (ret < 0) {
                log.warn("插入模板信息失败，信息:{}", this.getErrorMessage(ret));
                continue;
            }
        }

        // Start Match
        int ret = deviceManager.HS_StartMatch(currentDevIndex.get(), 0x01, record);
        if (ret < 0) {
            log.error("开始比对失败，错误信息：{}。", this.getErrorMessage(ret));
            throw new AppException(YrdsError.E_IR_SDK_MATCH_IRIS, "创建模板记录失败！");
        }
        CountDownLatch waiter = new CountDownLatch(1);
        matchWaitQueue.addLast(waiter);

        try {
            waiter.await();
        }
        catch (InterruptedException e) {
            log.error("等待中断", e);
        }
        // Release Match Record.
        deviceManager.HS_ReleaseMatchRecord(record);

        // 得到匹配结果
        List<Long> idList = matchIdsMap.get(curThreadId);
        Iterator<IrisFeature> it = list.iterator();
        while (it.hasNext()) {
            if (!idList.contains(it.next().getId()))
                it.remove();
        }

        return list;
    }

    private void onUsbHotplugCallback( int index, int hotplug_event ) {
        if (hotplug_event == 1) {
            currentDevIndex.getAndSet(index);
            log.info("新的设备[{}]接入！", index);
        }
        else {
            currentDevIndex.getAndSet(-1);
            log.info("设备[{}]断开连接！", index);
        }

    }

    private void onSleepModeCallback( int index ) {
        log.info("设备[{}]进入休眠模式！", index);
    }

    private void onErrorCallback( int index, int error_code ) {
        log.info("设备[{}]出现错误, 信息:{}", index, getErrorMessage(error_code));
    }

    private void onImageCallback( int index, int type, Pointer image_ptr, int width, int height, Pointer template_ptr,
            int length ) {

    }

    private void onMatchCallback( int index, Pointer id_array, int size, Boolean result ) {
        if (result) {
            String threadId = null;
            List<Long> matchids = CollectionKit.newArrayList();
            for (int i = 0; i < size; i++) {
                String matchid = deviceManager.HS_MatchIdClips(id_array, i);
                String[] items = StrKit.split(matchid, StrKit.HYPHEN);
                if (threadId != null)
                    threadId = items[0];
                matchids.add(Long.parseLong(items[1]));
            }
            matchIdsMap.put(Long.parseLong(threadId), matchids);
            log.info("设备[{}]比对成功, ID列表:{}.", index, CollectionKit.join(matchids, ","));
        }
        else {
            log.info("设备[{}]比对失败。", index);
        }

        CountDownLatch waiter = matchWaitQueue.removeFirst();

        waiter.countDown();
    }

    private String getErrorMessage( int err ) {
        return deviceManager.HS_StrError(err);
    }

}
