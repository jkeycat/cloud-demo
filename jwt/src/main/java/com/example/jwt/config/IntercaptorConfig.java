package com.example.jwt.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
@Configuration
public class IntercaptorConfig implements WebMvcConfigurer {
    @Override
    public  void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new JWTIntercepter())
                //拦截的路径
                .addPathPatterns("/**")
                //排除登录接口
                .excludePathPatterns("/user/login");

    }
}
*/
