package com.example.orderservice.sentinel;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.RequestOriginParser;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
/*
* 配合gateway请求头
* */
@Component
public class HeadOriginParser implements RequestOriginParser {
    @Override
    public String parseOrigin(HttpServletRequest httpServletRequest) {
        //1.尝试获取请求头
        String origin = httpServletRequest.getHeader("origin");
        //2.非空判断
        if(StringUtils.isEmpty(origin)){
            origin="blank";
        }
        return origin;
    }
}
