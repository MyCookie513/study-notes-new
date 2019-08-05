package com.cn.main;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import com.cn.bean.Manger;
import com.cn.bean.User;
import com.cn.bean.UserDAO;
public class main {
	
	    
	    public static void main(String[] args) {
	        
	    	Resource resource = new ClassPathResource("applicationContext.xml");            //装载配置文件
	        BeanFactory factory = new XmlBeanFactory(resource);
	        User user = (User) factory.getBean("user");                                    //获取Bean
	        user.printInfo();//输出JavaBean的属性值
	        UserDAO userDAO = (UserDAO) factory.getBean("userDAO");//获取UserDAO
	        userDAO.inserUser(user);//执行添加方法
	        System.out.println("数据添加成功!!!");        
	    }   
	
}
