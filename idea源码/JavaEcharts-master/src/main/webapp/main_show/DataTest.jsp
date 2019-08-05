


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <script language="javascript" src="../js/AjaxRequest.js"></script>
 <script language="javascript" src="../js/json2.js"></script>
<script language="javascript">

</script>
<base href="<%="默认连接地址"%>">

<title>用户面板</title>



<style type="text/css">
h1 {
	font-weight: bold;
	font-family: "微软雅黑";
	font-size: 250%;
}

div {
	margin: 0;
	padding: 0;
}

.hh {
	font-size: 250%;
	font-weight: bold;
}

.hd {
	font-size: 300%;
	color: red;
}

.infor {
	font-size: 200%;
}
</style>
<script>
"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);
</script>
</head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-34" data-genuitec-path="/ArtFire/WebRoot/framejsp/online_manage/DataTest.jsp">
	<h1 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-34" data-genuitec-path="/ArtFire/WebRoot/framejsp/online_manage/DataTest.jsp">我的信息</h1>
	<br>
	<div id="showInfo"></div>
	<div>
		<div
			style="width: 40%;height: 50%;text-align:center;display: inline-block;overflow: hidden;">
			<span class="hh">User</span><br /> <br> <span class="hd" id="alert_status">Student</span>
		</div>
		<div
			style="width: 60%;height: 80%;text-align:left;display: inline-block;float:right;overflow: hidden;">
			<span class="infor">学号：</span><span class="infor" id="ach_id">${user.loginname}</span><br/>
			<span class="infor">姓名：</span><span class="infor" id="name">${user.name}</span><br/>
			<span class="infor">实验室：</span><span class="infor" id="type">${user.sex}</span><br/>
			<span class="infor">序列：</span><span class="infor" id="touch_screen">${user.id}</span><br/>

		</div>
	</div>

</body>
</html>

