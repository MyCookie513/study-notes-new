package com.jason.generator;


import com.jason.Mapper.Acount;
import com.jason.Mapper.User;
import com.jason.generator.javaBean.CustomerExample;
import com.jason.resultMap.UserMapper;
import com.jason.generator.javaBean.Customer;
import com.jason.generator.mappers.CustomerMapper;
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
import java.util.Map;

public class mainMBG {
    SqlSession session;


    InputStream in;
    static CustomerMapper customerMapper;
    UserMapper userMapper;
    @Before
    public  void Init() throws IOException {

        //1.读取配置文件  : 1.environment :连接池和事务管理者；2.Mapper：DAO 接口方法的映射文件（内有id方法名和sql语句）：
        in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.由SqlSessionFactoryBuilder创建SqlSessionFactory
        SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(in);
        //3.由sqlSessionFactory创建一个会话；session内部通过执行器来操纵数据库，和executor相关联的是MappedStatement：sql语句，输入参数，输出结果类型；
        session=factory.openSession();
        //4.使用Session创建接口的代理对象；
        customerMapper=session.getMapper(CustomerMapper.class);
       // acountMapper=session.getMapper(AcountMapper.class);

    }
    @After
    public void Destory() throws IOException {


        session.commit();
        //6.释放资源；
        session.close();
        in.close();


    }

    /**
     * 查询条件是  查询是一个男生而且名字中带有u的模糊查询
     */

    @Test
    public  void test()  {
         //封装员工查询条件的example： 模型，实例；
        CustomerExample customerExample =new CustomerExample();
        //创建一个查询标准，这个criteria 就是拼装查询条件
        CustomerExample.Criteria criteria=customerExample.createCriteria();
        criteria.andNameLike("%u%");
        criteria.andSexEqualTo("男");

        /*如果想表现或者的关系：则就需要另创建一个criteria 查询条件 */
        CustomerExample.Criteria criteria1=customerExample.createCriteria();
        criteria1.andAgeBetween(10,12);
         /*将条件封装到 customerExample 中 or进去 第一个形成的查询条件不用装载，默认装载*/
        customerExample.or(criteria1);



        List<Customer> customers =customerMapper.selectByExample(customerExample);
        for(Customer c: customers){
            System.out.println(c);
        }
    }


}

