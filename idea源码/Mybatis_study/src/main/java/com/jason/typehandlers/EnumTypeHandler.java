package com.jason.typehandlers;

import com.jason.Mapper.Status;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EnumTypeHandler implements TypeHandler<Status> {

    /**
     * 定义当前的数据如何保存到数据库中
     * @param ps　：预编译对象
     * @param i ：注入的第几个参数
     * @param parameter　：对应的注入的javaBean的对象
     * @param jdbcType
     * @throws SQLException
     */
    public void setParameter(PreparedStatement ps, int i, Status parameter, JdbcType jdbcType) throws SQLException {

        ps.setString(i,parameter.getCode().toString());
    }

    /**
     *
     * @param rs
     * @param columnName
     * @return
     * @throws SQLException
     */
    public Status getResult(ResultSet rs, String columnName) throws SQLException {
         Integer code =rs.getInt(columnName);//根据查询的列名返回一个int型的值；
        Status status=Status.getStatus(code);
        return status;
    }

    public Status getResult(ResultSet rs, int columnIndex) throws SQLException {
        Integer code =rs.getInt(columnIndex);//根据查询的列名返回一个int型的值；
        Status status=Status.getStatus(code);
        return status;
    }

    public Status getResult(CallableStatement cs, int columnIndex) throws SQLException {
        Integer code =cs.getInt(columnIndex);//根据查询的列名返回一个int型的值；
        Status status=Status.getStatus(code);
        return status;
    }
}
