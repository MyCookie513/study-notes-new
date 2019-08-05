<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
/* String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
 */%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>top</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>
<script type="text/javascript">
$(function(){	
	//顶部导航切换
	$(".nav li a").click(function(){
		$(".nav li a.selected").removeClass("selected")
		$(this).addClass("selected");
	})	
})	
</script>
<script type="text/javascript">
	function greg(){
		alert("工作台禁用！！！");
	}
	function xreg(){
		alert("系统设置禁用！！！");
	}
</script>

<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>



<body style="background:url(../images/topbg.gif) repeat-x;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-54" data-genuitec-path="/ArtFire/WebRoot/framejsp/top.jsp">

    <div class="topleft" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-54" data-genuitec-path="/ArtFire/WebRoot/framejsp/top.jsp">
     <a href="<%=path %>/framejsp/welcome.jsp" target="rightFrame"><img src="../images/ArtFire_logo.png" title="系统首页" width="250" height="70" /></a>
    </div>
        
    <ul class="nav">
    <li><a href="javascript:greg()" target="rightFrame"><img src="../images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    <li><a href="imgtable.html" target="rightFrame"><img src="../images/icon02.png" title="模型管理" /><h2>模型管理</h2></a></li>
    <li><a href="imglist.html"  target="rightFrame"><img src="../images/icon03.png" title="模块设计" /><h2>模块设计</h2></a></li>
    <li><a href="../google.jsp"  target="rightFrame"><img src="../images/icon04.png" title="常用工具" /><h2>维修记录</h2></a></li>
    <li><a href="computer.html" target="rightFrame"><img src="../images/icon05.png" title="文件管理" /><h2>文件管理</h2></a></li>  
    <%-- <li><a href="javascript:xreg()"  target="rightFrame"><img src="../images/icon06.png" title="系统设置" /><h2>系统设置</h2></a></li>
    <li><a href="<%=path %>/getquestions.do" target="rightFrame"><img src="../images/icon03.png" title="学生问答区" /><h2>学生问答区</h2></a></li>
     --%></ul>
            
    <div class="topright">
    
    <ul>
    <li><span><img src="../images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
    <li><a href="<%=path %>/framejsp/updatepassword/index.jsp" target="rightFrame">修改密码</a></li>
    <li><a href="<%=path %>/logout.do" target="_parent">退出</a></li>
    </ul>
     
    <div class="user">
    <span><%=session.getAttribute("username") %></span>
    <i>消息</i>
    <b></b>   
    </div>    
    
    </div>

</body>
</html>
