<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>Installation_icon</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript" src="<%=path %>/framejsp/js/jquery-1.11.0.min.js"></script>
	<link rel="stylesheet" type="text/css" href="<%=path %>/framejsp/css/amazeui.min.css">
	<script type="text/javascript" src="<%=path %>/framejsp/js/amazeui.min.js"></script>
  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-32" data-genuitec-path="/ArtFire/WebRoot/framejsp/faq/Installation_icon.jsp">
    <h1 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-32" data-genuitec-path="/ArtFire/WebRoot/framejsp/faq/Installation_icon.jsp">安装图示说明</h1> <br>
    <div class="am-panel-group" id="accordion">
  <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-1'}">
        壁炉安装方式
      </h4>
    </div>
    <div id="do-not-say-1" class="am-panel-collapse am-collapse am-in">
      <div class="am-panel-bd">
        ...
      </div>
    </div>
  </div>
  <!-- <div class="am-panel am-panel-default">
    <div class="am-panel-hd">
      <h4 class="am-panel-title" data-am-collapse="{parent: '#accordion', target: '#do-not-say-2'}">
        ...
      </h4>
    </div>
    <div id="do-not-say-2" class="am-panel-collapse am-collapse">
      <div class="am-panel-bd">
        ...
      </div>
    </div>
  </div> -->
</div>
  </body>
</html>
