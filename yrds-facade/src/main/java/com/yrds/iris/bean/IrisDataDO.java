package com.yrds.iris.bean;

import javax.validation.constraints.Digits;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel( value = "IrisDataBO", description = "虹膜数据定义" )
@Setter
@Getter
public class IrisDataDO {
    /**
     * 左眼虹膜图像数据长度，字节为单位
     */
    @ApiModelProperty(
                       value = "左眼虹膜图像数据长度，字节为单位",
                       required = false,
                       dataType = "Integer",
                       example = "2048" )
    @Digits( integer = 10, fraction = 0, message = "左眼虹膜图像数据长度必须为数字，且最大长度不超过10位" )
    private Integer imgLeftLen;

    /**
     * 左眼虹膜图片数据
     */
    @ApiModelProperty(
                       value = "左眼虹膜图片数据,base64编码",
                       required = false,
                       dataType = "String",
                       example = "" )
    private String  imgLeftDataBase64;

    /**
     * 右眼虹膜特征模板长度，字节单位
     */
    @ApiModelProperty(
                       value = "左眼虹膜特征模板长度，字节单位",
                       required = false,
                       dataType = "Integer",
                       example = "512" )
    @Digits( integer = 6, fraction = 0, message = "虹膜特征模板长度必须为数字，且最大长度不超过6位" )
    private Integer featureLeftLen;

    /**
     * 左眼虹膜特征模板
     */
    @ApiModelProperty(
                       value = "左眼虹膜特征模板,base64编码",
                       required = false,
                       dataType = "String",
                       example = "" )
    private String  featureLeftBase64;

    /**
     * 右眼虹膜图像数据长度，字节为单位
     */
    @ApiModelProperty(
                       value = "右眼虹膜图像数据长度，字节为单位",
                       required = false,
                       dataType = "Integer",
                       example = "2048" )
    @Digits( integer = 10, fraction = 0, message = "右眼虹膜图像数据长度必须为数字，且最大长度不超过10位" )
    private Integer imgRightLen;

    /**
     * 右眼虹膜图片数据
     */
    @ApiModelProperty(
                       value = "右眼虹膜图片数据,base64编码",
                       required = false,
                       dataType = "String",
                       example = "" )
    private String  imgRightDataBase64;

    /**
     * 右眼虹膜特征模板长度，字节单位
     */
    @ApiModelProperty(
                       value = "右眼虹膜特征模板长度，字节单位",
                       required = false,
                       dataType = "Integer",
                       example = "512" )
    @Digits( integer = 6, fraction = 0, message = "虹膜特征模板长度必须为数字，且最大长度不超过6位" )
    private Integer featureRightLen;

    /**
     * 右眼虹膜特征模板
     */
    @ApiModelProperty(
                       value = "右眼虹膜特征模板,base64编码",
                       required = false,
                       dataType = "String",
                       example = "" )
    private String  featureRightBase64;
}
