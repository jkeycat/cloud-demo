package com.example.feign.fallback;

import com.example.feign.clients.UserClient;
import com.example.feign.pojo.User;
import feign.hystrix.FallbackFactory;


public class UserClientFallbackFactory implements FallbackFactory<UserClient> {
    @Override
    public UserClient create(Throwable throwable) {
        return new UserClient() {
            @Override
            public User findById(int id) {
                System.out.println("查询用户异常");
                return new User();
            }
        };
    }
}
