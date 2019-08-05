<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Handmade_charm</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
		*{
			margin: 0;
			padding: 0;
		}
	</style>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-18" data-genuitec-path="/ArtFire/WebRoot/framejsp/common/Handmade_charm.jsp">
    <div style="height: 90%;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-18" data-genuitec-path="/ArtFire/WebRoot/framejsp/common/Handmade_charm.jsp">
    	<div style="width: 20%;height: 100%;float: left;display:flex; align-items:center;justify-content:flex-end;">
    		<img alt="远程近程协同控制" src="<%=path %>/framejsp/images/yuancheng.jpg">
    	</div>
    	<div style="width: 80%;height: 100%;float: right;display:flex; align-items:center;justify-content:flex-start;">
    		<div style="padding-left:6px;width: 80%;font-family: 微软雅黑;font-size: 160%;">远程近程协同控制</div>
    		<div style="padding-left:6px;width: 80%;font-family: 微软雅黑;font-size: 120%;">WiFi多连接模式下TCP/IP协议，同时上传数据到遥控器和公网服务器。</div>
    	</div>
    </div>
  </body>
</html>
