
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有人员信息</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
</head>
<body>
<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
	<tr bgcolor="white">
		<td align="center" colspan="5">
			<h2>最近人员签到信息</h2>
		</td>
	</tr>
	<tr align="center" bgcolor="#e1ffc1" >
		<td><b>姓名</b></td>
		<td><b>学号</b></td>
		<td><b>班级</b></td>
		<td><b>签到时间</b></td>
		<td><b>实验室</b></td>
	</tr>
	<c:forEach items="${list}" var="sign" varStatus="vs">
		<tr align="center" bgcolor="#e1ffc1">


			<td align = "center">${sign.name}</td>
			<td align = "center">${sign.xuehao}</td>
			<td align = "center">${sign.banji}</td>
			<td align = "center">${sign.signTime}</td>
			<td align = "center">${sign.shiyanshi}</td>


		</tr>
	</c:forEach>

	<tr>
		<%-- <td align="center" colspan="5" bgcolor="white">
			<%=request.getAttribute("bar")%>
		</td> --%>
	</tr>
</table>
</body>
</html>