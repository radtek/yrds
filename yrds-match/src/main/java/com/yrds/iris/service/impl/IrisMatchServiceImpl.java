package com.yrds.iris.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kivi.framework.db.page.PageInfoKtf;
import com.kivi.framework.service.KtfNameService;
import com.kivi.framework.vo.page.PageReqVO;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.bean.dto.IrisDeviceDTO;
import com.yrds.iris.bean.dto.IrisMatchRspDTO;
import com.yrds.iris.dao.IrisFeatureDao;
import com.yrds.iris.persist.model.IrisFeature;
import com.yrds.iris.service.IrisMatchService;

@Service
public class IrisMatchServiceImpl implements IrisMatchService {

    @Autowired
    private KtfNameService ktfNameService;

    @Autowired
    private IrisFeatureDao irisFeatureDao;

    @Override
    public IrisMatchRspDTO match( IrisMatch req, IrisDeviceDTO dev ) {
        int slotId = ktfNameService.index();
        int slotCount = ktfNameService.countOnline();
        int offset = 0;
        PageReqVO pageReq = new PageReqVO(500, offset, null, null);

        PageInfoKtf<IrisFeature> page = null;
        do {
            page = irisFeatureDao.listByPage(null, slotId, slotCount, pageReq);

            // TODO 添加虹膜匹配的代码
        }
        while (page != null && !page.getIsLastPage());

        return null;
    }

}
