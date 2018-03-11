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
import com.yrds.iris.dto.IrisCollect;
import com.yrds.iris.dto.IrisCollectRsp;
import com.yrds.iris.dto.IrisMatch;
import com.yrds.iris.dto.IrisMatchRsp;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * IRIS采集和比对API接口
 * @author Eric
 *
 */
@RestController
@RequestMapping(
                 value = "/api",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE )
@Api( tags = { "IRIS" }, description = "IRIS采集和比对API接口", produces = MediaType.APPLICATION_JSON_VALUE )
public class IrisController extends BaseController {
	
	private final Logger  log = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 虹膜采集
	 */
	 @ApiOperation(
             position = 1,
             value = "IRIS采集接口",
             notes = "IRIS采集接口",
             nickname = "irisCollect",
             consumes = MediaType.APPLICATION_JSON_VALUE )
	 @RequestMapping( value = "/irisCollect", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<IrisCollectRsp> irisCollect( @Valid @RequestBody IrisCollect req ) {
		 IrisCollectRsp result = new IrisCollectRsp();
		 
		 return ResponseEntity.ok(result);
	}
	
	/**
	 * 虹膜比对
	 */
	 @ApiOperation(
             position = 2,
             value = "IRIS比对接口",
             notes = "IRIS比对接口",
             nickname = "irisMatch",
             consumes = MediaType.APPLICATION_JSON_VALUE )
	 @RequestMapping( value = "/irisMatch", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE )
	 public ResponseEntity<IrisMatchRsp> irisMatch( @Valid @RequestBody IrisMatch req) {
		 IrisMatchRsp result = new IrisMatchRsp();
		 
		 return ResponseEntity.ok(result);
	}
	

}
