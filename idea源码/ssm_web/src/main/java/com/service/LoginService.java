package com.service;

import java.util.Map;

public interface LoginService {
    Map<String, Object> login(String loginname, String password);
}
