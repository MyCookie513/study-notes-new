package java基础知识.ConnectionPool;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



public class ConnDB {
	public Connection conn = null; // 声明Connection对象的实例
	private static String propFileName = "connDB.properties"; // 指定资源文件保存的位置
	private static Properties prop = new Properties(); // 创建并实例化Properties对象的实例
	private static String dbClassName ;//定义保存数据库驱动的变量
	private static String dbUrl ;
	private static String sqlpassword ;
	/**
	 * 功能：构造方法
	 */
	public ConnDB() {
		//在文件中获取链接的数据库的url
		System.out.println("Init...");
		try {			//捕捉异常
			//将Properties文件读取到InputStream对象中
			InputStream in = getClass().getResourceAsStream(propFileName);
			prop.load(in); // 通过输入流对象加载Properties文件
			dbClassName = prop.getProperty("DB_CLASS_NAME"); // 获取数据库驱动
			dbUrl = prop.getProperty("DB_URL", dbUrl);		//获取URL
			sqlpassword=prop.getProperty("PASSWORD");
			//连接数据库时可能发生异常因此需要捕捉该异常
			Class.forName(dbClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace(); // 输出异常信息
		}
		conn=getConnection();

	}

	/**
	 * 功能：连接数据库
	 */
	 static Connection getConnection() {
		Connection conn = null;
		try {
			//建立与数据库URL中定义的数据库的连接
			conn = DriverManager.getConnection(dbUrl,"root",sqlpassword);
		} catch (Exception ee) {
			ee.printStackTrace();									//输出异常信息
		}
		if (conn == null) {
			System.err
					.println("警告: DbConnectionManager.getConnection() 获得数据库链接失败.\r\n\r\n链接类型:"
							+ dbClassName
							+ "\r\n链接位置:"
							+ dbUrl);		//在控制台上输出提示信息
		}
		return conn;										//返回数据库连接对象
	}



	/*
	 * 功能:关闭数据库的连接
	 */
	public  void close() {

		try { // 捕捉异常
			if (conn != null) { // 当Connection对象的实例conn不为空时
				conn.close(); // 关闭Connection对象
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // 输出异常信息
		}
	}


}
