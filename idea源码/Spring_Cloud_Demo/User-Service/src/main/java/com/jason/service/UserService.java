package com.jason.service;

import com.jason.mapper.UserMapper;
import com.jason.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User getUser(Long id){

        return userMapper.selectByPrimaryKey(id);
    }

}
