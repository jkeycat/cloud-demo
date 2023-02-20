package com.example.orderservice.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.feign.pojo.User;
import lombok.Data;

import java.io.Serializable;


/**
 * <p>
 * 
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-01
 */

@Data
@TableName("tb_order")
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer userid;

    private String name;

    private Integer price;

    private Integer num;

    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "Order{" +
            "id=" + id +
            ", userid=" + userid +
            ", name=" + name +
            ", price=" + price +
            ", num=" + num +
        "}";
    }
}
