/**
 * 
 */
package com.yrds.iris.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.yrds.iris.bean.IrisDeviceImport;
import com.yrds.iris.bean.IrisDeviceImportRsp;
import com.yrds.iris.bean.IrisDeviceLogin;
import com.yrds.iris.bean.IrisDeviceLoginRsp;
import com.yrds.iris.bean.IrisDeviceReg;
import com.yrds.iris.bean.IrisDeviceRegRsp;
import com.yrds.iris.service.IrisDeviceService;

/**
 * @author Eric
 *
 */
@Service
public class IrisDeviceServiceImpl implements IrisDeviceService {

    private static final Logger log = LoggerFactory.getLogger(IrisDeviceServiceImpl.class);

    @Override
    public IrisDeviceRegRsp regist( IrisDeviceReg req, String clientIp ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IrisDeviceLoginRsp login( IrisDeviceLogin req, String clientIp ) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public IrisDeviceImportRsp importBatch( IrisDeviceImport req ) {
        // TODO Auto-generated method stub
        return null;
    }

}
