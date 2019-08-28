package com.jason.service;

import com.jason.mapper.UserMapper;
import com.jason.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User getUser(Long id){

        return userMapper.selectByPrimaryKey(id);
    }
    public static void main(String[] args) throws Exception{
        ClassLoader classLoader=ClassLoader.getSystemClassLoader();
        Class clazz=classLoader.loadClass("A");
        System.out.print("Test");
        clazz.forName("A");
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 15, TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5), new ThreadPoolExecutor.CallerRunsPolicy());
    }

}

class Test2{
    static {
        System.out.print("OK");
    }

    public static final String a="JD";

}