
<%@page import="java.net.URLEncoder"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

//创建一个Map集合对象，然后放入需要的key/value；
 Map<String, String> params = new HashMap<>();
params.put("Result", "success");
params.put("Result0", "failed");
//放入一个将map集合对象放入json对象中
JSONObject jsonObject = new JSONObject();
jsonObject.put("params", params); 

//将json对象转化为String的形式进行发送
PrintWriter RES_write=response.getWriter();
RES_write.write(jsonObject.toString()); 

%>
</body>
</html>