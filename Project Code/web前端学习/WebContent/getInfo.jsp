<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>

<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>

<%@ page import="com.mysql.ConnDB" %>
<jsp:useBean id="conndb" class="com.mysql.ConnDB" scope="page"></jsp:useBean>
<ul>
<%
PreparedStatement preparedStatement = null;
try {
	preparedStatement = conndb.conn.prepareStatement("SELECT * FROM information ORDER BY idinformation DESC");
} catch (SQLException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}
ResultSet rs =preparedStatement.executeQuery();
if(rs.next()){
	
		out.print("<li>"+"title:"+rs.getString(2)+"</li>");
		out.print("<li>"+"content:"+rs.getString(3)+"</li>");
	
}else{
	out.print("<li>暂无公告信息！</li>");
}

conndb.close();
conndb.close();
%>

</ul>