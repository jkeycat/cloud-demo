package com.example.orderservice.mapper;

import com.example.orderservice.entity.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-01
 */
@Repository
public interface OrderMapper extends BaseMapper<Order> {
   public Order  myQueryById(int id);
}
