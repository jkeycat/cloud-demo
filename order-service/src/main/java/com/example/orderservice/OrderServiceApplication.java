package com.example.orderservice;

import com.example.feign.clients.UserClient;

import com.example.feign.config.DefaultFeignConfiguration;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;
/*
* 当feignClient不在SpringBootApplication的扫描包范围时，这些client无法使用。
* 可以指定feignClient所在包或者字节码
* @EnableFeignClients(basePackages ="com.example.feign.clients")
* @EnableFeignClients(clients = UserClient.class)
* defaultConfiguration = DefaultFeignConfiguration.class
* */
@SpringBootApplication
@EnableFeignClients(clients = UserClient.class,defaultConfiguration = DefaultFeignConfiguration.class)
public class OrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderServiceApplication.class, args);
    }

    /*
    * 创建RestTemplate并注入spring 容器
    * */

   /* @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }*/

    //自定义ribon的负载均衡策略
   /* @Bean
    public IRule randomRule(){
        return  new RandomRule();
    }*/

}
