package com.yrds.iris.service;

import com.yrds.iris.dto.IrisCollect;
import com.yrds.iris.dto.IrisCollectRsp;
import com.yrds.iris.dto.IrisMatch;
import com.yrds.iris.dto.IrisMatchRsp;

/**
 * 虹膜的采集和匹配服务
 * @author Eric
 *
 */
public interface IrisService {

	/**
	 * 虹膜采集
	 * @param req
	 * @return
	 */
	IrisCollectRsp collect( IrisCollect req) ; 
	
	/**
	 * 虹膜的匹配
	 * @param req
	 * @return
	 */
	IrisMatchRsp match( IrisMatch req) ;
}
