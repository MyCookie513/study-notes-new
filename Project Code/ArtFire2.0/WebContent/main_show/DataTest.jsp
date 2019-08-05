


<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
 <script language="javascript" src="../js/AjaxRequest.js"></script>
 <script language="javascript" src="../js/json2.js"></script>
<script language="javascript">

/*****************错误处理的方法*******************************/
function onerror(){
	alert("您的操作有误！");
}
/******************实例化Ajax对象的方法*******************************/
function getInfo(){
	var loader=new net.AjaxRequest("updateAction?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");
}
/************************回调函数**************************************/
function deal_getInfo(){
	//alert(this.req.responseText.trim());
	var json_data=JSON.parse('['+this.req.responseText.trim()+']');
	//alert(json_data[0].addtime);
	document.getElementById("alert_status").innerHTML=json_data[0].system_state;
	 document.getElementById("ach_id").innerHTML=json_data[0].id;
	document.getElementById("name").innerHTML=json_data[0].name;
	document.getElementById("type").innerHTML=json_data[0].type;
	document.getElementById("touch_screen").innerHTML=json_data[0].touch_screen;
	document.getElementById("Alcohol_level").innerHTML=json_data[0].jiujingyewei;
	document.getElementById("Alcohol_angle").innerHTML=json_data[0].jibanwendu;
	document.getElementById("Alcohol_Ci").innerHTML=json_data[0].fire_tem;
	document.getElementById("CO2_Ci").innerHTML=json_data[0].first_level;
	document.getElementById("Machine_Temp").innerHTML=json_data[0].second_level;
	document.getElementById("Weeping_alert").innerHTML=json_data[0].anzhuang_time;
	document.getElementById("updatetime").innerHTML=json_data[0].addtime;
 }
window.onload=function(){
	getInfo();	//调用getInfo()方法获取公告信息
	window.setInterval("getInfo()", 6000);	//每隔10分钟调用一次getInfo()方法
} 
</script>
<base href="<%="默认连接地址"%>">

<title>实时状态</title>



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
	font-size: 700%;
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
	<h1 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-34" data-genuitec-path="/ArtFire/WebRoot/framejsp/online_manage/DataTest.jsp">实时状态</h1>
	<br>
	<div id="showInfo"></div>
	<div>
		<div
			style="width: 40%;height: 50%;text-align:center;display: inline-block;overflow: hidden;">
			<span class="hh">设备状态</span><br /> <br> <span class="hd" id="alert_status"><%=request.getAttribute("system_state") %></span>
		</div>
		<div
			style="width: 60%;height: 80%;text-align:left;display: inline-block;float:right;overflow: hidden;">
			<span class="infor">设备编号：</span><span class="infor" id="ach_id"><%=request.getAttribute("id") %></span><br/>
			<span class="infor">持有人：</span><span class="infor" id="name"><%=request.getAttribute("name") %></span><br/>
			<span class="infor">设备类型：</span><span class="infor" id="type"><%=request.getAttribute("type") %></span><br/>
			<span class="infor">是否有触摸屏：</span><span class="infor" id="touch_screen"><%=request.getAttribute("touch_screen") %></span><br/>
			<span class="infor">酒精液位：</span><span class="infor" id="Alcohol_level"><%=request.getAttribute("jiujingyewei") %></span><br/>
			<span class="infor">基板温度：</span><span class="infor" id="Alcohol_angle"><%=request.getAttribute("jibanwendu") %></span><br/>
			<span class="infor">火焰温度：</span><span class="infor" id="Alcohol_Ci"><%=request.getAttribute("fire_tem") %></span><br/>
			<span class="infor">一级液位：</span><span class="infor" id="CO2_Ci"><%=request.getAttribute("first_level") %></span><br/>
			<span class="infor">二级液位：</span><span class="infor" id="Machine_Temp"><%=request.getAttribute("second_level") %></span><br/>
			<span class="infor">安装时间：</span><span class="infor" id="Weeping_alert"><%=request.getAttribute("anzhuang_time") %></span><br/><br/>
			<span class="infor">最后更新时间：</span><span class="infor" id="updatetime"><%=request.getAttribute("addtime") %></span><br/>
		</div>
	</div>

</body>
</html>

