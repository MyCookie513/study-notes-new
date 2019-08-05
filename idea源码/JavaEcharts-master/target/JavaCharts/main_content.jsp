<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
/* String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 */%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-102" data-genuitec-path="/ArtFire/WebRoot/teacherindex.jsp">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎使用管理平台</title>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>


<!-- 内置上下三层 -->
<frameset rows="88,*,18" cols="*" frameborder="no" border="0" framespacing="0">

  <frame src="menu_show/top.jsp" name="topFrame" scrolling="No" noresize="noresize" id="topFrame" title="topFrame" />
 
  <frameset cols="187,*" frameborder="no" border="0" framespacing="0">
    <frame src="menu_show/menu.jsp" name="leftFrame" scrolling="No" noresize="noresize" id="leftFrame" title="leftFrame" />
    <frame src="main_show/welcome.jsp" name="rightFrame" id="rightFrame" scrolling="Yes" title="rightFrame" text-align="center" />
  
  </frameset>
  <frame src="menu_show/bottom.jsp" name="bottomFrame" scrolling="No" noresize="noresize" id="bottomFrame" title="bottomFrame" />

</frameset>
<noframes>
<body>
</body></noframes>
</html>

