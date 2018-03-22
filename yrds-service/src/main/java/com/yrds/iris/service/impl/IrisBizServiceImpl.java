/**
 * 
 */
package com.yrds.iris.service.impl;

import java.util.Iterator;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kivi.framework.constant.enums.KtfStatus;
import com.kivi.framework.exception.AppException;
import com.kivi.framework.log.annotation.BizLog;
import com.kivi.framework.util.kit.BeanKit;
import com.kivi.framework.util.kit.CollectionKit;
import com.kivi.framework.util.kit.DateTimeKit;
import com.yrds.iris.bean.IrisCollect;
import com.yrds.iris.bean.IrisCollectRsp;
import com.yrds.iris.bean.IrisDataDO;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.bean.IrisMatchRsp;
import com.yrds.iris.bean.dto.IrisDeviceDTO;
import com.yrds.iris.bean.dto.IrisMatchRspDTO;
import com.yrds.iris.constant.YrdsError;
import com.yrds.iris.dao.IrisDeviceDao;
import com.yrds.iris.dao.IrisFeatureDao;
import com.yrds.iris.dao.UsersDao;
import com.yrds.iris.enums.DeviceStatus;
import com.yrds.iris.enums.TranCodeEnum;
import com.yrds.iris.enums.UserStatus;
import com.yrds.iris.persist.model.IrisDevice;
import com.yrds.iris.persist.model.IrisFeature;
import com.yrds.iris.persist.model.Users;
import com.yrds.iris.service.IrisBizService;
import com.yrds.iris.service.IrisMatchService;

/**
 * @author Eric
 *
 */
@Service
public class IrisBizServiceImpl implements IrisBizService {
    private static final Logger log = LoggerFactory.getLogger(IrisBizServiceImpl.class);

    @Autowired
    private IrisFeatureDao      irisFeatureDao;

    @Autowired
    private IrisDeviceDao       irisDeviceDao;

    @Autowired
    private UsersDao            usersDao;

    @Autowired
    private IrisMatchService    irisMatchService;

    /*
     * (non-Javadoc)
     * 
     * @see
     * com.yrds.iris.service.IrisService#collect(com.yrds.iris.dto.IrisCollect)
     */
    @BizLog( value = "虹膜采集" )
    @Override
    public IrisCollectRsp collect( IrisCollect req ) {
        IrisCollectRsp result = new IrisCollectRsp();

        try {
            // 1. 检查参数
            if (TranCodeEnum.IRIS_COLLECT.getCode().equals(req.getTranCode())) {
                log.error("虹膜采集请求的交易代码[{}]不正确.", req.getTranCode());
                throw new AppException(YrdsError.E_IR_TRANCODE_NOT_SUPPORT);
            }

            if (req.getIrisList() == null || req.getIrisList().isEmpty()) {
                log.error("采集的虹膜数据为空");
                throw new AppException(YrdsError.E_IR_NO_IRIS);
            }

            // 2. 查找采集虹膜的设备的信息
            IrisDevice dev = irisDeviceDao.getIrisDevice(req.getDeviceId(), DeviceStatus.LOGIN.getCode());

            // 3. 根据员工ID查找记录
            Users user = usersDao.getByStaffId(req.getStaffId(), UserStatus.ENABLED.code);

            // 4. 组织model对象
            List<IrisFeature> list = CollectionKit.newArrayList();
            Iterator<IrisDataDO> it = req.getIrisList().iterator();
            while (it.hasNext()) {
                IrisDataDO bo = it.next();
                IrisFeature iris = new IrisFeature();
                iris.setAlgName(req.getAlgName());
                iris.setAlgVersion(req.getAlgVersion());
                iris.setUserId((long) user.getId());
                iris.setImgDepth(dev.getDevImgDepth());
                iris.setImgLWidth(dev.getDevImgWidth());
                iris.setImgLHeight(dev.getDevImgHeight());
                iris.setImgRWidth(dev.getDevImgWidth());
                iris.setImgRHeight(dev.getDevImgHeight());

                iris.setImgLLen(bo.getImgLeftLen());
                iris.setImgLData(Base64.decodeBase64(bo.getImgLeftDataBase64()));
                iris.setFeatureLLen(bo.getFeatureLeftLen());
                iris.setFeatureLData(Base64.decodeBase64(bo.getFeatureLeftBase64()));

                iris.setImgRLen(bo.getImgRightLen());
                iris.setImgRData(Base64.decodeBase64(bo.getImgRightDataBase64()));
                iris.setFeatureRLen(bo.getFeatureRightLen());
                iris.setFeatureRData(Base64.decodeBase64(bo.getFeatureRightBase64()));

                iris.setStatus(KtfStatus.ENABLED.code);

                iris.setGmtCreate(DateTimeKit.date());
                iris.setGmtUpdate(iris.getGmtCreate());

                list.add(iris);
            }

            irisFeatureDao.saveNotNull(list);

            result.setRespCode(YrdsError.SUCCESS);
        }
        catch (AppException e) {
            log.error("虹膜采集失败", e);
            result.setException(e);
        }
        catch (Exception e) {
            log.error("虹膜采集失败", e);
            result.setRespCode(YrdsError.E_UNDEFINED);
        }

        return result;
    }

    @BizLog( value = "虹膜匹配" )
    @Override
    public IrisMatchRsp match( IrisMatch req ) {
        IrisMatchRsp result = new IrisMatchRsp();
        try {
            // 1. 检查参数
            if (TranCodeEnum.IRIS_COLLECT.getCode().equals(req.getTranCode())) {
                log.error("虹膜采集请求的交易代码[{}]不正确.", req.getTranCode());
                throw new AppException(YrdsError.E_IR_TRANCODE_NOT_SUPPORT);
            }

            if (req.getFeatureList() == null || req.getFeatureList().isEmpty()) {
                log.error("待匹配虹膜模板为空");
                throw new AppException(YrdsError.E_IR_NO_IRIS);
            }

            // 2. 查找采集虹膜的设备的信息
            IrisDevice dev = irisDeviceDao.getIrisDevice(req.getDeviceId(), DeviceStatus.LOGIN.getCode());
            IrisDeviceDTO dto = new IrisDeviceDTO();
            BeanKit.copyProperties(dev, dto);

            // 3. 采集
            IrisMatchRspDTO rspDto = irisMatchService.match(req, dto);
            if (!YrdsError.SUCCESS.equals(rspDto.getRespCode())) {
                log.error("调用dubbo远程方法irisMatchService.match()失败，{}-{}", rspDto.getRespCode(), rspDto.getErrorTip());
                throw new AppException(rspDto.getRespCode(), rspDto.getErrorTip());
            }

            // 4. 查询用户
            Users user = usersDao.selectByKey(rspDto.getUserId());
            result.setRespCode(YrdsError.SUCCESS);
            result.setStaffId(user.getStaffId());
            result.setStaffName(user.getUsername());

            // 5. 更新
            irisFeatureDao.updateMatchCount(rspDto.getId(), rspDto.getMatchTime());
        }
        catch (AppException e) {
            log.error("虹膜匹配失败", e);
            result.setException(e);
        }
        catch (Exception e) {
            log.error("虹膜匹配失败", e);
            result.setRespCode(YrdsError.E_UNDEFINED);
        }

        return result;
    }

}
