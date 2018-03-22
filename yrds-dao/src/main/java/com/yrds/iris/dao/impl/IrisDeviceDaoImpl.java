package com.yrds.iris.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.kivi.framework.db.dao.BaseDao;
import com.kivi.framework.exception.AppException;
import com.yrds.iris.constant.YrdsError;
import com.yrds.iris.dao.IrisDeviceDao;
import com.yrds.iris.persist.model.IrisDevice;

@Repository
public class IrisDeviceDaoImpl extends BaseDao<IrisDevice> implements IrisDeviceDao {

    private static final Logger log = LoggerFactory.getLogger(IrisDeviceDaoImpl.class);

    @Override
    public IrisDevice getIrisDevice( String deviceId ) {
        IrisDevice entity = new IrisDevice();
        entity.setDeviceId(deviceId);

        List<IrisDevice> list = super.selectByEntity(entity);
        if (list == null || list.isEmpty()) {
            log.error("数据库中的设备id[{}]记录不存在", deviceId);
            throw new AppException(YrdsError.E_RECORD_NOT_EXIST, "设备信息记录不存在");
        }

        if (list.size() > 1) {
            log.error("数据库中的设备id[{}]记录有多条，无法确定使用哪一条。", deviceId);
            throw new AppException(YrdsError.E_RECORD_NOT_UNIQUE, "设备信息记录有重复");
        }

        return list.get(0);
    }

    @Override
    public IrisDevice getIrisDevice( String deviceId, Integer status ) {
        IrisDevice entity = new IrisDevice();
        entity.setDeviceId(deviceId);
        entity.setStatus(status);

        List<IrisDevice> list = super.selectByEntity(entity);
        if (list == null || list.isEmpty()) {
            log.error("数据库中的设备id[{}]记录不存在", deviceId);
            throw new AppException(YrdsError.E_RECORD_NOT_EXIST, "设备信息记录不存在");
        }

        if (list.size() > 1) {
            log.error("数据库中的设备id[{}]记录有多条，无法确定使用哪一条。", deviceId);
            throw new AppException(YrdsError.E_RECORD_NOT_UNIQUE, "设备信息记录有重复");
        }

        return list.get(0);
    }

}
