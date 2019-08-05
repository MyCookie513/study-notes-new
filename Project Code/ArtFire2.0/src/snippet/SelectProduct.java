package snippet;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.hibernate_javabean.Ach_information;
import com.cn.hibernate_javabean.Ach_repair;
import com.cn.hibernate_javabean.Ach_users;
import com.cn.hibernate_javabean.Ach_wifi_data_01;



public class SelectProduct {
	public static void main(String[] args) {
		Session session = null;			//������һ��Session����
		try {
			//Hibernate�ĳ־û�����
			session = HibernateInitialize.getSession();//��ȡSession
			session.beginTransaction();//������
		
			Ach_repair ach_repair=new Ach_repair();
			
			Date date = new Date();
			Timestamp install_time = new Timestamp(date.getTime());
			Ach_information ach_information=new Ach_information();
			ach_information.setAch_ID(new Integer("6"));
			ach_repair.setAch_information(ach_information);
			ach_repair.setAlert_time(install_time);
			ach_repair.setMaintain_staff("fdsf");
			ach_repair.setMaintain_status("ok");
			ach_repair.setAlert_infor("fdsfd");
			session.save(ach_repair);
			
		
			session.getTransaction().commit();//�����ύ
			/*session.beginTransaction();//������
			Ach_information fire = (Ach_information) session.get(Ach_information.class, new Integer("6"));//װ�ض���
			System.out.println("��Ʒ���ƣ�"+fire.getAch_ID());
			System.out.println("ʹ�������ƣ�"+fire.getAch_users().getUsername());
			Set<Ach_repair> ach_wifi_data_01=fire.getAch_repair();
			for(Iterator<Ach_repair> it=ach_wifi_data_01.iterator();it.hasNext();)
			{
				Ach_repair data=it.next();
				System.out.println("�����ʱ��Ϊ"+data.getAlert_time());
			}*/
			/*String hql = " from Ach_wifi_data_01 ach_wifi_data_01  where ach_wifi_data_01.ach_information.ach_ID=:ach_ID order by ach_wifi_data_01.ID desc";
			 
			 Query query = session.createQuery(hql);
			 query.setParameter("ach_ID",new Integer("6"));
		        query.setFirstResult(0);
		        query.setMaxResults(1);
		        List<Ach_wifi_data_01> data = query.list();
		        for(Iterator it=data.iterator();it.hasNext();) {
		        	Ach_wifi_data_01 ach_wifi_data_01=(Ach_wifi_data_01) it.next();
		        	
		        System.out.println("1�ű�¯���µĸ��µ�ʱ��Ϊ"+ach_wifi_data_01.getAddtime());	
		        	
		        }*/
			
			
			
			/*
			 * ���ü�������ɾ����¯�����Լ�����Ӧ��user��ʹ�õ����ݼ�¼
			 * 
			 * session.delete(fire);//ɾ���־û���Ϣ
			session.flush();//ǿ��ˢ���ύ
			*/	
			
			
		    /*
		     * * ���ж��û����Լ��豸��ע����Ϣ
			 * */
		/*	Ach_users ach_user=new Ach_users();
			ach_user.setUsername("jack");
			ach_user.setPassword("666666");
			ach_user.setPermission("company");
			ach_user.setPhone("17864280604");
			Ach_information ach_information=new Ach_information();
			//ach_information.setAch_ID(56);
			Date date = new Date();
			Timestamp install_time = new Timestamp(date.getTime());
			ach_information.setInstall_time(install_time);
			ach_user.setAch_information(ach_information);
			ach_information.setAch_users(ach_user);
			session.save(ach_information);
			
			System.out.println("�ռ�������ݵ�id�� ��"+ach_information.getAch_ID());
			
			
			
			session.getTransaction().commit();//�����ύ
*/		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//����ع�
		} finally{
			HibernateInitialize.closeSession();//�ر�Session
		}
	}
}
