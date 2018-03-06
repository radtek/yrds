package com.yrds.iris.dto;

import com.kivi.framework.dto.BaseReqDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜设备状态维持心跳请求
 * @author Eric
 *
 */
@ApiModel( value = "IrisDeviceHeartbeat", description = "虹膜设备状态维持心跳请求" )
@Setter
@Getter
public class IrisDeviceHeartbeat extends BaseReqDTO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号
     */
	@ApiModelProperty(
            value = "采集设备编号，高5字节填充为0，低11字节为厂商制定的采集设备生产序列号",
            required = true,
            dataType = "String",
            example = "0000012345678901" )
    private String deviceId;
	
	/**
     * 许可token
     */
	@ApiModelProperty(
            value = "许可token，后续操作接口需带上它，才能调用成功",
            required = true,
            dataType = "String",
            example = "00000000000000000000000000000000" )
    private String accessToken;

}