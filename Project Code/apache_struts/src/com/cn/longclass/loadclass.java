package com.cn.longclass;



import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.longclass.test_hibernate;

public class loadclass {
	//����load�������ض���
	public static void main(String[] args) {
		Session session = null;			//����Session����
		List emplist = new ArrayList();//ʵ����List��Ϣ����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			
			//���в�ѯ����
			String hql = "from test_hibernate emp";// ��ѯHQL���
	        Query q = session.createQuery(hql);// ִ�в�ѯ����
	        emplist = q.list();//�����صĶ���ת��ΪList����
			for (int i = 0; i < emplist.size(); i++) {
			test_hibernate emp = (test_hibernate) emplist.get(i);
			System.out.println("��ƷID��"+emp.getId());
			System.out.println("��Ʒ���ƣ�"+emp.getString_hibernate());
		}	            
	            //���и��²���
//				session.beginTransaction();//��������
//				test_hibernate employee = (test_hibernate)session.load(test_hibernate.class,new Integer("1") );//�޸Ĳ���
//				employee.setString_hibernate("wjosijdsifjsifj");;
//				session.getTransaction().commit();//�ύ����
	            
//			    session.beginTransaction();//��������
//			    test_hibernate product = (test_hibernate) session.get(test_hibernate.class, new Integer("2"));//װ�ض���
//	            session.delete(product);//ɾ���־û���Ϣ
//				session.flush();//ǿ��ˢ���ύ
//				session.getTransaction().commit();//�ύ����
//				
			
			

		} catch (Exception e) {
			System.out.println("����װ��ʧ��");
			e.printStackTrace();
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}

}
