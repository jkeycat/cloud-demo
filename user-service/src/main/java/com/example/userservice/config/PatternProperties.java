package com.example.userservice.config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
/*
* nacos配置热跟新的第二种方式
* @ConfigurationProperties(prefix = "pattern")
* */

@Data
@Component
@ConfigurationProperties(prefix = "pattern")
public class PatternProperties {
    private  String dateformat;
    private  String envShareValue;
}
