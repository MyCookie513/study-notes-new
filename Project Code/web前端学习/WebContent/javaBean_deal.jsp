<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%
request.setCharacterEncoding("UTF-8");

%>
<body>
<!-- 在一个类中将类进行实例化，id为实例，class为哪一个类 -->
<jsp:useBean id="person" class="com.cn.person"/>
<!-- 对类中的属性进行赋值 -->

<jsp:setProperty property="password" name="person" param="password"/>
<jsp:setProperty property="name" name="person" param="name"/>
<ul>
<li>
姓名：<jsp:getProperty property="name" name="person"/>
</li>

<li>
密码：<jsp:getProperty property="password" name="person"/>
</li>
</ul>




</body>
</html>