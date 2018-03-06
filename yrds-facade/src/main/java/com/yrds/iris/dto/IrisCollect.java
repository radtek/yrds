package com.yrds.iris.dto;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜采集请求
 * @author Eric
 *
 */
@ApiModel( value = "IrisCollect", description = "虹膜采集请求" )
@Setter
@Getter
public class IrisCollect extends IrisMatch{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		
	/**
     * 员工编号
     */
	@ApiModelProperty(
            value = "员工编号",
            required = false,
            dataType = "String",
            example = "0001" )
    private String staffId;
   
	/**
     * 员工姓名
     */
	@ApiModelProperty(
            value = "员工姓名",
            required = false,
            dataType = "String",
            example = "张三" )
    private String staffName;

}