package com.yrds.iris.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Configuration
@ConfigurationProperties( prefix = "yrds.iris" )
public class YrdsProperties {
    private String sdkLibraryPath;
}
