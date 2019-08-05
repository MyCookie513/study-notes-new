package com.jason.Service;

import com.jason.mapper.userMapper;
import com.jason.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private userMapper userMapper;

    @Transactional
    public User QueryById(Long id ){
        return this.userMapper.selectByPrimaryKey(id);
    }
    @Transactional
    public void insertUser(User user){
        this.userMapper.insert(user);
    }

    public List<User> queryAll() {
        return this.userMapper.selectAll();
    }
}
