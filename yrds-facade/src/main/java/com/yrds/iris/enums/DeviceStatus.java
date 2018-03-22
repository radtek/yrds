package com.yrds.iris.enums;

/**
 * 设备状态枚举， 0：未注册，1：已注册待审核，2：已注销，3：未登录，4：已登录
 * 
 * @author Eric
 *
 */
public enum DeviceStatus {
    UNREGIST( 0, "未注册" ),
    IN_REVIEW( 1, "已注册待审核" ),
    ABANDON( 2, "已注销" ),
    LOGOUT( 3, "未登录" ),
    LOGIN( 4, "已登录" );

    private Integer code;
    private String  desc;

    private DeviceStatus( Integer code, String desc ) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode( Integer code ) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc( String desc ) {
        this.desc = desc;
    }

}
