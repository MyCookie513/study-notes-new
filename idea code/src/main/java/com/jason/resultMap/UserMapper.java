package com.jason.resultMap;

import com.jason.Mapper.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import javax.swing.*;
import java.util.List;
import java.util.Map;

public interface UserMapper {




    @MapKey("idt_user")
    Map<Integer,Object>  SelectByMap(String username);


    User Select_user_acount(int id );

    User getUserByStep(int id );


    List<User> getUsersByacoutstep2(int id );


}




