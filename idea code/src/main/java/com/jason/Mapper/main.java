package com.jason.Mapper;

import com.jason.Interface.UserMapper;
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

public class main {
    SqlSession session;
    InputStream in;
    static UserMapper userMapper;
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

    }
    @After
    public void Destory() throws IOException {
        /*进行事务的提交*/
        session.commit();
        //6.释放资源；
        session.close();
        in.close();


    }

    @Test
    public  void SelectByIDAndname(){
        Map<String,Object> map =new HashMap<String, Object>();
        map.put("id",1);
        map.put("name","高晓学");
        User user=userMapper.SelectByIDAndname_Map(map);
        System.out.println(user);
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
     * 测试查询一个表的功能
     * @param
     * @throws IOException
     */
    @Test
    public  void Selectall() throws IOException {
        //5.然后由代理对象执行方法；
        List<User> users=userMapper.findAll();
        for(User user: users){
            System.out.println(user);
        }
    }
    /**
     * 测试查询单条记录的操作
     * @throws IOException
     */
    @Test
    public  void SelectOne() throws IOException {
        //5.然后由代理对象执行方法；
        User user=userMapper.findone(1);
        System.out.println(user);
    }

    /**
     * 测试保存一条记录的操作
     * @throws IOException
     */
    @Test
    public void SaveUser()  {
        User user=new User();
        user .setDate(new Date());

        user.setT_password("520");
        user.setT_username("jason");
        userMapper.SaveUser(user);
        System.out.println(user.getIdt_user());
    }

    /**
     * 更新一条记录的操作
     * @throws IOException
     */
    @Test
    public void UpdateUser() {
        User user=new User();
        user .setDate(new Date());
        user.setIdt_user(6);
        user.setT_password("");
        user.setT_username("小明");
        userMapper.UpdateUser(user);
    }


    /**
     * 更新一条记录的操作
     * @throws IOException
     */
    @Test
    public void DeleteUser() {

        userMapper.DeleteUser(2);
    }

    /**
     * 更新一条记录的操作
     * @throws IOException
     */
    @Test
    public void FindByname() {

       List<User> list=userMapper.FindByname("%j%");
       for(User user: list){
           System.out.println(user);
       }
    }






}
