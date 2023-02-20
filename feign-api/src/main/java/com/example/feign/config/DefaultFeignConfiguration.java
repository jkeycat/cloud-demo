package com.example.feign.config;


import com.example.feign.fallback.UserClientFallbackFactory;
import org.springframework.context.annotation.Bean;


public class DefaultFeignConfiguration {
    @Bean
    public UserClientFallbackFactory userClientFallbackFactory(){
        return  new UserClientFallbackFactory();
    }
}
