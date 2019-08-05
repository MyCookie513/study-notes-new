package com.jason.client;

import com.jason.pojo.User;
import org.springframework.stereotype.Component;

@Component
public class UserClientImpl implements UserClient{
    @Override
    public User queryuser(Long id) {
        User user=new User();
        user.setName("网络繁忙，请稍后再试");
        return user;
    }
}
