<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="java.util.List"%>
<%@page import="com.cn.longclass.test_hibernate"%>

<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
test_hibernate list = (test_hibernate) request.getAttribute("1");
String Str = (String) request.getAttribute("2");
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
	<%=Str%>
	
	
	<%if(list!=null){ %>>

	<%=list.getString_hibernate()%><br>
	<%=list.getId()%>
			<%
				}
			%>	

			
		
	
</body>
</html>