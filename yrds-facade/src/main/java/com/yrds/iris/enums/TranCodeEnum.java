package com.yrds.iris.enums;

public enum TranCodeEnum {
    REGIST( "0001", "注册" ),
    LOGIN( "0002", "登录" ),
    HEARTBEAT( "0003", "心跳" ),
    IRIS_COLLECT( "1000", "虹膜采集" ),
    IRIS_MATCH( "1001", "虹膜比对" );

    private String code;
    private String desc;

    private TranCodeEnum( String code, String desc ) {
        this.code = code;
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode( String code ) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc( String desc ) {
        this.desc = desc;
    }

}
