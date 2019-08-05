<%@page import="java.io.PrintWriter"%>
<%@page import="java.net.URLDecoder"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- 定义全局的变量和方法 -->
<%!


%>

<%
//利用application得到初始化参数
String url= application.getInitParameter("url");
String name= application.getInitParameter("name");
String password= application.getInitParameter("password");
//将日期进行格式化；
Date date=new Date();
SimpleDateFormat df=new SimpleDateFormat("yyyy年MM月dd日  HH时mm分钟ss秒");
String today=df.format(date);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP页面的学习</title>
</head>
<body>
当前的时间为：    <%= today %>
<%




String user="";
String datef="";

//浏览器中获得
Cookie[] mycookie=request.getCookies();
if(mycookie!=null){
	for(int i=0;i<mycookie.length;i++){
		if(mycookie[i].getName().equals("cookie_one")){
			user=URLDecoder.decode(mycookie[i].getValue().split("#")[0],"UTF-8");
			datef=URLDecoder.decode(mycookie[i].getValue().split("#")[0],"UTF-8");
		}
	}
}
if(user.equals("")){
	%>
	游客你好欢迎您初次光临；<br><br>
	<form action="Test.jsp" method="post">
请输入用户的姓名：<input type="text" name="name" />
请选择性别：<input type="radio" value="男"  name="sex" />男
         <input    type="radio" value="女" name="sex"/>女<br><br>
         请选择密码提示问题：
  <select name="question">
  <option value="家庭住址" >家庭住址</option>
  <option value="小学学校名称" >小学学校名称</option>
  <option value="高三班主任名称" >高三班主任名称</option>
  </select>  <br><br>
  请输入问题的答案：<br><input type="text" name="key" /> <br><br>
  请选择个人爱好：
  <input type="checkbox" value="唱歌跳舞" name="hot"/>唱歌跳舞
  <input type="checkbox" value="电子竞技" name="hot" />电子竞技<br><br>
  <input  type="submit" value="提交" />
</form><br>

	<%
	}else{
		  
	%>
	
	<%=user %>您好，您已经完成注册，无需进行注册您注册的信息为<%= datef %> 
	
	<%
	}
         //延迟一段时间进行页面跳转；
       //response.setHeader("refresh","3;https://WWW.baidu.com");
  
       

	%>
	

	





















</body>
</html>