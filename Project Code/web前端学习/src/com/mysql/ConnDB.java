package com.mysql;

import java.io.InputStream; //导入java.io.InputStream类
import java.sql.*; //导入java.sql包中的所有类
import java.util.Properties; //导入java.util.Properties类
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javaBean.commodity;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
/**
 *
 * @author administrator
 */

public class ConnDB {
	
	public  Connection conn ; // 声明Connection对象的实例
	public Statement stmt ; // 声明Statement对象的实例
	public ResultSet rs ; // 声明ResultSet对象的实例
	public static String sqlpassword;
	private static String propFileName = "connDB.properties"; // 指定资源文件保存的位置
	private static Properties prop = new Properties(); // 创建并实例化Properties对象的实例
	private static String dbClassName ;//定义保存数据库驱动的变量
	private static String dbUrl;
	private PreparedStatement preparedStatement = null;
	/**
	 * 功能：构造方法
	 */
	public ConnDB() {
		//在文件中获取链接的数据库的url
		
		try {			//捕捉异常
			//将Properties文件读取到InputStream对象中
			InputStream in = getClass().getResourceAsStream(propFileName);
			// 通过输入流对象加载Properties文件
			prop.load(in); 
			//获取驱动名称，数据库地址，密码
			dbClassName = prop.getProperty("DB_CLASS_NAME"); // 获取数据库驱动
			dbUrl = prop.getProperty("DB_URL", dbUrl);		//获取URL
			sqlpassword=prop.getProperty("PASSWORD");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		//得到数据库的链接
		getConnection();
		
	}

	/**
	 * 功能：连接数据库，返回和数据库的一个静态链接对象
	 */
	public  void getConnection() {
		
		try {								//连接数据库时可能发生异常因此需要捕捉该异常
			Class.forName(dbClassName).newInstance();			//装载数据库驱动
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
										//返回数据库连接对象
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		ConnDB conndb=new ConnDB();
		
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conndb.conn.prepareStatement("SELECT * FROM information ORDER BY idinformation DESC");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResultSet rs =preparedStatement.executeQuery();
		if(rs.next()){
			do{
				System.out.print("<li>"+"title:"+rs.getString(1)+"</li>");
				System.out.print("<li>"+"content:"+rs.getString(2)+"</li>");
			}while(rs.next());
		}else{
			System.out.print("<li>暂无公告信息！</li>");
		}
		
		conndb.close();
	}
	/**
	 * 功能：建立单一不重复的表；
	 */
	public void create_single_table(String table_name ) {
		
		
        String sqlStatement=new String("create table if not exists ? (id INT NOT NULL,name varchar(255) NULL,number INT NULL,price INT NULL,PRIMARY KEY (id))");
		
		sqlStatement=sqlStatement.replaceFirst("[?]", table_name);
		System.out.println(sqlStatement);
		try { 
			
			preparedStatement = conn.prepareStatement(sqlStatement);
			
           preparedStatement.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
		}
	}
	
	
	//进行商品查询操作
	public List<commodity> select_info(String table_name,int start,int length){
		
		List<commodity>  shangpin=new ArrayList<commodity>();
		
        String sqlStatement=new String("select * from ? order by id limit ?,?");
		
		sqlStatement=sqlStatement.replaceFirst("[?]", table_name);
		
	     
 		try { // 捕捉异常
 			
 			preparedStatement = conn.prepareStatement(sqlStatement);
 			
 		//在表里进行添加操作
           
             preparedStatement.setInt(1, start);
             preparedStatement.setInt(2,length);
            
            rs= preparedStatement.executeQuery();
 		} catch (SQLException ex) {
 			System.err.println(ex.getMessage()); // 输出异常信息
 		}
 		
		try {
			while(rs.next())
			{
				commodity com=new commodity();
				com.setId(rs.getInt("id")); 
				com.setName(rs.getString("name"));
				com.setNumber(rs.getInt("number"));
				com.setPrice( rs.getInt("price"));
				shangpin.add(com);
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return shangpin;
		
	}
	
	
	
	/*
	 * 功能：执行查询语句
	 * sql：用于指定查询语句
	 */
	public ResultSet executeQuery(String sql) {
		try { // 捕捉异常
			
			//返回一个指针可跳动，但数据更新不敏感的，可以进行更新的操作者；
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);			//执行SQL语句，并返回一个ResultSet对象rs
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
		}
		return rs; // 返回结果集对象
	}

	/*
	 * 功能:执行更新操作
	 * sql：用于指定更新语句
	 */
	public int executeUpdate(String sql) {
		int result = 0; // 定义保存返回值的变量
		try { // 捕捉异常
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			result = stmt.executeUpdate(sql); // 执行更新操作
		} catch (SQLException ex) {
			result = 0; // 将保存返回值的变量赋值为0
		}
		return result; // 返回保存返回值的变量
	}
	//进行商品的更新操作；
	public void  update_shangpin(int id ,String name ,int number,int price) {
		
		
       
            String sqlStatement=new String("UPDATE shangpin SET name=?,number=?,price=? WHERE id=?");
		
     		
             
     		try { // 捕捉异常
     			
     			preparedStatement = conn.prepareStatement(sqlStatement);
     			
     		//在表里进行添加操作
                 preparedStatement.setInt(4,id );
                 preparedStatement.setString(1, name);
                 preparedStatement.setInt(2,number);
                 preparedStatement.setInt(3,price );
                preparedStatement.executeUpdate();
     		} catch (SQLException ex) {
     			System.err.println(ex.getMessage()); // 输出异常信息
     		}
     		
        
       

		
	}
	
	/*
	 * 功能:用于判定数据库的一个表是否存在；
	 * sql：
	 */
	public Boolean table_is_single(String table_name ) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
        sqlStatement.append("SELECT table_name FROM information_schema.TABLES WHERE table_name =?");
		try { // 捕捉异常
			
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setString(1, table_name);
            
            
            rs=preparedStatement.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
		}
				try {
					if(rs.next()==true) {
						return true;
					}else
						return false;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
				

		
	}
	
	///进行插入商品信息
	public void execute_add(String sql_table,int id ,String name,int number ,int price) {
		
        String sqlStatement=new String("INSERT INTO ? VALUES(?,?,?,?)");
		
		sqlStatement=sqlStatement.replaceFirst("[?]", sql_table);
		
        
		try { // 捕捉异常
			
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
			
		//在表里进行添加操作
            preparedStatement.setInt(1,id );
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3,number);
            preparedStatement.setInt(4,price );
           preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
		}
		
	}
	//删除表中一条记录的操作；
	public void deletesql(int id ) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
        sqlStatement.append("DELETE FROM shangpin WHERE(id=?)");
		try { // 捕捉异常
		
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setInt(1, id);
            
            
           preparedStatement.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
		}
	}

	/*
	 * 功能:
	 * sql：
	 */
	
	
	public int  query_count(String sql_table) {
		
		   String sqlStatement=new String("select count(*) from ?");
			
			sqlStatement=sqlStatement.replaceFirst("[?]", sql_table);
			int count = 0;
			rs=executeQuery(sqlStatement);
			try {
				rs.next();
				count=rs.getInt(1);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			return count;
		
	}
	
	
	
	/*
	 * 功能:关闭数据库的连接
	 */
	public void close() {
		try { // 捕捉异常
			if (rs != null) { // 当ResultSet对象的实例rs不为空时
				rs.close(); // 关闭ResultSet对象
			}
			if (preparedStatement != null) { // 当Statement对象的实例stmt不为空时
				preparedStatement.close(); // 关闭Statement对象
			}
			if (stmt != null) { // 当Statement对象的实例stmt不为空时
				stmt.close(); // 关闭Statement对象
			}
			if (conn != null) { // 当Connection对象的实例conn不为空时
				conn.close(); // 关闭Connection对象
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // 输出异常信息
		}
	}

}
