<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<%@ page import="java.sql.*" %>
<jsp:useBean id="conn" class="com.mysql.ConnDB" scope="page"></jsp:useBean>
<ul>
<%
ResultSet rs=conn.executeQuery("SELECT title FROM notice ORDER BY idNotice DESC");	//��ȡ������Ϣ
if(rs.next()){
	do{
		out.print("<li>"+rs.getString(1)+"</li>");
	}while(rs.next());
}else{
	out.print("<li>���޹�����Ϣ��</li>");
}
%>

</ul>