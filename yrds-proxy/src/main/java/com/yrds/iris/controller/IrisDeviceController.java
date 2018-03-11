/**
 * 
 */
package com.yrds.iris.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kivi.framework.web.controller.BaseController;
import com.yrds.iris.dto.IrisDeviceHeartbeat;
import com.yrds.iris.dto.IrisDeviceHeartbeatRsp;
import com.yrds.iris.dto.IrisDeviceImport;
import com.yrds.iris.dto.IrisDeviceImportRsp;
import com.yrds.iris.dto.IrisDeviceLogin;
import com.yrds.iris.dto.IrisDeviceLoginRsp;
import com.yrds.iris.dto.IrisDeviceReg;
import com.yrds.iris.dto.IrisDeviceRegRsp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 管理API
 * @author Eric
 *
 */
@RestController
@RequestMapping(
                 value = "/api",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE )
@Api( tags = { "IRIS.Dev" }, description = "IRIS设备管理API接口", produces = MediaType.APPLICATION_JSON_VALUE )
public class IrisDeviceController extends BaseController {
private final Logger  log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 虹膜设备注册
	 */
	 @ApiOperation(
             position = 1,
             value = "IRIS设备注册接口",
             notes = "IRIS设备注册接口",
             nickname = "irisDevRegist",
             consumes = MediaType.APPLICATION_JSON_VALUE )
	 @RequestMapping( value = "/irisDevRegist", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<IrisDeviceRegRsp> irisDevRegist( @Valid @RequestBody IrisDeviceReg req ) {
		 IrisDeviceRegRsp result = new IrisDeviceRegRsp();
		 
		 return ResponseEntity.ok(result);
	}
	
	/**
	 * 虹膜设备登录
	 */
	 @ApiOperation(
             position = 2,
             value = "IRIS设备登录接口",
             notes = "IRIS设备登录接口",
             nickname = "irisDevLogin",
             consumes = MediaType.APPLICATION_JSON_VALUE )
	 @RequestMapping( value = "/irisDevLogin", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<IrisDeviceLoginRsp> irisDevLogin( @Valid @RequestBody IrisDeviceLogin req) {
		 IrisDeviceLoginRsp result = new IrisDeviceLoginRsp();
		 
		 return ResponseEntity.ok(result);
	}
	
	/**
	 * 虹膜设备心跳
	 */
	 @ApiOperation(
             position = 3,
             value = "IRIS设备心跳接口",
             notes = "IRIS设备心跳接口",
             nickname = "irisDevHeartbeat",
             consumes = MediaType.APPLICATION_JSON_VALUE )
	 @RequestMapping( value = "/irisDevHeartbeat", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<IrisDeviceHeartbeatRsp> irisDevHeartbeat(@Valid @RequestBody IrisDeviceHeartbeat req) {
		 IrisDeviceHeartbeatRsp result = new IrisDeviceHeartbeatRsp();
		 
		 return ResponseEntity.ok(result);
	}
	
	/**
	 * 批量导入设备
	 */
	 @ApiOperation(
             position = 4,
             value = "IRIS设备信息批量导入接口",
             notes = "IRIS设备信息批量导入接口",
             nickname = "irisDevImportBatch",
             consumes = MediaType.APPLICATION_JSON_VALUE )
	 @RequestMapping( value = "/irisDevImportBatch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<IrisDeviceImportRsp> irisDevImportBatch( @Valid @RequestBody IrisDeviceImport req ) {
		 IrisDeviceImportRsp result = new IrisDeviceImportRsp();
		 
		 return ResponseEntity.ok(result);
	}
}
