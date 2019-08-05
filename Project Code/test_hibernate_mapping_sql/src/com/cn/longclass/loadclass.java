package com.cn.longclass;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.longclass.test_hibernate;
import com.cn.product.*;
public class loadclass {
	//利用load方法加载对象
	public static void main(String[] args) {
		Session session = null;			//声明Session对象
		Session session0 = null;
		List emplist = new ArrayList();//实例化List信息集合
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			
			//进行查询操作
//		  	String hql = "from test_hibernate emp";// 查询HQL语句
//	        Query q = session.createQuery(hql);// 执行查询操作
//	        emplist = q.list();//将返回的对象转化为List集合
//			for (int i = 0; i < emplist.size(); i++) {
//			test_hibernate emp = (test_hibernate) emplist.get(i);
//			System.out.println("产品ID："+emp.getId());
//			System.out.println("产品名称："+emp.getString_hibernate());
//		}	        
			
			//进行单个查询操作
//			product employeeVO = (product)session.get(product.class, new Integer("5"));//根据id查询信息
//			System.out.println("产品ID："+employeeVO.getId());
//			System.out.println("产品名称："+employeeVO.getName());
//			System.out.println("产品名称："+employeeVO.getTest_hibernate0().getString_hibernate());

			
			
//			session0 = HibernateInitialize.getSession();//获取Session
//			test_hibernate employee = (test_hibernate)session0.get(test_hibernate.class, new Integer("3"));//根据id查询信息
//			System.out.println("产品ID："+employee.getId());
//			System.out.println("产品名称："+employee.getString_hibernate());

			
			    //进行更新操作
				session.beginTransaction();//开启事务
				test_hibernate employee = (test_hibernate)session.get(test_hibernate.class,new Integer("3") );//修改操作
				System.out.println("产品ID："+employee.getId());
				System.out.println("产品名称："+employee.getString_hibernate());
				Set<product> product00= employee.getProducts();
				for(Iterator<product> it=product00.iterator();it.hasNext();) {
					product productx=(product)it.next();
					System.out.println("产品ID："+productx.getId());
					System.out.println("产品名称："+productx.getName());
				}

				System.out.println("username"+employee.getUser().getUsername());
				System.out.println("password"+employee.getUser().getPassword());
				session.getTransaction().commit();//提交事务
	           
			    //进行删除操作
//			    session.beginTransaction();//开启事务
//			    test_hibernate product = (test_hibernate) session.get(test_hibernate.class, new Integer("2"));//装载对象
//	            session.delete(product);//删除持久化信息
//				session.flush();//强制刷新提交
//				session.getTransaction().commit();//提交事务
				
			//进行添加操作
//			test_hibernate test =new test_hibernate();
//			test.setId(3);
//			test.setString_hibernate("666");
//			session.beginTransaction();//开启事务
//			session.save(test);//执行数据库添加操作
//			session.getTransaction().commit();//事务提交
			
			
			

		} catch (Exception e) {
			System.out.println("对象装载失败");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}

}
