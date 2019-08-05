<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>欢迎页</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/amazeui.min.css" />
<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
<script src="${pageContext.request.contextPath}/js/amazeui.min.js"></script>
<style type="text/css">
.centerp {
	font-family: '微软雅黑';
	font-size: 20px;
}
img{
	width: 100%;
	height: 100%;
}
</style>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-56" data-genuitec-path="/ArtFire/WebRoot/framejsp/welcome.jsp">
<div style="margin: 0;padding: 0;width: 100%;height: 100%;overflow: hidden;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-56" data-genuitec-path="/ArtFire/WebRoot/framejsp/welcome.jsp">
	<div data-am-widget="slider" class="am-slider am-slider-b1" data-am-slider='{&quot;controlNav&quot;:false}' >
	  <ul class="am-slides">
	      <li>
	        	<img src="${pageContext.request.contextPath}/Images/index_0.jpg">
	         
	      </li>
	      <li>
	        	<img src="${pageContext.request.contextPath}/Images/index_1.jpg">
	         
	      </li>
	      <li>
	        	<img src="${pageContext.request.contextPath}/Images/index_2.jpg">
	         
	      </li>
	      <li>
	        	<img src="${pageContext.request.contextPath}/Images/index_3.jpg">
	         
	      </li>
	  </ul>
	</div>
</div>
</body>
</html>
