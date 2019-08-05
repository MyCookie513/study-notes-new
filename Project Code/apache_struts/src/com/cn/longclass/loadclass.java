package com.cn.longclass;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.longclass.test_hibernate;

public class loadclass {
	//利用load方法加载对象
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		List emplist = new ArrayList();//实例化List信息集合
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			
			//进行查询操作
			String hql = "from test_hibernate emp";// 查询HQL语句
	        Query q = session.createQuery(hql);// 执行查询操作
	        emplist = q.list();//将返回的对象转化为List集合
			for (int i = 0; i < emplist.size(); i++) {
			test_hibernate emp = (test_hibernate) emplist.get(i);
			System.out.println("产品ID："+emp.getId());
			System.out.println("产品名称："+emp.getString_hibernate());
		}	            
	            //进行更新操作
//				session.beginTransaction();//开启事务
//				test_hibernate employee = (test_hibernate)session.load(test_hibernate.class,new Integer("1") );//修改操作
//				employee.setString_hibernate("wjosijdsifjsifj");;
//				session.getTransaction().commit();//提交事务
	            
//			    session.beginTransaction();//开启事务
//			    test_hibernate product = (test_hibernate) session.get(test_hibernate.class, new Integer("2"));//装载对象
//	            session.delete(product);//删除持久化信息
//				session.flush();//强制刷新提交
//				session.getTransaction().commit();//提交事务
//				
			
			

		} catch (Exception e) {
			System.out.println("对象装载失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}

}
