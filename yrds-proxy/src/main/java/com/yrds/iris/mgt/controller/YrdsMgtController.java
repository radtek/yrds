package com.yrds.iris.mgt.controller;

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

import com.kivi.framework.log.annotation.BizLog;
import com.kivi.framework.web.controller.BaseController;
import com.yrds.iris.bean.IrisDeviceImport;
import com.yrds.iris.bean.IrisDeviceImportRsp;
import com.yrds.iris.service.IrisDeviceService;

@RestController
@RequestMapping(
                 value = "/admin",
                 produces = MediaType.APPLICATION_JSON_VALUE,
                 consumes = MediaType.APPLICATION_JSON_VALUE )
public class YrdsMgtController extends BaseController {
    private final Logger      log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IrisDeviceService irisDeviceService;

    @RequestMapping(
                     value = "/irisDevImportBatch",
                     method = RequestMethod.POST,
                     produces = MediaType.APPLICATION_JSON_VALUE )
    @BizLog( value = "IRIS设备信息批量导入", isSave = false )
    public ResponseEntity<IrisDeviceImportRsp> irisDevImportBatch( @Valid @RequestBody IrisDeviceImport req ) {
        log.info("IRIS设备信息批量导入处理开始，流水号:{}", req.getTranSeqId());
        IrisDeviceImportRsp result = irisDeviceService.importBatch(req);
        log.info("IRIS设备信息批量导入处理完成，流水号:{}", req.getTranSeqId());

        return ResponseEntity.ok(result);
    }
}
