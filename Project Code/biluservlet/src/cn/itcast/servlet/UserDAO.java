package cn.itcast.servlet;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
	
	
	

	
	 /**
     * ��ѯ�����û������û�����ϸ��Ϣ
     *
     * @param userName �������û���/ ����У��ĺ�����
     * @return ��ѯ���ķ�װ����ϸ��Ϣ��User����
     */
    public static User queryUser(String userName) {
        //������ݿ�����Ӷ���
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //����SQL����
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM ach_users WHERE userid=?");

        //�������ݿ���ֶ�ֵ
        try {
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
          
            preparedStatement.setInt(1, Integer.parseInt(userName));
            resultSet = preparedStatement.executeQuery();
            User user = new User();
            if (resultSet.next()) {
               // user.setUserName(resultSet.getString("username"));
                user.setPassword(resultSet.getString("password"));
                return user;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }
    
    /*
	 * ����:�����ж����ݿ��һ�����Ƿ���ڣ�
	 * sql��
	 */
	public static Boolean table_is_single(String table_name ,Connection Connection) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        sqlStatement.append("SELECT table_name FROM information_schema.TABLES WHERE table_name =?");
		try { // ��׽�쳣
			
			preparedStatement = Connection.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setString(1, table_name);
            
            
            resultSet=preparedStatement.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // ����쳣��Ϣ
		}
				try {
					if(resultSet.next()==true) {
						return true;
					}else
						return false;
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					 DBManager.closeAll(null, preparedStatement, resultSet);
				}
				return null;
				

		
	}
    
    public static WifiDataEntity getaa(int ach_ID) {
    	//������ݿ�����Ӷ���
        Connection connection = DBManager.getConnection();
    	
    	
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        

        WifiDataEntity WifiData=new WifiDataEntity();        

        //�������ݿ���ֶ�ֵsqlStatement.toString()
        try {
            preparedStatement = connection.prepareStatement("select * from ach_wifi_data_01 where ach_ID=?");
          
            preparedStatement.setInt(1, ach_ID);
            resultSet = preparedStatement.executeQuery();
           
            resultSet.last();
            WifiData.setAddtime(resultSet.getString("addtime"));
            WifiData.setAlco_allowance(resultSet.getString("alco_allowance"));
            WifiData.setSystem_state(resultSet.getString("system_state")); 
            WifiData.setUnsafe_types(resultSet.getString("unsafe_types"));
            return WifiData;
           
            //return null;
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    }

    //�����µ��û�����
    
    public static boolean insertUser(String userName,String password) {
    	
    	//������ݿ�����Ӷ���
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection0 = DBManager.getConnection();
        PreparedStatement preparedStatement0 = null;
        ResultSet resultSet0 = null;
        StringBuilder sqlStatement0 = new StringBuilder();
        sqlStatement0.append("SELECT * FROM login WHERE user=?");
        //����SQL����
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("insert into login value(?,?);");
        
        
        try {
        	
            preparedStatement0 = connection0.prepareStatement(sqlStatement0.toString());
            preparedStatement0.setString(1, userName);
            resultSet0= preparedStatement0.executeQuery();
           
           if(resultSet0.next()==true) return false;
          
           
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }finally {
            DBManager.closeAll(connection0, preparedStatement0, resultSet0);
        }
    	
      //�������ݿ���ֶ�ֵ
        try {
        	
            preparedStatement = connection.prepareStatement(sqlStatement.toString());
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);
            preparedStatement.execute();
          
                return true;
           
        } catch (SQLException ex) {
            Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } finally {
            DBManager.closeAll(connection, preparedStatement, resultSet);
        }
    	
    }
    
    
    }
    
    
    
    
    
    
    
    
    
    
    


