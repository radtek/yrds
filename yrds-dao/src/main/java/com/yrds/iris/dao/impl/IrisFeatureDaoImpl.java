package com.yrds.iris.dao.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kivi.framework.db.dao.BaseDao;
import com.kivi.framework.db.page.PageInfoKtf;
import com.kivi.framework.exception.AppException;
import com.kivi.framework.util.kit.DateTimeKit;
import com.kivi.framework.vo.page.PageReqVO;
import com.yrds.iris.constant.YrdsError;
import com.yrds.iris.dao.IrisFeatureDao;
import com.yrds.iris.persist.mapper.IrisFeatureMapperEx;
import com.yrds.iris.persist.model.IrisFeature;

@Repository
public class IrisFeatureDaoImpl extends BaseDao<IrisFeature> implements IrisFeatureDao {

    @Autowired
    private IrisFeatureMapperEx irisFeatureMapperEx;

    @Override
    public int saveNotNull( List<IrisFeature> list ) {
        int row = 0;
        try {
            row = irisFeatureMapperEx.saveNotNull(list);
        }
        catch (Exception e) {
            throw new AppException(YrdsError.E_DB_INSERT, e);
        }
        return row;
    }

    @Override
    public PageInfoKtf<IrisFeature> listByPage( String userId, Integer slotId, Integer slotCount, PageReqVO pageReq ) {
        int page = pageReq.getOffset() / pageReq.getLimit() + 1;
        PageHelper.startPage(page, pageReq.getLimit());
        List<IrisFeature> list = irisFeatureMapperEx.listByPage(userId, slotId, slotCount);
        return new PageInfoKtf<IrisFeature>(new PageInfo<>(list));
    }

    @Override
    public int updateMatchCount( Long id, Date matchTime ) {
        IrisFeature entity = new IrisFeature();
        entity.setId(id);
        entity.setMatchTime(matchTime);
        entity.setGmtUpdate(DateTimeKit.date());
        int row = irisFeatureMapperEx.updateMatchCount(entity);
        if (row == 0) {
            throw new AppException(YrdsError.E_DB_UPDATE_ROW);
        }

        return row;
    }

}
