package com.jason.Cache;

import com.jason.Mapper.User;

import java.util.List;

public interface Cache_Mapper {


    List<User> TestoneLevelCache();
    void Update_user_set(User user);

}
