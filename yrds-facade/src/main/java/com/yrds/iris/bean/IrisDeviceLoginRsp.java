package com.yrds.iris.bean;

import com.kivi.framework.dto.BaseResDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
/**
 * 虹膜设备登录响应
 * @author Eric
 *
 */
@ApiModel( value = "IrisDeviceLogin", description = "虹膜设备登录响应" )
@Setter
@Getter
public class IrisDeviceLoginRsp extends BaseResDTO{

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
     * 许可token
     */
	@ApiModelProperty(
            value = "许可token，后续操作接口需带上它，才能调用成功",
            required = true,
            dataType = "String",
            example = "00000000000000000000000000000000" )
    private String accessToken;

}