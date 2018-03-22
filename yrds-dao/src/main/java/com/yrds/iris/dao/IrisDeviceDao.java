package com.yrds.iris.dao;

import com.kivi.framework.db.dao.IDao;
import com.yrds.iris.persist.model.IrisDevice;

public interface IrisDeviceDao extends IDao<IrisDevice> {

    /**
     * 根据设备ID获取设备信息
     * 
     * @param deviceId
     * @return
     */
    IrisDevice getIrisDevice( String deviceId );

    /**
     * 根据设备ID和状态获取设备信息
     * 
     * @param deviceId
     * @param status
     * @return
     */
    IrisDevice getIrisDevice( String deviceId, Integer status );
}
