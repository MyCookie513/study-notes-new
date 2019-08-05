<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>

<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="en">

<head>
<title>壁炉网络管理平台</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="stylesheet" href="${pageContext.request.contextPath}/login/bootstrap.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/login/css/camera.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/login/bootstrap-responsive.min.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/login/matrix-login.css" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/login/font-awesome.css" />
<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.5.1.min.js"></script>
<script type="text/javascript">
	function register() {
		alert("注册禁用！！！需要注册帐号请联系管理员~");
	}
</script>
<style type="text/css">
h7 {
	font-size: 30px;
	font-weight: 600;
	text-shadow: 0 1px 4px rgba(0, 0, 0, .2)
}
</style>
<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>



<body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-57" data-genuitec-path="/ArtFire/WebRoot/login.jsp">
	<div
		style="width:100%;text-align: center;margin: 0 auto;position: absolute;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-57" data-genuitec-path="/ArtFire/WebRoot/login.jsp">
		
		<div id="loginbox">
			<h1 style="color: red;font-size: 60px;font-weight: normal;font-family: 华文行楷";>监测管理系统</h1>
			
			<form method="post" action="${pageContext.request.contextPath }/login" name="loginForm" id="loginForm">
				<div class="control-group normal_text">
				<h3></h3>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_lg"> <i><img height="30"
									src="/login/user.png" /></i>
							</span><input type="text" name="loginname" id="idmun"
								placeholder="请输入帐号" value="" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly"> <i><img height="30"
									src="${pageContext.request.contextPath}/login/suo.png" /></i>
							</span><input type="password" name="password" id="password"
								placeholder="请输入密码" value="" />
						</div>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						<div class="main_input_box">
							<span class="add-on bg_ly"> <i><img height="30"
									src="${pageContext.request.contextPath}/login/suo.png" /></i>
							</span> <select class="ui dropdown" name="permission"
								style="width: 77%;margin:0;padding: 0;margin-left: -7px;margin-bottom: 2px;">
								<option value="0">超级管理员</option>
								<option value="1">公司管理员</option>
								<option value="2">维修人员</option>
								<option value="3">用户</option>
							</select>
						</div>
					</div>
				</div>
				<div class="form-actions">
					<div style="width:80%;padding-left:6%;">
						<span class="pull-right" style="padding-right:3%;"> 
						 
						<a	href="Register.jsp" class="btn btn-success">注册</a> 
							
				   <!-- <a href="javascript:register()" class="btn btn-success">注册</a> -->
						</span> <span style="padding-right:10%;" class="pull-right"><a
							onclick="add();" class="flip-link btn btn-info" id="to-recover">登录</a></span>
					</div>
				</div>
			</form>



		</div>
	</div>
	<div id="templatemo_banner_slide" class="container_wapper">
		<div class="camera_wrap camera_emboss" id="camera_slide">
			<div data-src="${pageContext.request.contextPath}/login/images/banner_slide_04.jpg"></div>
			<div data-src="${pageContext.request.contextPath}/login/images/banner_slide_05.jpg"></div>
			<div data-src="${pageContext.request.contextPath}/login/images/banner_slide_06.jpg"></div>
		</div>
	</div>
	<script type="text/javascript">
		function add() {
			if (check()) {
				document.getElementById("loginForm").submit();
			}
		}
		function check() {
			var password = document.getElementById("password").value;
			if (password == "") {
				alert("密码不为空");
				return false;
			}
			if (password.length < 1) {
				alert("请输入密码");
				return false;
			}
			return true;
		}
		var account="<%= request.getAttribute("Account")%>";
		if(account>0)
			alert("注册的账户为："+account+",请进行登陆");
		var fsd="<%= request.getAttribute("fail")%>";
		if(fsd=="password")
			alert("密码错误,请重新进行登陆");
	</script>


    <script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-1.7.2.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/jquery.easing.1.3.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/camera.min.js"></script>
	<script src="${pageContext.request.contextPath}/login/js/templatemo_script.js"></script>
</body>

</html>