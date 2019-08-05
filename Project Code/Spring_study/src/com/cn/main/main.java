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
	        
	    	Resource resource = new ClassPathResource("applicationContext.xml");            //װ�������ļ�
	        BeanFactory factory = new XmlBeanFactory(resource);
	        User user = (User) factory.getBean("user");                                    //��ȡBean
	        user.printInfo();//���JavaBean������ֵ
	        UserDAO userDAO = (UserDAO) factory.getBean("userDAO");//��ȡUserDAO
	        userDAO.inserUser(user);//ִ����ӷ���
	        System.out.println("������ӳɹ�!!!");        
	    }   
	
}
