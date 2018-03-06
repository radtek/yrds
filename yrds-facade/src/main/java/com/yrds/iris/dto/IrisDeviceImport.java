package com.yrds.iris.dto;

import java.util.List;

import com.kivi.framework.dto.BaseReqDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 虹膜设备批量导入请求
 * @author Eric
 *
 */
@ApiModel( value = "IrisDeviceImport", description = "虹膜设备批量导入请求" )
@Setter
@Getter
public class IrisDeviceImport extends BaseReqDTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(
            value = "采集设备信息列表",
            required = true,
            dataType = "List",
            example = "" )
	private List<IrisDeviceBO>  devices;
}
