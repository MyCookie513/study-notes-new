package com.koali.service.Impl;

import com.koali.dao.user_signMapper;
import com.koali.model.user_sign;
import com.koali.service.User_signServaice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class User_SignImpl implements User_signServaice {
    @Autowired
    private user_signMapper user_signMapper;


    public List<user_sign> getallUser_sign() {
        List<user_sign> list=user_signMapper.selectall();
        return list;
    }
}
