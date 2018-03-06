package com.yrds.iris.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜比对请求
 * @author Eric
 *
 */
@ApiModel( value = "IrisMatch", description = "虹膜比对请求" )
@Setter
@Getter
public class IrisMatch extends IrisDeviceHeartbeat{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
    /**
     * 虹膜图像数据长度，字节为单位
     */
	@ApiModelProperty(
            value = "虹膜图像数据长度，字节为单位",
            required = true,
            dataType = "Integer",
            example = "2048" )
    private Integer imgLen;
	
	/**
     * 图片数据
     */
	@ApiModelProperty(
            value = "图片数据,base64编码",
            required = true,
            dataType = "String",
            example = "" )
    private String imgDataBase64;

    /**
     * 虹膜特征模板长度，字节单位
     */
	@ApiModelProperty(
            value = "虹膜特征模板长度，字节单位",
            required = true,
            dataType = "Integer",
            example = "512" )
    private Integer featureLen;
    
    /**
     * 虹膜特征模板
     */
	@ApiModelProperty(
            value = "虹膜特征模板,base64编码",
            required = true,
            dataType = "String",
            example = "" )
    private String featureBase64;

    /**
     * 虹膜算法名称
     */
	@ApiModelProperty(
            value = "虹膜算法名称",
            required = false,
            dataType = "String",
            example = "alg.1" )
    private String algName;

    /**
     * 虹膜算法版本号
     */
	@ApiModelProperty(
            value = "虹膜算法版本号",
            required = false,
            dataType = "String",
            example = "1.0.0" )
    private String algVersion;

    
    

    

	

}