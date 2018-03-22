package com.yrds.iris.bean;

import com.kivi.framework.dto.BaseResDTO;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

/**
 * 虹膜设备批量导入响应
 * @author Eric
 *
 */
@ApiModel( value = "IrisDeviceImportRsp", description = "虹膜设备批量导入响应" )
@Setter
@Getter
public class IrisDeviceImportRsp extends BaseResDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}
