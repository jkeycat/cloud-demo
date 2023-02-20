package com.example.userservice.service;

import com.example.userservice.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author xieqiao
 * @since 2022-11-01
 */
public interface IUserService extends IService<User> {
    public  User  queryById(int id);
}
