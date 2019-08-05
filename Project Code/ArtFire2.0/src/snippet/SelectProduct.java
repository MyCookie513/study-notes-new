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
		Session session = null;			//声明第一个Session对象
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			session.beginTransaction();//事务开启
		
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
			
		
			session.getTransaction().commit();//事务提交
			/*session.beginTransaction();//事务开启
			Ach_information fire = (Ach_information) session.get(Ach_information.class, new Integer("6"));//装载对象
			System.out.println("产品名称："+fire.getAch_ID());
			System.out.println("使用者名称："+fire.getAch_users().getUsername());
			Set<Ach_repair> ach_wifi_data_01=fire.getAch_repair();
			for(Iterator<Ach_repair> it=ach_wifi_data_01.iterator();it.hasNext();)
			{
				Ach_repair data=it.next();
				System.out.println("修理的时间为"+data.getAlert_time());
			}*/
			/*String hql = " from Ach_wifi_data_01 ach_wifi_data_01  where ach_wifi_data_01.ach_information.ach_ID=:ach_ID order by ach_wifi_data_01.ID desc";
			 
			 Query query = session.createQuery(hql);
			 query.setParameter("ach_ID",new Integer("6"));
		        query.setFirstResult(0);
		        query.setMaxResults(1);
		        List<Ach_wifi_data_01> data = query.list();
		        for(Iterator it=data.iterator();it.hasNext();) {
		        	Ach_wifi_data_01 ach_wifi_data_01=(Ach_wifi_data_01) it.next();
		        	
		        System.out.println("1号壁炉最新的更新的时间为"+ach_wifi_data_01.getAddtime());	
		        	
		        }*/
			
			
			
			/*
			 * 设置级联操作删除壁炉本身以及所对应的user和使用的数据记录
			 * 
			 * session.delete(fire);//删除持久化信息
			session.flush();//强制刷新提交
			*/	
			
			
		    /*
		     * * 进行对用户名以及设备的注册信息
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
			
			System.out.println("刚加入的数据的id号 ："+ach_information.getAch_ID());
			
			
			
			session.getTransaction().commit();//事务提交
*/		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}
	}
}
