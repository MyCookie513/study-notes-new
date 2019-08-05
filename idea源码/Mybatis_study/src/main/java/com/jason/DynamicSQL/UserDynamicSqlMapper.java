package com.jason.DynamicSQL;

import com.jason.Mapper.User;
import jdk.internal.dynalink.linker.LinkerServices;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserDynamicSqlMapper {


     /*利用if语句进行条件判定查询；*/
     List<User> SelectUserByDynamicIF(User user);
     /*利用choose标签进行选择符合条件查询；*/
      List<User> SelectUserByDynamic_Choose(User user);
      /*利用利用set标签进行更新操作*/
      void Update_user_set(User user);
      List<User> SelectUserByDy123(List<Integer> Inlist);
      void AddUsers(@Param("users") List<User> users);
      void BatchSave(User user);
      /*利用bind标签可以利用OGNL表达式创建一个变量并把它绑到一个上下文中*/

    List<User>  SelectDynamictestBind(@Param("t_username") String str);

}
