package com.yrds.iris.dto;


import com.kivi.framework.dto.BaseResDTO;

import io.swagger.annotations.ApiModel;
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
public class IrisCollectRsp extends BaseResDTO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	

}