package com.yrds.iris.constant;

import com.kivi.framework.constant.GlobalErrorConst;

public class YrdsError extends GlobalErrorConst {
    /** 交易代码不支持 */
    public static final String E_IR_TRANCODE_NOT_SUPPORT = "ER000001";

    /** 虹膜数据为空 */
    public static final String E_IR_NO_IRIS              = "ER000002";

    /** 虹膜SDK初始化失败 */
    public static final String E_IR_SDK_INIT             = "ER000003";

    /** 虹膜SDK创建模板失败 */
    public static final String E_IR_SDK_CREATE_TEMPLETE  = "ER000004";

    /** 虹膜SDK比对失败 */
    public static final String E_IR_SDK_MATCH_IRIS       = "ER000005";

}
