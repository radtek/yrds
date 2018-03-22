package com.yrds.iris.dao;

import java.util.Date;
import java.util.List;

import com.kivi.framework.db.dao.IDao;
import com.kivi.framework.db.page.PageInfoKtf;
import com.kivi.framework.vo.page.PageReqVO;
import com.yrds.iris.persist.model.IrisFeature;

public interface IrisFeatureDao extends IDao<IrisFeature> {

    /**
     * 批量保存
     * 
     * @param list
     * @return
     */
    int saveNotNull( List<IrisFeature> list );

    /**
     * 根据用户ID和slot分页查询
     * 
     * @param userId
     * @param slotId
     * @param slotCount
     * @return
     */
    PageInfoKtf<IrisFeature> listByPage( String userId, Integer slotId, Integer slotCount, PageReqVO pageReq );

    /**
     * 更新匹配成功计数
     * 
     * @param id
     * @param matchTime
     * @return
     */
    int updateMatchCount( Long id, Date matchTime );
}
