package com.example.orderservice.service;

import com.example.orderservice.entity.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-01
 */
public interface IOrderService extends IService<Order> {
     public  Order  queryById(int id);
}
