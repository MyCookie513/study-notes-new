<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

<meta http-equiv="refresh" content="10"> 
<title>课程添加成功</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/ArtFire/WebRoot/CourseAddSuccess.jsp">
	    <script  type="text/javascript" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-1" data-genuitec-path="/ArtFire/WebRoot/CourseAddSuccess.jsp"> 
	function delayURL(url) { 
	var delay=document.getElementById("time").innerHTML; 
	//最后的innerHTML不能丢，否则delay为一个对象 
	if(delay>0){ 
	delay--; 
	document.getElementById("time").innerHTML=delay; 
	}else{ 
	/* window.top.location.href="javascript:history.go(-1);location.reload()"; */
	window.location.href=url;
	} 
	setTimeout("delayURL('" + url + "')", 1000); 
	//此处1000毫秒即每一秒跳转一次 
	} 
	</script>
	<div>课程添加成功</div> 
	<span id="time" style="background: red">3</span> 
	秒钟之后自动跳转！
	<br/>
	<script type="text/javascript"> 
	delayURL("framejsp/teacherjsp/CourseADD.jsp"); 
	</script> 
</body>
</html>