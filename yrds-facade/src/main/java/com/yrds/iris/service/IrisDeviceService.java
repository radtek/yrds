package com.yrds.iris.service;

import com.yrds.iris.bean.IrisDeviceImport;
import com.yrds.iris.bean.IrisDeviceImportRsp;
import com.yrds.iris.bean.IrisDeviceLogin;
import com.yrds.iris.bean.IrisDeviceLoginRsp;
import com.yrds.iris.bean.IrisDeviceReg;
import com.yrds.iris.bean.IrisDeviceRegRsp;

/**
 * 虹膜设备管理服务
 * 
 * @author Eric
 *
 */
public interface IrisDeviceService {

    /**
     * 虹膜设备注册
     * 
     * @param req
     * @param clientIp
     * @return
     */
    IrisDeviceRegRsp regist( IrisDeviceReg req, String clientIp );

    /**
     * 虹膜设备登录
     * 
     * @param req
     * @return
     */
    IrisDeviceLoginRsp login( IrisDeviceLogin req, String clientIp );

    /**
     * 批量导入设备
     * 
     * @param req
     * @return
     */
    IrisDeviceImportRsp importBatch( IrisDeviceImport req );
}
