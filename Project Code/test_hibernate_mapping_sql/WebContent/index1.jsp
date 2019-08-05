<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
    <%@page import="org.hibernate.Session"%>
    <%@page import="org.hibernate.Transaction"%>
    <%@page import="com.cn.hibernate_Init.*"%>
    <%@page import="com.cn.hibernate_Init.*"%>
<%@page import="com.cn.longclass.test_hibernate"%>
<%
test_hibernate employee=null;
try {
Session sessions= HibernateInitialize.getSession();
employee = (test_hibernate)sessions.get(test_hibernate.class, new Integer("3"));//根据id查询信息
System.out.println("产品ID："+employee.getId());
System.out.println("产品名称："+employee.getString_hibernate());
}catch (Exception e) {
	e.printStackTrace();
	System.out.println("加载失败");
}finally{
	HibernateInitialize.closeSession();//关闭session
}
    %>
<%
/* request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
test_hibernate list = (test_hibernate) request.getAttribute("1");
String Str = (String) request.getAttribute("2"); */
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页</title>
<style type="text/css">
	*{font-size: 12px;}
</style>
</head>
<body>
	
	
	
	

	<%=employee.getString_hibernate()%><br>
	<%=employee.getId()%>
			

			
		
	
</body>
</html>