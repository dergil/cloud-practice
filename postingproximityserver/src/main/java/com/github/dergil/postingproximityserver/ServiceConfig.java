package com.github.dergil.postingproximityserver;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;


// reads property from property file, which will be read from config server and inject value into class member
@Configuration
@ConfigurationProperties(prefix = "example")
@Getter @Setter
public class ServiceConfig {

  private String property;
    
}