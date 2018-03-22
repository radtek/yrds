package com.yrds.iris.bean;

import java.util.List;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 虹膜比对请求
 * 
 * @author Eric
 *
 */
@ApiModel( value = "IrisMatch", description = "虹膜比对请求" )
@Setter
@Getter
public class IrisMatch extends IrisDeviceHeartbeat {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 虹膜模板数据
     */
    @ApiModelProperty(
                       value = "虹膜模板数据",
                       required = true,
                       dataType = "List",
                       example = "" )
    private List<IrisDataDO>  featureList;

    /**
     * 虹膜算法名称
     */
    @ApiModelProperty(
                       value = "虹膜算法名称",
                       required = false,
                       dataType = "String",
                       example = "alg.1" )
    private String            algName;

    /**
     * 虹膜算法版本号
     */
    @ApiModelProperty(
                       value = "虹膜算法版本号",
                       required = false,
                       dataType = "String",
                       example = "1.0.0" )
    @Size( max = 10, message = "虹膜算法版本号最大长度不能超过10位" )
    private String            algVersion;

}
