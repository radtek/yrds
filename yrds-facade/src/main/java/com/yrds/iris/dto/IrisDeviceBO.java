package com.yrds.iris.dto;


import java.io.Serializable;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜设备信息对象
 * @author Eric
 *
 */
@Setter
@Getter
public class IrisDeviceBO implements Serializable{

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
     * 虹膜采集设备描述字符串
     */
	@ApiModelProperty(
            value = "虹膜采集设备描述",
            required = true,
            dataType = "String",
            example = "xxx虹膜采集设备" )
    private String descriptor;

    /**
     * 虹膜采集设备型号字符串
     */
	@ApiModelProperty(
            value = "虹膜采集设备型号",
            required = true,
            dataType = "String",
            example = "IRIS-1-001" )
    private String productType;

    /**
     * 采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     */
	@ApiModelProperty(
            value = "采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码",
            required = false,
            dataType = "String",
            example = "000000112233445566778899" )
    private String vendorId;

    /**
     * 采集设备传感器类型标识
     */
	@ApiModelProperty(
            value = "采集设备传感器类型标识",
            required = false,
            dataType = "Integer",
            example = "1" )
    private Integer sensorType;

    /**
     * 采集设备注册标识
     */
	@ApiModelProperty(
            value = "采集设备注册标识",
            required = false,
            dataType = "Integer",
            example = "1" )
    private Integer registerFlag;

    /**
     * 虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     */
	@ApiModelProperty(
            value = "采集设备注册标识",
            required = false,
            dataType = "Integer",
            example = "1" )
    private Integer deviceFlag;

    /**
     * 光谱
     */
	@ApiModelProperty(
            value = "光谱",
            required = false,
            dataType = "Integer",
            example = "0" )
    private Integer spetrum;

    /**
     * 设备返回图像格式
     */
	@ApiModelProperty(
            value = "设备返回图像格式",
            required = false,
            dataType = "String",
            example = "png" )
    private String devImgFormat;

    /**
     * 像素位深度
     */
	@ApiModelProperty(
            value = "像素位深度",
            required = false,
            dataType = "Integer",
            example = "24" )
    private Integer devImgDepth;

    /**
     * 设备采集图像宽度
     */
	@ApiModelProperty(
            value = "设备采集图像宽度",
            required = false,
            dataType = "Integer",
            example = "200" )
    private Integer devImgWidth;

    /**
     * 设备采集图像高度
     */
	@ApiModelProperty(
            value = "设备采集图像高度",
            required = false,
            dataType = "Integer",
            example = "150" )
    private Integer devImgHeight;

    /**
     * 设备固件版本
     */
	@ApiModelProperty(
            value = "设备固件版本",
            required = false,
            dataType = "String",
            example = "1.0.0" )
    private String firmwareVersion;

}