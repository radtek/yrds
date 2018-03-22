package com.yrds.iris.service;

import com.yrds.iris.bean.IrisCollect;
import com.yrds.iris.bean.IrisCollectRsp;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.bean.IrisMatchRsp;

/**
 * 虹膜的采集和匹配服务
 * 
 * @author Eric
 *
 */
public interface IrisBizService {

    /**
     * 虹膜采集
     * 
     * @param req
     * @return
     */
    IrisCollectRsp collect( IrisCollect req );

    /**
     * 虹膜的匹配
     * 
     * @param req
     * @return
     */
    IrisMatchRsp match( IrisMatch req );

}
