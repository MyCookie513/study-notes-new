package com.koali.service.Impl;



import com.koali.dao.UserMapper;
import com.koali.model.User;
import com.koali.service.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserMapper userMapper;



    public Map<String, Object> login(String loginname, String password) {
        System.out.println(loginname+"//"+password);
        HashMap<String, Object> mm =new HashMap<String, Object>();
        List<User> users = userMapper.login(loginname);
        String msg = "";
        if ((users.size() == 0)) {
            mm.put("status", "401");
            mm.put(msg, "用户不存在!");
            System.out.println(mm.get(msg));
        }else{
            User user = users.get(0);
            System.out.println(user);
            mm.put("user",user);
            if (!password.equals(user.getPassword())) {
                mm.put("status", "401");
                mm.put(msg, "密码错误！");
            } else {
                mm.put("status", "200");
                mm.put(msg, "登陆成功!");
            }
        }

        return mm;
    }
}
