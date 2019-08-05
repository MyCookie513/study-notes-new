<%@page import="java.net.URLEncoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
用户名：<%=new String(request.getParameter("name").getBytes("ISO8859_1"),"UTF-8") %><br>
密码：<%= new String(request.getParameter("sex").getBytes("ISO8859_1"),"UTF-8") %><br>
<%

 String name =new String(request.getParameter("name").getBytes("ISO8859_1"),"UTF-8");
///重定向进行页面的跳转；

//将日期进行格式化；
Date date=new Date();
SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日  HH时mm分钟ss秒");
String today=df.format(date);

//获取请求信息，然后进行发送给浏览器进行保存；
Cookie cookie=new Cookie("cookie_one",URLEncoder.encode(name+"#"+today,"UTF-8"));
//设置cookie的有效期
cookie.setMaxAge(60*60*24*31);
response.addCookie(cookie); 
%>


 <script type="text/javascript">
onload=function(){window.location="index.jsp"}
</script> 

</body>
</html>