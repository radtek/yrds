/**
 * 
 */
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

import com.kivi.framework.constant.Constant;
import com.kivi.framework.constant.GlobalErrorConst;
import com.kivi.framework.log.annotation.BizLog;
import com.kivi.framework.web.controller.BaseController;
import com.kivi.framework.web.shiro.token.StatelessToken;
import com.kivi.framework.web.shiro.token.manager.impl.TokenManagerKit;
import com.kivi.framework.web.util.kit.HttpKit;
import com.yrds.iris.bean.IrisDeviceHeartbeat;
import com.yrds.iris.bean.IrisDeviceHeartbeatRsp;
import com.yrds.iris.bean.IrisDeviceLogin;
import com.yrds.iris.bean.IrisDeviceLoginRsp;
import com.yrds.iris.bean.IrisDeviceReg;
import com.yrds.iris.bean.IrisDeviceRegRsp;
import com.yrds.iris.service.IrisDeviceService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 管理API
 * 
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
    private final Logger      log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private IrisDeviceService irisDeviceService;

    /**
     * 虹膜设备注册
     */
    @ApiOperation(
                   position = 1,
                   value = "IRIS设备注册接口",
                   notes = "IRIS设备注册接口",
                   nickname = "irisDevRegist",
                   consumes = MediaType.APPLICATION_JSON_VALUE )
    @RequestMapping(
                     value = "/irisDevRegist",
                     method = RequestMethod.POST,
                     produces = MediaType.APPLICATION_JSON_VALUE )
    @BizLog( value = "IRIS设备注册", isSave = false )
    public ResponseEntity<IrisDeviceRegRsp> irisDevRegist( @Valid @RequestBody IrisDeviceReg req ) {
        log.info("IRIS设备注册处理开始，流水号:{}", req.getTranSeqId());
        IrisDeviceRegRsp result = irisDeviceService.regist(req, HttpKit.getIp());
        log.info("IRIS设备注册处理结束，流水号:{}", req.getTranSeqId());

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
    @BizLog( value = "IRIS设备登录", isSave = false )
    public ResponseEntity<IrisDeviceLoginRsp> irisDevLogin( @Valid @RequestBody IrisDeviceLogin req ) {
        log.info("IRIS设备登录处理开始，流水号:{}", req.getTranSeqId());
        IrisDeviceLoginRsp result = irisDeviceService.login(req, HttpKit.getIp());
        if (GlobalErrorConst.SUCCESS.equals(result.getRespCode())) {
            log.info("设备[{}]登录成功");
            StatelessToken token = TokenManagerKit.me().createToken(req.getDeviceId(), HttpKit.getIp());
            result.setAccessToken(token.getToken());
        }
        log.info("IRIS设备登录处理结束，流水号:{}", req.getTranSeqId());

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
    @RequestMapping(
                     value = "/irisDevHeartbeat",
                     method = RequestMethod.POST,
                     produces = MediaType.APPLICATION_JSON_VALUE )
    @BizLog( value = "IRIS设备心跳", isSave = false )
    public ResponseEntity<IrisDeviceHeartbeatRsp> irisDevHeartbeat( @Valid @RequestBody IrisDeviceHeartbeat req ) {
        log.info("IRIS设备心跳处理开始，流水号:{}", req.getTranSeqId());

        String authorization = HttpKit.getRequest().getHeader(Constant.HTTP_AUTHORIZATION);
        boolean state = TokenManagerKit.me().check(authorization);

        IrisDeviceHeartbeatRsp result = new IrisDeviceHeartbeatRsp();
        result.setRespCode(state ? GlobalErrorConst.SUCCESS : GlobalErrorConst.E_USER_NOT_AUTH);

        log.info("IRIS设备心跳处理完成，流水号:{}", req.getTranSeqId());

        return ResponseEntity.ok(result);
    }

}
