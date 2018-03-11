package com.yrds.iris;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kivi.framework.annotation.EnableKiviFramework;
import com.kivi.framework.constant.KiviFramework;
import com.kivi.framework.dubbo.annotation.DubboApplication;

@EnableKiviFramework
@EnableAutoConfiguration
@MapperScan(basePackages={KiviFramework.MapperScan.KTF_MAPPER_SCAN,"com.yrdis.**.persist"})
@DubboApplication
@SpringBootApplication
public class Application {

    public static void main( String[] args ) {
        SpringApplication application = new SpringApplication(Application.class);
        application.run(args);
    }

}
