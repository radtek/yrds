package com.yrds.iris.dto;


import com.kivi.framework.dto.BaseResDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜登记响应
 * @author Eric
 *
 */
@ApiModel( value = "IrisRegistRsp", description = "虹膜登记响应" )
@Setter
@Getter
public class IrisMatchRsp extends BaseResDTO{

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