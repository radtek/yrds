package com.yrds.iris.bean;

import java.util.List;

import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * 虹膜采集请求
 * 
 * @author Eric
 *
 */
@ApiModel( value = "IrisCollect", description = "虹膜采集请求" )
@Setter
@Getter
public class IrisCollect extends IrisDeviceHeartbeat {

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
    @Size( max = 16, message = "员工编号最大长度不能超过16字节" )
    private String            staffId;

    /**
     * 员工姓名
     */
    @ApiModelProperty(
                       value = "员工姓名",
                       required = false,
                       dataType = "String",
                       example = "张三" )
    @Size( max = 64, message = "员工姓名最大长度不能超过63字节" )
    private String            staffName;

    /**
     * 采集的虹膜信息
     */
    @ApiModelProperty(
                       value = "虹膜信息列表",
                       required = true,
                       dataType = "List",
                       example = "" )
    private List<IrisDataDO>  irisList;

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
