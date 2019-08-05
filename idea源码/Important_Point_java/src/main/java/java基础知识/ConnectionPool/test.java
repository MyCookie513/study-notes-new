package java基础知识.ConnectionPool;

import java.sql.Connection;

public class test {
    public static void main(String[] args) {

        ConnDB connDB=new ConnDB();

        Connection connection0=connDB.getConnection();
        System.out.println();
    }
}
