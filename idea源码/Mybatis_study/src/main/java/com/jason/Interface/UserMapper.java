package com.jason.Interface;

import com.jason.Mapper.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;
import java.util.Map;

public interface UserMapper {


    /*查询表中的所有的数据*/
    List<User> findAll();

    @MapKey("idt_user")
    Map<Integer,Object>  SelectByMap(String username);


    /*查询表中的单个数据*/
    User findone(int id);

    void SaveUser(User user);

    @Update("update t_user set t_username=#{t_username},t_password=#{t_password},t_usercol=#{t_usercol},date=#{date} where idt_user=#{idt_user};")
    void UpdateUser(User user);

    void DeleteUser(int id);

    List<User> FindByname(String name);

    /*多个参数注入的查询处理*/

    User SelectByIDAndname(@Param("id") int id, @Param("name") String name);

    User SelectByIDAndname_Map(Map<String, Object> map);

}




