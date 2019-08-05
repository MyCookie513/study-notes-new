package com.jason.DynamicSQL;


import com.jason.Mapper.Acount;
import com.jason.Mapper.User;
import com.jason.resultMap.AcountMapper;
import com.jason.resultMap.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class main2 {
    SqlSession session;
    InputStream in;
    static UserMapper userMapper;
    static UserDynamicSqlMapper userDynamicSqlMapper;
    static AcountMapper acountMapper;
    SqlSessionFactory factory;
    @Before
    public  void Init() throws IOException {

        //1.读取配置文件  : 1.environment :连接池和事务管理者；2.Mapper：DAO 接口方法的映射文件（内有id方法名和sql语句）：
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.由SqlSessionFactoryBuilder创建SqlSessionFactory
        factory=new SqlSessionFactoryBuilder().build(in);
        //3.由sqlSessionFactory创建一个会话；session内部通过执行器来操纵数据库，和executor相关联的是MappedStatement：sql语句，输入参数，输出结果类型；
        session=factory.openSession();
        //4.使用Session创建接口的代理对象；
        userMapper=session.getMapper(UserMapper.class);
        acountMapper=session.getMapper(AcountMapper.class);
        userDynamicSqlMapper=session.getMapper(UserDynamicSqlMapper.class);
    }
    @After
    public void Destory() throws IOException {
        /*进行事务的提交*/
        session.commit();
        //6.释放资源；
        session.close();
        in.close();


    }


    /**
     * 测试查询一个表的功能
     * @param
     * @throws IOException
     */
    @Test
    public  void SelectUserByDynamicIF()  {
        User user =new User ();

       user.setIdt_user(2);

       //5.然后由代理对象执行方法；
        List<User> users=userDynamicSqlMapper.SelectUserByDynamic_Choose(user);
        for(User u: users){
           System.out.println(u);
        }
    }


    /**
     * 利用set标签进行插入数据；
     * @param
     * @throws IOException
     */
    @Test
    public  void UPDATE ()  {
        User user =new User ();

        user.setIdt_user(2);
        user.setT_usercol(2);
        user.setT_username("张三");
        user.setT_password("dfs");
        //5.然后由代理对象执行方法；
        userDynamicSqlMapper.Update_user_set(user);

    }
    /**
     * foreach   进行123查询
     * @param
     * @throws IOException
     */
    @Test
    public  void chaxun123  ()  {

       List<User> list= userDynamicSqlMapper.SelectUserByDy123(Arrays.asList(1,2,3));
       for(User user: list){
           System.out.println(user);
       }

    }

    /**
     * foreach   进行批量保存
     * @param
     * @throws IOException
     */
    @Test
    public  void    foreachSave()  {
        List<User> users=new ArrayList<User>();
        users.add(new User(2,"username" ,"1235689" ,new Date(),new Acount(1)));
        users.add(new User(1,"username1" ,"1235689" ,new Date(),new Acount(1)));
        users.add(new User(1,"username2" ,"1235689" ,new Date(),new Acount(1)));

        userDynamicSqlMapper.AddUsers(users);

    }
    /**
     * foreach   进行批量保存
     * @param
     * @throws IOException
     */
    @Test
    public  void    BatchSave()  {
        SqlSession session=factory.openSession(ExecutorType.BATCH);
        UserDynamicSqlMapper userBatchmapper=session.getMapper(UserDynamicSqlMapper.class);

       for(int i=0;i<100;i++){
           userBatchmapper.BatchSave(new User(2,UUID.randomUUID().toString().substring(0,5) ,"1235689" ,new Date(),new Acount(1)));

       }


    }
    /**
     * foreach   进行批量保存
     * @param
     * @throws IOException
     */
    @Test
    public  void    SelectDynamictestBind()  {


        List<User> users=userDynamicSqlMapper.SelectDynamictestBind("高");
        for(User user: users){
            System.out.println(user);
        }

    }





}

