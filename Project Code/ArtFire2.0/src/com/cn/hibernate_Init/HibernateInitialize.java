package com.cn.hibernate_Init;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Hibernate初始化类     最终获得了sessionfactory对象；
 *
 */
public class HibernateInitialize {

               private static final ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();//ThreadLocal对象
               private static SessionFactory sessionFactory = null;//SessionFactory对象
               //静态块
	static {
    	try {
    		// 加载Hibernate配置文件，如果configure（null）;里面为空的话，默认为类库下面找寻                                                                       //hibernate.org.xml文件
            //主要作用为从xml文件中加载hibernate的基本信息；
			Configuration cfg = new Configuration().configure();
			//从生成的配置类中获得sessionFactory对象；
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
    }
	/**
     *	获取Session
     *  @return Session
     *  @throws HibernateException
     */
    public static Session getSession() throws HibernateException {
            //先尝试从程序运行的（线程安全）中获得session对象；
        Session session = (Session) threadLocal.get();
		if (session == null || !session.isOpen()) {
                             //如果线程中获取失败的话则从sessionFactory中获得；
			if (sessionFactory == null) {
				rebuildSessionFactory();
			}
			session = (sessionFactory != null) ? sessionFactory.openSession(): null;
                                               //最后在把最新生成的session对象放置在安全线程中；以便于再次获取；
			threadLocal.set(session);
		}

        return session;
    }
	/**
     * 重建会话工厂
     */
	public static void rebuildSessionFactory() {
		try {
			// 加载Hibernate配置文件
			Configuration cfg = new Configuration().configure();
			sessionFactory = cfg.buildSessionFactory();
		} catch (Exception e) {
			System.err.println("创建会话工厂失败");
			e.printStackTrace();
		}
	}
	/**
	 * 获取SessionFactory对象
	 * @return SessionFactory对象
	 */
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	/** 
     *	关闭Session
     *  @throws HibernateException
     */
    public static void closeSession() throws HibernateException {
        Session session = (Session) threadLocal.get();
        threadLocal.set(null);//
        if (session != null) {
            session.close();//关闭Session
        }
    }
}
