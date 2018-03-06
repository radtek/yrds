package com.yrds.iris.service;

import com.yrds.iris.dto.IrisDeviceHeartbeat;
import com.yrds.iris.dto.IrisDeviceHeartbeatRsp;
import com.yrds.iris.dto.IrisDeviceImport;
import com.yrds.iris.dto.IrisDeviceImportRsp;
import com.yrds.iris.dto.IrisDeviceLogin;
import com.yrds.iris.dto.IrisDeviceLoginRsp;
import com.yrds.iris.dto.IrisDeviceReg;
import com.yrds.iris.dto.IrisDeviceRegRsp;

/**
 * 虹膜设备管理服务
 * @author Eric
 *
 */
public interface IrisDeviceService {

	/**
	 * 虹膜设备注册
	 * @param req
	 * @return
	 */
	IrisDeviceRegRsp regist( IrisDeviceReg req ) ;
	
	/**
	 * 虹膜设备登录
	 * @param req
	 * @return
	 */
	IrisDeviceLoginRsp login( IrisDeviceLogin req) ;
	
	/**
	 * 虹膜设备心跳
	 * @param req
	 * @return
	 */
	IrisDeviceHeartbeatRsp heartbeat( IrisDeviceHeartbeat req) ;
	
	/**
	 * 批量导入设备
	 * @param req
	 * @return
	 */
	IrisDeviceImportRsp importBatch(  IrisDeviceImport req ) ;
}
