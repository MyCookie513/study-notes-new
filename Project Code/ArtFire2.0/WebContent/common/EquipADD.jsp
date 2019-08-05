<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	String username = (String) session.getAttribute("username");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>设备录入界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript" src="static/js/checkForm.js">
	
</script>
<script src="static/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript">
	$().ready(function() {
		getEquipBuyTime();
	});

	function getEquipBuyTime() {
		var date = new Date();
		var year = date.getFullYear();
		for (var i = -3; i <= 0; i++) {
			if(i==0)
				var html = '<option value="' + (year+i) + '" selected>' + (year+i) + '</option>';
			else
				var html = '<option value="' + (year+i) + '">' + (year+i) + '</option>';
			$("#equipbuyyear").append(html);
		}
		for (var i = 1; i <= 12; i++) {
			var html = '<option value="' + (i) + '">' + (i) + '</option>';
			$("#equipbuymonth").append(html);
		}
		for (var i = 1; i <= 31; i++) {
			var html = '<option value="' + (i) + '">' + (i) + '</option>';
			$("#equipbuyday").append(html);
		}

	}
</script>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-9" data-genuitec-path="/ArtFire/WebRoot/framejsp/common/EquipADD.jsp">
	<div style="margin:0;padding:0; height: 6%" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-9" data-genuitec-path="/ArtFire/WebRoot/framejsp/common/EquipADD.jsp">
		<span
			style="color:red;font-weight: normal;font-size:160%;margin-left: 10px;">设备录入</span>
	</div>
	<hr>
	<form action="equipadd.do" method="post" id="form">
		<table border="0" width="60%" align="center">
			<tr>
				<td width="30%">设备编号:</td>
				<td><input type="text" name="equipid" id="equipid" value="">
				</td>
			</tr>
			<tr>
				<td width="30%">设备名称:</td>
				<td><input type="text" name="equipname" id="equipname" value="">
				</td>
			</tr>
			<!-- <tr>
				<td width="30%">设备数量:</td>
				<td><input type="text" name="equipnum" id="equipnum" value="">
				</td>
			</tr> -->
			<tr>
				<td width="30%">设备规格:</td>
				<td><input type="text" name="equipspec" id="equipspec" value="">
				</td>
			</tr>
			<tr>
				<td width="30%">设备厂家:</td>
				<td><input type="text" name="equipvender" id="equipvender"
					value=""></td>
			</tr>
			<tr>
				<td width="30%">设备所在房间号:</td>
				<td><input type="text" name="equiproomnum" id="equiproomnum"
					value=""></td>
			</tr>
			<tr>
				<td width="30%">设备所在实验室名称:</td>
				<td><input type="text" name="equiproomname" id="equiproomname"
					value=""></td>
			</tr>
			<tr>
				<td>设备购置时间:</td>
				<td><select name="equipbuyyear" class="equipbuyyear"
					id="equipbuyyear"></select>
				<!-- <input type="text" name="equipbuyyear" class="equipbuyyear"
					id="equipbuyyear" style="text-align:center;width:45px"> --><span>-</span>
					<select name="equipbuymonth" class="equipbuymonth"
					id="equipbuymonth"></select><span>-</span> <select
					name="equipbuyday" class="equipbuyday" id="equipbuyday"></select></td>
			</tr>
			<tr>
				<td id="demo">设备录入信息！</td>
				<td><input type="hidden" name="equipflag" id="equipflag"
					value="0">
					<button type="submit">提交信息</button></td>
			</tr>
		</table>
	</form>
</body>
</html>
