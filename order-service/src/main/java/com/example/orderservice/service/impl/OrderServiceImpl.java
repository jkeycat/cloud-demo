package com.example.orderservice.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.feign.clients.UserClient;
import com.example.feign.pojo.User;
import com.example.orderservice.entity.Order;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.service.IOrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-01
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements IOrderService {
    @Autowired
    private  OrderMapper orderMapper;
//    @Autowired
//    private RestTemplate restTemplate;
    @Autowired
    private UserClient userClient;
    @Override
    public Order queryById(int id) {
        //1.查询订单
        Order order = orderMapper.myQueryById(id);
        //2.利用restTemplate发起http查询用户
        //2.1 url 路径
       // String url="http://localhost:8081/user/"+order.getUserid();
       /* String url="http://user-service/user/"+order.getUserid();
        User user = restTemplate.getForObject(url, User.class);*/
        /*
        * 改为使用feign调用远程接口
        * */
        User user = userClient.findById(order.getUserid());
        //3.封装并返回
        order.setUser(user);
        return order;

    }
}
