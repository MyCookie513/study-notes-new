package com.cn.action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.cn.hibernate_Init.HibernateInitialize;
import com.cn.hibernate_javabean.Ach_users;
import com.cn.hibernate_javabean.Ach_wifi_data_01;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class data extends ActionSupport {

	private	String nocache;
	
	public String getNocache() {
	return nocache;
}
public void setNocache(String nocache) {
	this.nocache = nocache;
}
	@Override
	public String execute() throws Exception {
		ActionContext contextfds =ActionContext.getContext();
		Map session0=(Map) contextfds.getSession();
		Map request=(Map) contextfds.get("request");
		String username=(String) session0.get("username");
		String password=(String) session0.get("password");
		//String date=request.get("nocache").toString();
		
		if(username==null)
			return ERROR;
		int ach_ID=Integer.parseInt(username);
		Session session = null;			//声明第一个Session对象
		Ach_users user = null;
		try {
			//Hibernate的持久化操作
			session = HibernateInitialize.getSession();//获取Session
			
			String hql = " from Ach_wifi_data_01 ach_wifi_data_01  where ach_wifi_data_01.ach_information.ach_ID=:ach_ID order by ach_wifi_data_01.ID desc";
			 
			 Query query = session.createQuery(hql);
			 query.setParameter("ach_ID",ach_ID);
		     query.setFirstResult(0);
		     query.setMaxResults(1);
		     List<Ach_wifi_data_01> data = query.list();
		     for(Iterator it=data.iterator();it.hasNext();) {
		        	Ach_wifi_data_01 ach_wifi_data_01=(Ach_wifi_data_01) it.next();
		        	
		        	request.put("addtime", ach_wifi_data_01.getAddtime().toString());	
		        	request.put("jiujingyewei", ach_wifi_data_01.getAlco_allowance());
		        	
		        	request.put("jibanwendu", ach_wifi_data_01.getSubstrate_tem());
		        	request.put("first_level", ach_wifi_data_01.getFirst_level());
		        	request.put("second_level", ach_wifi_data_01.getSecond_level());
		        	request.put("fire_tem", ach_wifi_data_01.getFlame_tem());
		        	request.put("system_state", ach_wifi_data_01.getSystem_state());
		        	
		        	
		        }
		     
		     
		    session.beginTransaction();//事务开启
		    Ach_users usera = (Ach_users) session.get(Ach_users.class, ach_ID);//装载对象
		     
		    request.put("id", username);
        	request.put("name", usera.getUsername());
        	request.put("type", usera.getAch_information().getType());
        	request.put("touch_screen", usera.getAch_information().getTouch_screen());
        	request.put("anzhuang_time", usera.getAch_information().getInstall_time().toString());
		    session.getTransaction().commit();//事务提交 
		     
		     
	
		} catch (Exception e) {
			e.printStackTrace();
			session.getTransaction().rollback();//事务回滚
		} finally{
			HibernateInitialize.closeSession();//关闭Session
		}

			return SUCCESS;
		
				
	}

}
