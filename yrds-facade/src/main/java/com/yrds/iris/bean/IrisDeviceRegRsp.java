package com.yrds.iris.bean;

import com.kivi.framework.dto.BaseResDTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜设备登记响应
 * @author Eric
 *
 */
@ApiModel( value = "IrisDeviceRegRsp", description = "虹膜设备登记响应Bean" )
@Setter
@Getter
public class IrisDeviceRegRsp extends BaseResDTO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}