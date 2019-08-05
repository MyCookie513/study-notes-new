package cn.itcast.servlet;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UserDAO {
	
	
	

	
	 /**
     * 查询给定用户名的用户的详细信息
     *
     * @param userName 给定的用户名/ 用于校验的函数；
     * @return 查询到的封装了详细信息的User对象
     */
    public static User queryUser(String userName) {
        //获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        //生成SQL代码
        StringBuilder sqlStatement = new StringBuilder();
        sqlStatement.append("SELECT * FROM ach_users WHERE userid=?");

        //设置数据库的字段值
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
	 * 功能:用于判定数据库的一个表是否存在；
	 * sql：
	 */
	public static Boolean table_is_single(String table_name ,Connection Connection) {
		
		StringBuilder sqlStatement = new StringBuilder();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
        sqlStatement.append("SELECT table_name FROM information_schema.TABLES WHERE table_name =?");
		try { // 捕捉异常
			
			preparedStatement = Connection.prepareStatement(sqlStatement.toString());
	           
            preparedStatement.setString(1, table_name);
            
            
            resultSet=preparedStatement.executeQuery();
		} catch (SQLException ex) {
			System.err.println(ex.getMessage()); // 输出异常信息
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
    	//获得数据库的连接对象
        Connection connection = DBManager.getConnection();
    	
    	
        
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        

        WifiDataEntity WifiData=new WifiDataEntity();        

        //设置数据库的字段值sqlStatement.toString()
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

    //增加新的用户名；
    
    public static boolean insertUser(String userName,String password) {
    	
    	//获得数据库的连接对象
        Connection connection = DBManager.getConnection();
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection0 = DBManager.getConnection();
        PreparedStatement preparedStatement0 = null;
        ResultSet resultSet0 = null;
        StringBuilder sqlStatement0 = new StringBuilder();
        sqlStatement0.append("SELECT * FROM login WHERE user=?");
        //生成SQL代码
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
    	
      //设置数据库的字段值
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
    
    
    
    
    
    
    
    
    
    
    


