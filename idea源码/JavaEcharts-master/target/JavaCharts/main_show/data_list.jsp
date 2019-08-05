
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>历史数据信息</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
</head>
<body>
<table align="center" width="450" border="1" height="180" bordercolor="black" bgcolor="white" cellpadding="1" cellspacing="1">
	<tr bgcolor="white">
		<td align="center" colspan="5">
			<h2>历史数据信息</h2>
		</td>
	</tr>
	<tr align="center" bgcolor="#e1ffc1" >
		<td><b>类型</b></td>
		<td><b>温度</b></td>
		<td><b>湿度</b></td>
		<td><b>pm2.5</b></td>
		<td><b>风速</b></td>
		<td><b>SO2</b></td>
		<td><b>O3</b></td>
		<td><b>NO2</b></td>
		<td><b>time</b></td>
	</tr>
	<c:forEach items="${list}" var="sign" varStatus="vs">
		<tr align="center" bgcolor="#e1ffc1">

			<td align = "center">${sign.type}</td>
			<td align = "center">${sign.wendu}</td>
			<td align = "center">${sign.shidu}</td>
			<td align = "center">${sign.pm}</td>
			<td align = "center">${sign.fengsu}</td>
			<td align = "center">${sign.so2}</td>
			<td align = "center">${sign.o3}</td>
			<td align = "center">${sign.no2}</td>
			<td align = "center">${sign.time}</td>
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