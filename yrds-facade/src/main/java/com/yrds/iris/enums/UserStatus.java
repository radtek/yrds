package com.yrds.iris.enums;

public enum UserStatus {
    INIT( 0, "init" ), ENABLED( 1, "enabled" ), LOCKED( 2, "locked" ), DISABLED( 3, "disabled" );

    private UserStatus( int code, String desc ) {
        this.code = code;
        this.desc = desc;
    }

    public int    code;
    public String desc;

    public static String valueOf( Integer status ) {
        if (status == null) {
            return "";
        }
        else {
            for (UserStatus s : UserStatus.values()) {
                if (s.code == status) {
                    return s.desc;
                }
            }
            return "";
        }
    }

}
