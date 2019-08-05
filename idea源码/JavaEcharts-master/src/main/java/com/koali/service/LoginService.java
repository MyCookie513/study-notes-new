package com.koali.service;

import com.koali.model.User;

import java.util.Map;

public interface LoginService {
    Map<String, Object> login(String loginname, String password);

}
