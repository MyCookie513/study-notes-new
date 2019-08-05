package ConnectionPool;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;



public class ConnDB {
	public Connection conn = null; // ����Connection�����ʵ��
	private static String propFileName = "connDB.properties"; // ָ����Դ�ļ������λ��
	private static Properties prop = new Properties(); // ������ʵ����Properties�����ʵ��
	private static String dbClassName ;//���屣�����ݿ������ı���
	private static String dbUrl ;
	private static String sqlpassword ;
	/**
	 * ���ܣ����췽��
	 */
	public ConnDB() {
		//���ļ��л�ȡ���ӵ����ݿ��url
		System.out.println("Init...");
		try {			//��׽�쳣
			//��Properties�ļ���ȡ��InputStream������
			InputStream in = getClass().getResourceAsStream(propFileName);
			prop.load(in); // ͨ���������������Properties�ļ�
			dbClassName = prop.getProperty("DB_CLASS_NAME"); // ��ȡ���ݿ�����
			dbUrl = prop.getProperty("DB_URL", dbUrl);		//��ȡURL
			sqlpassword=prop.getProperty("PASSWORD");
			//�������ݿ�ʱ���ܷ����쳣�����Ҫ��׽���쳣
			Class.forName(dbClassName).newInstance();
		} catch (Exception e) {
			e.printStackTrace(); // ����쳣��Ϣ
		}
		conn=getConnection();

	}

	/**
	 * ���ܣ��������ݿ�
	 */
	 static Connection getConnection() {
		Connection conn = null;
		try {
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
		return conn;										//�������ݿ����Ӷ���
	}



	/*
	 * ����:�ر����ݿ������
	 */
	public void close() {
		try { // ��׽�쳣
			if (conn != null) { // ��Connection�����ʵ��conn��Ϊ��ʱ
				conn.close(); // �ر�Connection����
			}
		} catch (Exception e) {
			e.printStackTrace(System.err); // ����쳣��Ϣ
		}
	}


}
