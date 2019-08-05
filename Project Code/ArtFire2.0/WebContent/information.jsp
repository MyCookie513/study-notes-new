<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB18030">
<script language="javascript" src="js/AjaxRequest.js"></script>
<script language="javascript">
/******************错误处理的方法*******************************/
function onerror(){
	alert("您的操作有误！");
}
/******************实例化Ajax对象的方法***************************+new Date().getTime()****/
function getInfo(){
	var loader=new net.AjaxRequest("getInfo.jsp?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");
}
/************************回调函数**************************************/
function deal_getInfo(){
	document.getElementById("showInfo").innerHTML=this.req.responseText;
}
window.onload=function(){
	getInfo();	//调用getInfo()方法获取公告信息
	window.setInterval("getInfo()", 6000);	//每隔10分钟调用一次getInfo()方法
}
</script>
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
<title>实时显示公告信息</title>
</head>
<body>
<div style="border: 1px solid;height: 50px; width:200px;padding: 5px;">
	<marquee direction="up" scrollamount="3">
		<div id="showInfo"></div>
	</marquee>
</div>
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
</body>
</html>