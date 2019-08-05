package com.jason.mapper;


import com.jason.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class userMapperTest {

    @Autowired
    private userMapper userMapper;

    @Test
    public void testQuuery(){
        User user=this.userMapper.selectByPrimaryKey(1);
        System.out.println(user);
    }

}