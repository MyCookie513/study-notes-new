package com.jason.resultMap;


import com.jason.Mapper.Acount;
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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main1 {
    SqlSession session;
    InputStream in;
    static UserMapper userMapper;
    static AcountMapper acountMapper;
    @Before
    public  void Init() throws IOException {

        //1.读取配置文件  : 1.environment :连接池和事务管理者；2.Mapper：DAO 接口方法的映射文件（内有id方法名和sql语句）：
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.由SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3.由sqlSessionFactory创建一个会话；session内部通过执行器来操纵数据库，和executor相关联的是MappedStatement：sql语句，输入参数，输出结果类型；
        session=factory.openSession();
        //4.使用Session创建接口的代理对象；
        userMapper=session.getMapper(UserMapper.class);
        acountMapper=session.getMapper(AcountMapper.class);

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
    public  void SelectByMap()  {
       //5.然后由代理对象执行方法；
        Map<Integer ,Object> map=userMapper.SelectByMap("%love%");
        for(Integer keyname: map.keySet()){
           System.out.println(keyname+map.get(keyname).toString());
        }
    }

    /**
     *
     * @param
     * @throws IOException
     */
    @Test
    public  void Select_user_acount()  {
        //5.然后由代理对象执行方法；
      User user=userMapper.getUserByStep(1);
        System.out.println(user);

        System.out.println(user.getAcount());

    }


    /**
     *查询一个部门中所包含的所有的员工
     * @param
     * @throws IOException
     */
    @Test
    public  void Select_Acount_users()  {
       Acount acount=acountMapper.getAcountByIdStep(1);
        System.out.println(acount.getMoney());
        //System.out.println(acount.getUsers());

    }

}

