<%@page import="com.cn.hibernate_javabean.Ach_repair"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>所有商品信息</title>
<style type="text/css">
	td{font-size: 12px;}
	h2{margin: 0px}
</style>
</head>
<body>
<table align="center" width="450" border="1" height="180" bordercolor="white" bgcolor="black" cellpadding="1" cellspacing="1">
	<tr bgcolor="white">
		<td align="center" colspan="5">
			<h2>所有故障维修信息</h2>
		</td>
	</tr>
	<tr align="center" bgcolor="#e1ffc1" >
		<td><b>设备ID</b></td>
		<td><b>报警时间</b></td>
		<td><b>报警信息</b></td>
		<td><b>维修人员</b></td>
		<td><b>维修记录</b></td>
	</tr>
	<% 
		List<Ach_repair> list = (List<Ach_repair>)request.getAttribute("repair_list");
		for(Ach_repair repair : list){
	%>
	<tr align="center" bgcolor="white">
		
		<td><%=repair.getAch_information().getAch_ID()%></td>
		<td><%=repair.getAlert_time()%></td>
		<td><%=repair.getAlert_infor()%></td>
		<td><%=repair.getMaintain_staff()%></td>
		<td><%=repair.getMaintain_status()%></td>
	</tr>
	<%	
		}
	%>
	<tr>
		<%-- <td align="center" colspan="5" bgcolor="white">
			<%=request.getAttribute("bar")%>
		</td> --%>
	</tr>
</table>
</body>
</html>