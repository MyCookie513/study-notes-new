

<!-- 得到数据将其存到数据库 -->


<%@page import="com.mysql.ConnDB"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加结果</title>
</head>
<body>
	
	<jsp:useBean id="book" class="javaBean.commodity"></jsp:useBean>
	<jsp:setProperty property="*" name="book"/>
	<%
	ConnDB conndb=new ConnDB();
	conndb.execute_add("shangpin",book.getId(),book.getName(),book.getNumber(),book.getPrice());
	conndb.close();
	%>
	<br>
	<a href="Page_query">查看</a>
</body>
</html>