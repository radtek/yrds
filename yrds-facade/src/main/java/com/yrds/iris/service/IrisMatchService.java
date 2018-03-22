package com.yrds.iris.service;

import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.bean.dto.IrisDeviceDTO;
import com.yrds.iris.bean.dto.IrisMatchRspDTO;

/**
 * 虹膜的匹配服务
 * 
 * @author Eric
 *
 */
public interface IrisMatchService {

    /**
     * 虹膜的匹配
     * 
     * @param req
     * @return
     */
    IrisMatchRspDTO match( IrisMatch req, IrisDeviceDTO dev );
}
