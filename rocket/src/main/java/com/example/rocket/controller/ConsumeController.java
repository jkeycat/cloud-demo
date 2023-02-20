package com.example.rocket.controller;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "TopicTest", consumerGroup = "consumerGroupTest")
@Slf4j
public class ConsumeController implements RocketMQListener<String> {
    @Override
    public void onMessage(String message) {
        log.info("------- Consumer: {}",message);
    }
}
