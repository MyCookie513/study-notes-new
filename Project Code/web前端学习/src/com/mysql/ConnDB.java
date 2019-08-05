package com.mysql;

import java.io.InputStream; //����java.io.InputStream��
import java.sql.*; //����java.sql���е�������
import java.util.Properties; //����java.util.Properties��
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
	
	public  Connection conn ; // ����Connection�����ʵ��
	public Statement stmt ; // ����Statement�����ʵ��
	public ResultSet rs ; // ����ResultSet�����ʵ��
	public static String sqlpassword;
	private static String propFileName = "connDB.properties"; // ָ����Դ�ļ������λ��
	private static Properties prop = new Properties(); // ������ʵ����Properties�����ʵ��
	private static String dbClassName ;//���屣�����ݿ������ı���
	private static String dbUrl;
	private PreparedStatement preparedStatement = null;
	/**
	 * ���ܣ����췽��
	 */
	public ConnDB() {
		//���ļ��л�ȡ���ӵ����ݿ��url
		
		try {			//��׽�쳣
			//��Properties�ļ���ȡ��InputStream������
			InputStream in = getClass().getResourceAsStream(propFileName);
			// ͨ���������������Properties�ļ�
			prop.load(in); 
			//��ȡ�������ƣ����ݿ��ַ������
			dbClassName = prop.getProperty("DB_CLASS_NAME"); // ��ȡ���ݿ�����
			dbUrl = prop.getProperty("DB_URL", dbUrl);		//��ȡURL
			sqlpassword=prop.getProperty("PASSWORD");
		} catch (Exception e) {
			e.printStackTrace(); 
		}
		
		//�õ����ݿ������
		getConnection();
		
	}

	/**
	 * ���ܣ��������ݿ⣬���غ����ݿ��һ����̬���Ӷ���
	 */
	public  void getConnection() {
		
		try {								//�������ݿ�ʱ���ܷ����쳣�����Ҫ��׽���쳣
			Class.forName(dbClassName).newInstance();			//װ�����ݿ�����
			//���������ݿ�URL�ж�������ݿ������
			conn = DriverManager.getConnection(dbUrl,"root",sqlpassword);
		} catch (Exception ee) {
			ee.printStackTrace();									//����쳣��Ϣ
		}
		if (conn == null) {
			System.err
					.println("����: DbConnectionManager.getConnection() ������ݿ�����ʧ��.\r\n\r\n��������:"
							+ dbClassName
							+ "\r\n����λ��:"
							+ dbUrl);		//�ڿ���̨�������ʾ��Ϣ
		}
										//�������ݿ����Ӷ���
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
			System.out.print("<li>���޹�����Ϣ��</li>");
		}
		
		conndb.close();
	}
	/**
	 * ���ܣ�������һ���ظ��ı�
	 */
	public void create_single_table(String table_name ) {
		
		
        String sqlStatement=new String("create table if not exists ? (id INT NOT NULL,name varchar(255) NULL,number INT NULL,price INT NULL,PRIMARY KEY (id))");
		
		sqlStatement=sqlStatement.replaceFirst("[?]", table_name);
		System.out.println(sqlStatement);
		try { 
			
			preparedStatement = conn.prepareStatement(sqlStatement);
			
           preparedStatement.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
	}
	
	
	//������Ʒ��ѯ����
	public List<commodity> select_info(String table_name,int start,int length){
		
		List<commodity>  shangpin=new ArrayList<commodity>();
		
        String sqlStatement=new String("select * from ? order by id limit ?,?");
		
		sqlStatement=sqlStatement.replaceFirst("[?]", table_name);
		
	     
 		try { // ��׽�쳣
 			
 			preparedStatement = conn.prepareStatement(sqlStatement);
 			
 		//�ڱ��������Ӳ���
           
             preparedStatement.setInt(1, start);
             preparedStatement.setInt(2,length);
            
            rs= preparedStatement.executeQuery();
 		} catch (SQLException ex) {
 			System.err.println(ex.getMessage()); // ����쳣��Ϣ
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
	 * ���ܣ�ִ�в�ѯ���
	 * sql������ָ����ѯ���
	 */
	public ResultSet executeQuery(String sql) {
		try { // ��׽�쳣
			
			//����һ��ָ��������������ݸ��²����еģ����Խ��и��µĲ����ߣ�
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery(sql);			//ִ��SQL��䣬������һ��ResultSet����rs
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
		return rs; // ���ؽ��������
	}

	/*
	 * ����:ִ�и��²���
	 * sql������ָ���������
	 */
	public int executeUpdate(String sql) {
		int result = 0; // ���屣�淵��ֵ�ı���
		try { // ��׽�쳣
			
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			result = stmt.executeUpdate(sql); // ִ�и��²���
		} catch (SQLException ex) {
			result = 0; // �����淵��ֵ�ı�����ֵΪ0
		}
		return result; // ���ر��淵��ֵ�ı���
	}
	//������Ʒ�ĸ��²�����
	public void  update_shangpin(int id ,String name ,int number,int price) {
		
		
       
            String sqlStatement=new String("UPDATE shangpin SET name=?,number=?,price=? WHERE id=?");
		
     		
             
     		try { // ��׽�쳣
     			
     			preparedStatement = conn.prepareStatement(sqlStatement);
     			
     		//�ڱ��������Ӳ���
                 preparedStatement.setInt(4,id );
                 preparedStatement.setString(1, name);
                 preparedStatement.setInt(2,number);
                 preparedStatement.setInt(3,price );
                preparedStatement.executeUpdate();
     		} catch (SQLException ex) {
     			System.err.println(ex.getMessage()); // ����쳣��Ϣ
     		}
     		
        
       

		
	}
	
	/*
	 * ����:�����ж����ݿ��һ�����Ƿ���ڣ�
	 * sql��
	 */
	public Boolean table_is_single(String table_name ) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
        sqlStatement.append("SELECT table_name FROM information_schema.TABLES WHERE table_name =?");
		try { // ��׽�쳣
			
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setString(1, table_name);
            
            
            rs=preparedStatement.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
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
	
	///���в�����Ʒ��Ϣ
	public void execute_add(String sql_table,int id ,String name,int number ,int price) {
		
        String sqlStatement=new String("INSERT INTO ? VALUES(?,?,?,?)");
		
		sqlStatement=sqlStatement.replaceFirst("[?]", sql_table);
		
        
		try { // ��׽�쳣
			
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
			
		//�ڱ��������Ӳ���
            preparedStatement.setInt(1,id );
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3,number);
            preparedStatement.setInt(4,price );
           preparedStatement.executeUpdate();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
		
	}
	//ɾ������һ����¼�Ĳ�����
	public void deletesql(int id ) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
        sqlStatement.append("DELETE FROM shangpin WHERE(id=?)");
		try { // ��׽�쳣
		
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setInt(1, id);
            
            
           preparedStatement.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
	}

	/*
	 * ����:
	 * sql��
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
	 * ����:�ر����ݿ������
	 */
	public void close() {
		try { // ��׽�쳣
			if (rs != null) { // ��ResultSet�����ʵ��rs��Ϊ��ʱ
				rs.close(); // �ر�ResultSet����
			}
			if (preparedStatement != null) { // ��Statement�����ʵ��stmt��Ϊ��ʱ
				preparedStatement.close(); // �ر�Statement����
			}
			if (stmt != null) { // ��Statement�����ʵ��stmt��Ϊ��ʱ
				stmt.close(); // �ر�Statement����
			}
			if (conn != null) { // ��Connection�����ʵ��conn��Ϊ��ʱ
				conn.close(); // �ر�Connection����
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // ����쳣��Ϣ
		}
	}

}
