package com.yrds.iris.module;

import java.util.List;

import com.kivi.framework.exception.AppException;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.persist.model.IrisFeature;

public interface IIrisModule {

    /**
     * Iris 厂商提供的SDK库的名字
     * 
     * @return
     */
    String sdkName();

    /**
     * 厂商
     * 
     * @return
     */
    String vendor();

    /**
     * 初始化设备
     */
    void init() throws AppException;

    /**
     * 关闭设备
     */
    void close() throws AppException;

    /**
     * 虹膜匹配
     * 
     * @param req
     *            待匹配的虹膜
     * @param list
     *            虹膜库数据列表
     * @return
     */
    List<IrisFeature> match( IrisMatch req, List<IrisFeature> list );
}
