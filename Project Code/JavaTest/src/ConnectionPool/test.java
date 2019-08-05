package ConnectionPool;



import java.sql.SQLException;

import ConnectionPool.ConPool.Connection_DIY;

public class test {
    public static void main(String[] args) throws InterruptedException, SQLException {

        ConPool conpool=ConPool.getPool(10);
        Connection_DIY connetion= conpool.getConnection();
        System.out.println(" connetion is running");
   
		Thread.sleep(3000);
		
        connetion.FreeConnetion();
        conpool.closeAllConnetions();
        
    }
}
