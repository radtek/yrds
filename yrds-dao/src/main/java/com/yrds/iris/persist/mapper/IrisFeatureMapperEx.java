package com.yrds.iris.persist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yrds.iris.persist.model.IrisFeature;

public interface IrisFeatureMapperEx {
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
     * @return
     */
    List<IrisFeature> listByPage( @Param( "userId" ) String userId,
            @Param( "slotId" ) Integer slotId,
            @Param( "slotCount" ) Integer slotCount );

    /**
     * 更新匹配成功计数
     * 
     * @param entity
     * @return
     */
    int updateMatchCount( IrisFeature entity );
}
