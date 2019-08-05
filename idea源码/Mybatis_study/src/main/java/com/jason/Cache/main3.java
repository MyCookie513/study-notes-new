package com.jason.Cache;


import com.jason.DynamicSQL.UserDynamicSqlMapper;
import com.jason.Mapper.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class main3 {
    SqlSession session;
    InputStream in;
    static  SqlSessionFactory factory;
    static Cache_Mapper cache_mapper;
    static UserDynamicSqlMapper userDynamicSqlMapper;

    @Before
    public  void Init() throws IOException {

        //1.读取配置文件  : 1.environment :连接池和事务管理者；2.Mapper：DAO 接口方法的映射文件（内有id方法名和sql语句）：
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        String s="";
        //2.由SqlSessionFactoryBuilder创建SqlSessionFactory
        factory=new SqlSessionFactoryBuilder().build(in);
        //3.由sqlSessionFactory创建一个会话；session内部通过执行器来操纵数据库，和executor相关联的是MappedStatement：sql语句，输入参数，输出结果类型；
        session=factory.openSession();
        /*fdsf*/
        //4.使用Session创建接口的代理对象；
        cache_mapper=session.getMapper(Cache_Mapper.class);
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
     * 进行对2级缓存进行测试；
     * @param
     * @throws IOException
     */
    @Test
    public  void    SelectTestSecLevelCache()  {
        SqlSession session1=factory.openSession();
        List<User> users2=session1.getMapper(Cache_Mapper.class).TestoneLevelCache();
        for(User user: users2){
            System.out.println(user);
        }
        session1.clearCache();
        session1.close();
       // cache_mapper.Update_user_set(new User(2,1,"niddddddduniu","niuniu",null,null));
        List<User> users=cache_mapper.TestoneLevelCache();
        for(User user: users){
            System.out.println(user);
        }

    }

}

