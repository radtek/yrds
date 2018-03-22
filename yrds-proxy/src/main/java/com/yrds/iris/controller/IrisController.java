package com.yrds.iris.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kivi.framework.web.controller.BaseController;
import com.yrds.iris.bean.IrisCollect;
import com.yrds.iris.bean.IrisCollectRsp;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.bean.IrisMatchRsp;
import com.yrds.iris.service.IrisBizService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * IRIS采集和比对API接口
 * 
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

    private final Logger   log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IrisBizService irisBizService;

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

        log.info("IRIS采集处理开始，流水号:{}", req.getTranSeqId());
        IrisCollectRsp result = irisBizService.collect(req);
        log.info("IRIS采集处理结束，流水号:{}", req.getTranSeqId());

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
    public ResponseEntity<IrisMatchRsp> irisMatch( @Valid @RequestBody IrisMatch req ) {
        log.info("IRIS比对处理开始，流水号:{}", req.getTranSeqId());
        IrisMatchRsp result = irisBizService.match(req);
        log.info("IRIS比对处理结束，流水号:{}", req.getTranSeqId());

        return ResponseEntity.ok(result);
    }

}
