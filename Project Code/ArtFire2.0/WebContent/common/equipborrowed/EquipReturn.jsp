<%@ page language="java" import="java.util.*" pageEncoding="utf-8"
	contentType="text/html; charset=utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	request.setCharacterEncoding("utf-8");
	String username = (String) session.getAttribute("username");
	String equipid = (String)request.getParameter("equipid");
	String equipname = (String)request.getParameter("equipname");
	String borrowtime = (String)request.getParameter("borrowtime");
	String planreturntime = (String)request.getParameter("planreturntime");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'EquipReturn.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script src="static/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript">
	$().ready(function() {
		gettime();
		/* getMD(); */
	});
	function gettime() {
		var d = new Date();
		var vYear = d.getFullYear();
		var vMonth = d.getMonth() + 1;
		var vDate = d.getDate();
		document.getElementById("realreturntime").value = vYear+"-"+vMonth+"-"+vDate;
		/* document.getElementById("borrowtime1").value = vYear;
		document.getElementById("borrowtime2").value = vMonth;
		document.getElementById("borrowtime3").value = vDate; */
		/*      var html='<option value="'+(vYear)+'">'+(vYear)+'</option>';
		     var html2='<option value="'+(vMonth)+'">'+(vMonth+1)+'</option>';
		     var html3='<option value="'+(vDate)+'">'+(vDate)+'</option>';
		     $("#borrowtime1").append(html); 
		     $("#borrowtime2").append(html2); $("#borrowtime3").append(html3);  */
	}
	/* function getMD() {
		for (var i = 1; i <= 12; i++) {
			var html = '<option value="' + (i) + '">' + (i) + '</option>';
			$("#returntime2").append(html);
		}
		for (var i = 1; i <= 24; i++) {
			var html = '<option value="' + (i) + '">' + (i) + '</option>';
			$("#returntime3").append(html);
		}

	} */
</script>

<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-21" data-genuitec-path="/ArtFire/WebRoot/framejsp/common/equipborrowed/EquipReturn.jsp">
	<div style="margin: 0;padding: 0;padding-top:2%;height: 10%;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-21" data-genuitec-path="/ArtFire/WebRoot/framejsp/common/equipborrowed/EquipReturn.jsp">
		<span style="font-size: 170%;color: red;">设备归还</span>
	</div>
	<hr>
	<form action="<%=path %>/returnequip.do" method="post" id="form">
		<table border="0" width="60%" align="center">
			<tr>
				<td width="20%">归还人:</td>
				<td><input type="text" name="returnperson" class="returnperson"
					id="returnperson" readonly="true" value="<%=username%>"><span
					id="returnperson"></span></td>
			</tr>
			<tr>
				<td width="20%">设备编号:</td>
				<td><input type="text" name="equipid" class="returnperson"
					id="equipid" readonly="true" value="<%=equipid%>"><span
					id="equipid"></span></td>
			</tr>
			<tr>
				<td width="20%">设备名称:</td>
				<td><input type="text" name="equipname" class="returnperson"
					id="equipname" readonly="true" value="<%=equipname%>"><span
					id="equipname"></span></td>
			</tr>
			<tr>
				<td width="20%">借用日期:</td>
				<td><input type="text" name="borrowtime" class="returnperson"
					id="borrowtime" readonly="true" value="<%=borrowtime%>"><span
					id="borrowtime"></span></td>
			</tr>
			<tr>
				<td width="20%">计划归还日期:</td>
				<td><input type="text" name="planreturntime" class="returnperson"
					id="planreturntime" readonly="true" value="<%=planreturntime%>"><span
					id="planreturntime"></span></td>
			</tr>
			<tr>
				<td>实际归还日期:</td>
				<td><input type="text" name="realreturntime" class="returnperson"
					id="realreturntime" readonly="true" value=""><span
					id="realreturntime"></span></td>
			</tr>
			<!-- <tr>
				<td>是否损坏:</td>
				<td><input type="radio" name="damage" value="已损坏" checked>
					是 <input type="radio" name="damage" value="完好"> 否</td>
			</tr> -->
			<!-- <tr>
				<td id="stunum">备注:</td>
				<td><input type="text" class="num" name="num" id="num"><span
					id="numSpan"></span></td>
			</tr> -->
			<tr>
				<td id="demo" colspan="2"><span style="color: red;">请确认设备归还信息，提交后无法修改！</span></td>
			</tr>
			<tr>
				<td></td>
				<td>
					<button type="submit">提交信息</button>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>
