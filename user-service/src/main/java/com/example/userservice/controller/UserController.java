package com.example.userservice.controller;


import com.example.userservice.config.PatternProperties;
import com.example.userservice.entity.User;
import com.example.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-01
 * @RefreshScope 在value的注解的类上加上该注解，可以实现配置的热更新
 */
@RestController
@RequestMapping("/user")
/*@RefreshScope*/
public class UserController {
    @Autowired
    private PatternProperties patternProperties;
    @Autowired
    IUserService userService;
    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") int id ){
        return  userService.queryById(id);
    }
    /*
    * 通过value注解读取nacos上的配置
    * */
   /* @Value("${pattern.dateformat}")
    private  String dateformat;*/
    @GetMapping("now")
    public  String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(patternProperties.getDateformat()));
    }
    @GetMapping("prop")
    public  PatternProperties patternProperties(){
        return  patternProperties;
    }
}
