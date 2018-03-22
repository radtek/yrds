package com.yrds.iris.bean;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.kivi.framework.dto.BaseReqDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 虹膜设备登记请求DTO
 * 
 * @author Eric
 *
 */
@ApiModel( value = "IrisDeviceRegReq", description = "虹膜设备登记请求Bean" )
@Setter
@Getter
public class IrisDeviceReg extends BaseReqDTO {

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
    @NotEmpty
    @Size( max = 16, message = "设备编号不能为空，且最大长度不能超过16字节" )
    private String            deviceId;

    /**
     * 虹膜采集设备描述字符串
     */
    @ApiModelProperty(
                       value = "虹膜采集设备描述",
                       required = true,
                       dataType = "String",
                       example = "xxx虹膜采集设备" )
    @NotEmpty
    @Size( max = 128, message = "设备描述不能为空，且最大长度不能超过128字节" )
    private String            descriptor;

    /**
     * 虹膜采集设备型号字符串
     */
    @ApiModelProperty(
                       value = "虹膜采集设备型号",
                       required = true,
                       dataType = "String",
                       example = "IRIS-1-001" )
    @NotEmpty
    @Size( max = 64, message = "设备型号不能为空，且最大长度不能超过64字节" )
    private String            productType;

    /**
     * 采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码
     */
    @ApiModelProperty(
                       value = "采集设备供方标识。高6字节填充为0，低18字节为厂商社会信用代码",
                       required = false,
                       dataType = "String",
                       example = "000000112233445566778899" )
    @NotEmpty
    @Size( max = 24, message = "设备供方标识不能为空，且最大长度不能超过24字节" )
    private String            vendorId;

    /**
     * 采集设备传感器类型标识
     */
    @ApiModelProperty(
                       value = "采集设备传感器类型标识",
                       required = false,
                       dataType = "Integer",
                       example = "1" )
    @Digits( integer = 4, fraction = 0, message = "设备传感器类型标识必须为数字，且长度不能超过4位" )
    private Integer           sensorType;

    /**
     * 采集设备注册标识
     */
    @ApiModelProperty(
                       value = "采集设备注册标识",
                       required = false,
                       dataType = "Integer",
                       example = "1" )
    @Digits( integer = 1, fraction = 0, message = "设备注册标识必须为1位数字" )
    private Integer           registerFlag;

    /**
     * 虹膜采集设备类型，0：单目，1：双目单摄像头，2：双目双摄像头，3~100：保留
     */
    @ApiModelProperty(
                       value = "采集设备类型",
                       required = false,
                       dataType = "Integer",
                       example = "1" )
    @Digits( integer = 3, fraction = 0, message = "设备类型必须为数字，且长度不能超过3位" )
    private Integer           deviceFlag;

    /**
     * 光谱
     */
    @ApiModelProperty(
                       value = "光谱",
                       required = false,
                       dataType = "Integer",
                       example = "0" )
    @Digits( integer = 4, fraction = 0, message = "光谱标识必须为数字，且长度不能超过4位" )
    private Integer           spetrum;

    /**
     * 设备返回图像格式
     */
    @ApiModelProperty(
                       value = "设备返回图像格式",
                       required = true,
                       dataType = "String",
                       example = "png" )
    @NotEmpty
    @Size( max = 8, message = "设备返回图像格式不能为空，且最大长度不能超过24字节" )
    private String            devImgFormat;

    /**
     * 像素位深度
     */
    @ApiModelProperty(
                       value = "像素位深度",
                       required = false,
                       dataType = "Integer",
                       example = "24" )
    @Digits( integer = 4, fraction = 0, message = "像素位深度必须为数字长度不能超过4位" )
    private Integer           devImgDepth;

    /**
     * 设备采集图像宽度
     */
    @ApiModelProperty(
                       value = "设备采集图像宽度",
                       required = false,
                       dataType = "Integer",
                       example = "200" )
    @Digits( integer = 4, fraction = 0, message = "设备采集图像宽度长度不能超过4位" )
    private Integer           devImgWidth;

    /**
     * 设备采集图像高度
     */
    @ApiModelProperty(
                       value = "设备采集图像高度",
                       required = false,
                       dataType = "Integer",
                       example = "150" )
    @Digits( integer = 4, fraction = 0, message = "设备采集图像高度长度不能超过4位" )
    private Integer           devImgHeight;

    /**
     * 设备固件版本
     */
    @ApiModelProperty(
                       value = "设备固件版本",
                       required = false,
                       dataType = "String",
                       example = "1.0.0" )
    @Size( max = 8, message = "设备固件版本最大长度不能超过24字节" )
    private String            firmwareVersion;

    /**
     * 设备SDK的动态库
     */
    @ApiModelProperty(
                       value = "设备SDK的动态库",
                       required = false,
                       dataType = "String",
                       example = "xxx.dll" )
    @Size( max = 255, message = "设备SDK的动态库最大长度不能超过255字节" )
    private String            sdkLib;

}
