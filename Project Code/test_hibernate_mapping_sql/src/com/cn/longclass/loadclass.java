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
	//����load�������ض���
	public static void main(String[] args) {
		Session session = null;			//����Session����
		Session session0 = null;
		List emplist = new ArrayList();//ʵ����List��Ϣ����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			
			//���в�ѯ����
//		  	String hql = "from test_hibernate emp";// ��ѯHQL���
//	        Query q = session.createQuery(hql);// ִ�в�ѯ����
//	        emplist = q.list();//�����صĶ���ת��ΪList����
//			for (int i = 0; i < emplist.size(); i++) {
//			test_hibernate emp = (test_hibernate) emplist.get(i);
//			System.out.println("��ƷID��"+emp.getId());
//			System.out.println("��Ʒ���ƣ�"+emp.getString_hibernate());
//		}	        
			
			//���е�����ѯ����
//			product employeeVO = (product)session.get(product.class, new Integer("5"));//����id��ѯ��Ϣ
//			System.out.println("��ƷID��"+employeeVO.getId());
//			System.out.println("��Ʒ���ƣ�"+employeeVO.getName());
//			System.out.println("��Ʒ���ƣ�"+employeeVO.getTest_hibernate0().getString_hibernate());

			
			
//			session0 = HibernateInitialize.getSession();//��ȡSession
//			test_hibernate employee = (test_hibernate)session0.get(test_hibernate.class, new Integer("3"));//����id��ѯ��Ϣ
//			System.out.println("��ƷID��"+employee.getId());
//			System.out.println("��Ʒ���ƣ�"+employee.getString_hibernate());

			
			    //���и��²���
				session.beginTransaction();//��������
				test_hibernate employee = (test_hibernate)session.get(test_hibernate.class,new Integer("3") );//�޸Ĳ���
				System.out.println("��ƷID��"+employee.getId());
				System.out.println("��Ʒ���ƣ�"+employee.getString_hibernate());
				Set<product> product00= employee.getProducts();
				for(Iterator<product> it=product00.iterator();it.hasNext();) {
					product productx=(product)it.next();
					System.out.println("��ƷID��"+productx.getId());
					System.out.println("��Ʒ���ƣ�"+productx.getName());
				}

				System.out.println("username"+employee.getUser().getUsername());
				System.out.println("password"+employee.getUser().getPassword());
				session.getTransaction().commit();//�ύ����
	           
			    //����ɾ������
//			    session.beginTransaction();//��������
//			    test_hibernate product = (test_hibernate) session.get(test_hibernate.class, new Integer("2"));//װ�ض���
//	            session.delete(product);//ɾ���־û���Ϣ
//				session.flush();//ǿ��ˢ���ύ
//				session.getTransaction().commit();//�ύ����
				
			//������Ӳ���
//			test_hibernate test =new test_hibernate();
//			test.setId(3);
//			test.setString_hibernate("666");
//			session.beginTransaction();//��������
//			session.save(test);//ִ�����ݿ���Ӳ���
//			session.getTransaction().commit();//�����ύ
			
			
			

		} catch (Exception e) {
			System.out.println("����װ��ʧ��");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}

}
