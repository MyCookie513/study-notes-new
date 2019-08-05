package java基础知识.ConnectionPool;





import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConPool implements PoolService,Runnable{

    private List<Connection_DIY> list=new ArrayList<>();
    private ConnDB connDB=new ConnDB();
    private int free;
    private int active;
    private int number=10;//总共的线程数量

    private ConPool() {
    }
    public static ConPool getPool() {
        return  InstanceHolder.instance;
    }


    @Override
    public void run() {
        try {
            Thread.sleep(2000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int free0=0;
        int active0=0;
        for(Iterator<Connection_DIY> it = list.iterator(); it.hasNext();){
            Connection_DIY connection_diy=it.next();
            try {
                connection_diy.isValidate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            switch (connection_diy.connectionState) {
                case FREE:
                    free0++;
                    break;
                case RUNNING:
                    active0++;
                    break;
                case BLOCKED :
                    try {
                        connection_diy.delete();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                    break;
                default:

                    break;
            }

        }
        free=free0;
        active =active0;
        number=list.size();
        if(active>0.75*number){
            for(int i=0;i<10;i++){
                Connection_DIY connection_diy=new Connection_DIY();
                free++;
                number++;
            }
        }

    }

    private static  class InstanceHolder{
        private static final ConPool instance =new ConPool();
    }



    @Override
    public void Init() {

        for(int i=0;i<number;i++){
            Connection_DIY connection_diy=new Connection_DIY();
        }
        free=number;

        new Thread(this).start();
    }

    @Override
    public Connection_DIY getConnection() {
        return new Connection_DIY();
    }

    @Override
    public void closeAllConnetions() {
        for(Iterator<Connection_DIY> it = list.iterator(); it.hasNext();){
                it.remove();
        }
    }
    //创建一个枚举类型来表示状态；
    private  enum  ConnectionState{
        FREE,RUNNING,BLOCKED,DEAD  //分别代表 空闲，运行 ，阻塞，挂掉
    }

    protected class Connection_DIY {


        private  ConnectionState connectionState=ConnectionState.FREE;
        Connection connection;

        public Connection_DIY() {
            this.connection =connDB.getConnection();
            list.add(this);
        }

        public Connection getConnection() {
            connectionState=ConnectionState.RUNNING;
            return connection;
        }

        public void isValidate() throws SQLException {
            if(!connection.isValid(10))
                connectionState=ConnectionState.BLOCKED;
        }
        public void FreeConnetion(){
            connectionState=ConnectionState.FREE;
        }

        public void  delete() throws SQLException {
            if (connection!=null)
                connection.close();
            connectionState=ConnectionState.DEAD;
            for(Iterator<Connection_DIY> it = list.iterator(); it.hasNext();){
                Connection_DIY connection_diy=it.next();
                if(connection_diy.connectionState== ConnectionState.BLOCKED &&connection_diy.connectionState== ConnectionState.DEAD){
                    it.remove();
                }
            }

        }




    }



}
