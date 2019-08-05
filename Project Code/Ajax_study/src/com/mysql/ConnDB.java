package com.mysql;

import java.io.InputStream; //����java.io.InputStream��
import java.sql.*; //����java.sql���е�������
import java.util.Properties; //����java.util.Properties��

/**
 *
 * @author administrator
 */

public class ConnDB {
	public Connection conn = null; // ����Connection�����ʵ��
	public Statement stmt = null; // ����Statement�����ʵ��
	public ResultSet rs = null; // ����ResultSet�����ʵ��
	public static String sqlpassword=null;
	private static String propFileName = "connDB.properties"; // ָ����Դ�ļ������λ��
	private static Properties prop = new Properties(); // ������ʵ����Properties�����ʵ��
	private static String dbClassName = "com.mysql.jdbc.Driver";//���屣�����ݿ������ı���
	private static String dbUrl = "jdbc:mysql://127.0.0.1:3306/db_database16?user=root&password=988513&useUnicode=true";
	/**
	 * ���ܣ����췽��
	 */
	public ConnDB() {
		//���ļ��л�ȡ���ӵ����ݿ��url
		
		try {			//��׽�쳣
			//��Properties�ļ���ȡ��InputStream������
			InputStream in = getClass().getResourceAsStream(propFileName);
			prop.load(in); // ͨ���������������Properties�ļ�
			dbClassName = prop.getProperty("DB_CLASS_NAME"); // ��ȡ���ݿ�����
			dbUrl = prop.getProperty("DB_URL", dbUrl);		//��ȡURL
			sqlpassword=prop.getProperty("PASSWORD");
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
	}

	/**
	 * ���ܣ��������ݿ�
	 */
	public static Connection getConnection() {
		Connection conn = null;
		try {								//�������ݿ�ʱ���ܷ����쳣�����Ҫ��׽���쳣
			Class.forName(dbClassName).newInstance();			//װ�����ݿ�����
			//���������ݿ�URL�ж�������ݿ������
			conn = DriverManager.getConnection(dbUrl,"root",sqlpassword);
		} catch (Exception ee) {
			ee.printStackTrace();									//����쳣��Ϣ
		}
		if (conn == null) {
			System.err.println("����: DbConnectionManager.getConnection() ������ݿ�����ʧ��.\r\n\r\n��������:"
							+ dbClassName
							+ "\r\n����λ��:"
							+ dbUrl);		//�ڿ���̨�������ʾ��Ϣ
		}
		return conn;//�������ݿ����Ӷ���
	}

	/*
	 * ���ܣ�ִ�в�ѯ���
	 * sql������ָ����ѯ���
	 */
	public ResultSet executeQuery(String sql) {
		try { // ��׽�쳣
			conn = getConnection(); // ����getConnection()��������Connection�����һ��ʵ��conn
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
			conn = getConnection(); // ����getConnection()��������Connection�����һ��ʵ��conn
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_UPDATABLE);
			result = stmt.executeUpdate(sql); // ִ�и��²���
		} catch (SQLException ex) {
			result = 0; // �����淵��ֵ�ı�����ֵΪ0
		}
		return result; // ���ر��淵��ֵ�ı���
	}
	
	//���������ݿ������ָ�����ݣ�
	
	public void execute_add(int iduser,String username,String password) {
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
        sqlStatement.append("INSERT INTO user <data> VALUES(?,?,?)");
		try { // ��׽�쳣
			conn = getConnection(); // ����getConnection()��������Connection�����һ��ʵ��conn
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setInt(1, iduser);
            preparedStatement.setString(2, username);
            preparedStatement.setString(2, password);
            
           preparedStatement.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
		
	}
	
	public void deletesql(int id ) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
        sqlStatement.append("DELET FROM user WHERE iduser=?");
		try { // ��׽�쳣
			conn = getConnection(); // ����getConnection()��������Connection�����һ��ʵ��conn
			preparedStatement = conn.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setInt(1, id);
            
            
           preparedStatement.execute();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
	}
	
	
	
	/*
	 * ����:�ر����ݿ������
	 */
	public void close() {
		try { // ��׽�쳣
			if (rs != null) { // ��ResultSet�����ʵ��rs��Ϊ��ʱ
				rs.close(); // �ر�ResultSet����
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
