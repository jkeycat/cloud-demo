package com.example.rocket.controller;


import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/mq")
public class ProducerController {
    @Resource
    private RocketMQTemplate rocketMQTemplate;
    @RequestMapping("/send")
    public String testSend(String msg) {
        try {
            rocketMQTemplate.convertAndSend("TopicTest", msg);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }
}
