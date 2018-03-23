package com.yrds.iris.module;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kivi.framework.component.SpringContextHolder;
import com.kivi.framework.util.kit.CollectionKit;
import com.kivi.framework.util.kit.StrKit;
import com.yrds.iris.bean.IrisDataDO;
import com.yrds.iris.bean.IrisMatch;
import com.yrds.iris.persist.model.IrisFeature;
import com.yrds.iris.properties.YrdsProperties;

public class BaseIrisModule {
    private static final Logger log = LoggerFactory.getLogger(BaseIrisModule.class);

    /**
     * 
     * @param sdkName
     * @return
     */
    protected String getSdkLibraryFilePath( String vendor, String sdkName ) {
        // 获取根路径
        YrdsProperties yrdsPorp = SpringContextHolder.getBean(YrdsProperties.class);
        String basePath = yrdsPorp.getSdkLibraryPath();

        // 厂商
        String vd[] = StrKit.split(vendor, StrKit.HYPHEN);

        // 获取操作系统
        String os = "";
        String osName = System.getProperty("os.name");
        if (StrKit.containsIgnoreCase(osName, "windows"))
            os = "windows";
        else if (StrKit.containsIgnoreCase(osName, "centos"))
            os = "centos";
        else if (StrKit.containsIgnoreCase(osName, "redhat"))
            os = "redhat";
        else if (StrKit.containsIgnoreCase(osName, "suse"))
            os = "suse";
        else if (StrKit.containsIgnoreCase(osName, "ubuntu"))
            os = "ubuntu";
        else if (StrKit.containsIgnoreCase(osName, "fedora"))
            os = "fedora";
        else if (StrKit.containsIgnoreCase(osName, "mac"))
            os = "mac";
        else
            os = "unkwon";

        // 获取JDK位数，加载对应版本的SDK
        String arch = System.getProperty("sun.arch.data.model");

        String sdkFilePath = StrKit.join("/", basePath, vd[0], os, arch, sdkName);

        log.info("SDK路径 ： {}" + sdkFilePath);

        return sdkFilePath;
    }

    protected List<byte[]> getTemplateAList( IrisMatch req ) {
        List<byte[]> templateAList = CollectionKit.newArrayList();
        Iterator<IrisDataDO> it = req.getFeatureList().iterator();
        while (it.hasNext()) {
            byte[] templateA;
            IrisDataDO irisA = it.next();
            if (StrKit.isNotEmpty(irisA.getFeatureLeftBase64())) {
                templateA = Base64.decodeBase64(irisA.getFeatureLeftBase64());
                templateAList.add(templateA);
            }
            if (StrKit.isNotEmpty(irisA.getFeatureRightBase64())) {
                templateA = Base64.decodeBase64(irisA.getFeatureRightBase64());
                templateAList.add(templateA);
            }
        }

        return templateAList;
    }

    protected Map<Long, byte[]> getTemplateBList( List<IrisFeature> list ) {
        Map<Long, byte[]> templateBList = CollectionKit.newHashMap();
        Iterator<IrisFeature> it = list.iterator();
        while (it.hasNext()) {
            IrisFeature irisB = it.next();
            if (irisB.getFeatureLData() != null)
                templateBList.put(irisB.getId(), irisB.getFeatureLData());

            if (irisB.getFeatureRData() != null)
                templateBList.put(irisB.getId(), irisB.getFeatureRData());
        }

        return templateBList;
    }

}
