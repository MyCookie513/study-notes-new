<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

    <head>
        <style type="text/css">
            input[type = "text"], input[type = "password"] {
                width: 150px;
            }
            #form label.error{
            	color:red
            }
            #btn{
               margin-top: 20px;
            }
            button{
                width: 100px;
                height: 40px;
                border-radius: 6px;
                background-color: #00a0c6;
            }
            #form{
                margin-top: 20px;
            }

            #form table{
                margin-left: 40%;
            }
            #form div>label{
                width: 100px !important;
                text-align:right;
                background: red;
            }
            #form table input{
                border-radius: 5px;
            }
            .register{
                display: inline-block;
                margin-left: 45%;
                margin-top: 20px;
            }

        </style>
        
    <body>
        <div class="userAction!register" >
            
        </div>
        
        <form action="userAction!register" method="post" id="form">
            <table border="0" width="60%" align="center" cellpadding="5" cellspacing="0">
                <tr>
                    <td width="20%">
                        家庭地址:
                    </td>
                    <td>
                        <input type="text" name="address" class="username" id="address"><span id="usernameSpan"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        注册密码:
                    </td>
                    <td>
                        <input type="password" name="password" class="password"id="password" oncontextmenu="return false" onpaste="return false"><span id="passwordSpan"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                                确认密码:
                    </td>
                    <td>
                        <input type="password" name="confirm_password" class="confirm_password"id="confirm_password"><span id="confirmSpan"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                                壁炉类型:
                    </td>
                    <td>
                        <input type="radio" name="type" id="type" value="small" > 小型壁炉
                        <input type="radio" name="type" id="type" value="big"> 大型壁炉
                    </td>
                </tr>
                <tr>
                    <td>
                        是否有触摸屏:
                    </td>
                    <td>
                        <input type="radio" name="touch_screen" id="touch_screen" value="yes" > 有
                        <input type="radio" name="touch_screen" id="touch_screen" value="no"> 无
                    </td>
                </tr>
               <tr>
                    <td id="stunum">
                                安装人员姓名:
                    </td>
                    <td>
                        <input type="text" class="username" name="install_staff" id="install_staff"><span id="install_staffSpan"></span>

                    </td>
                </tr>
     
                  <tr>
                    <td >
                                用户姓名:
                    </td>
                    <td>
                        <input type="text" class="username" name="username" id="username"><span id="usernamespan"></span>
                    </td>
                </tr>

               <tr>
                    <td>
                        手机号:
                    </td>
                    <td>
                        <input type="text" name="phone" class="username" id="phone_num">
                    </td>
                </tr>
                <tr>
                  <td id="demo" >
                                            用户注册（安装者辅助）！
                     </td>
                    <td>
                        <button  type="button" onclick="add();">提交信息</button>
                    </td>
                </tr>
                <tr>
                    <td id="login">
                   
                    </td>
                    <td id="login_result">
                    </td>
                </tr>
                <tr>
            </table>
        </form>
  
   <Script  >
   
   
   
   
   function onerror(){
		alert("您的操作有误！");
	}
	/******************实例化Ajax对象的方法*******************************/
	function getInfo(){
		var loader=new net.AjaxRequest("getInfo.jsp?nocache="+new Date().getTime(),deal_getInfo,onerror,"GET");
	}
	/************************回调函数**************************************/
	function deal_getInfo(){
		document.getElementById("showInfo").innerHTML=this.req.responseText;
	}
	window.onload=function(){
		getInfo();	//调用getInfo()方法获取公告信息
		//window.setInterval("getInfo()", 600000);	//每隔10分钟调用一次getInfo()方法
	}
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
  function btn2(){
 document.getElementById("flag").value='1';
  document.getElementById("stugrade").style.visibility="hidden";//显示  
  document.getElementById("stuclass").style.visibility="hidden";//显示  
   teacherFunction();
}
  function btn1(){
	  document.getElementById("flag").value='0';
	document.getElementById("stugrade").style.visibility="visible";//隐藏 
	document.getElementById("stuclass").style.visibility="visible";//隐藏 
	studentFunction();
	
}
	function studentFunction()
	{
	x=document.getElementById("demo");  // 找到元素
	x.innerHTML="学生信息注册";    // 改变内容
	y=document.getElementById("stunum");  // 找到元素
	y.innerHTML="学号:";    // 改变内容
	}
	function teacherFunction()
	{
	x=document.getElementById("demo");  // 找到元素
	x.innerHTML="教师信息注册";    // 改变内容
	y=document.getElementById("stunum");  // 找到元素
	y.innerHTML="工号:";    // 改变内容
	}

	function add() {
		if (check()) {
			document.getElementById("form").submit();
		}
	}
	function check() {
	  var address = document.getElementById("address").value;
	  var phone_num = document.getElementById("phone_num").value;
		var password = document.getElementById("password").value;
		  var confirmObj = document.getElementById("confirm_password").value;
		  var install_staff = document.getElementById("install_staff").value;

		   var username= document.getElementById("username").value;
		   if (username== "") {
				alert("用户名不能为空");
				return false;
			}
			
		  if (install_staff == "") {
			alert("安装人员不能为空"+touch_screen);
			
			return false;
		}
		  if (confirmObj == "") {
				alert("确认密码不能为空");
				return false;
			}
			
		  if (phone_num == "") {
				alert("手机号不能为空");
				return false;
			}
		  if (password == "") {
			alert("密码不为空");
			return false;
		}
		if (password.length < 6) {
			alert("请输入6位密码");
			return false;
		}
		if (address == "") {
			alert("地址不能为空");
			return false;
		}
	 
		
	
		
		
		
		return true;
	}
window.onload = function(){
     //通过ID或名字获取每个对象
  var usernameObj = document.getElementById("username");
  var passwordObj = document.getElementById("password");
  var confirmObj = document.getElementById("confirm_password");

  //设置每个对象的onblur事件(对象失去焦点时发生),并调用各自的方法
  usernameObj.onblur = checkUsername;
  passwordObj.onblur = checkPassword;
  confirmObj.onblur = checkConfirm;
 
  //当时失去光标的时候进行对
  function checkUsername(){
   var usernameValue = trim(usernameObj.value);
   var msg ="";
   if(usernameValue == null || usernameValue == "")
    msg ="<font color='red'>家庭住址必须填写!</font>";
   var span = document.getElementById("usernameSpan");
   span.innerHTML = msg;
  // return msg == "&nbsp;&nbsp;&nbsp;";
  }
  
  function checkPassword(){
   var passwordValue = passwordObj.value;
   var passwordRegex = /^\w{6}$/;
   var msg ="&nbsp;&nbsp;&nbsp;"; 
   if (!passwordValue)
    msg = "<font color='red'>密码必须填写!</font>";
   else
    if (!passwordRegex.test(passwordValue)) {
     msg = "<font color='red'>密码必须6位</font>";
     //alert(msg);
    }
   var span = document.getElementById("passwordSpan");
   span.innerHTML = msg;

  }
 
  function checkConfirm(){
   var confirmValue = confirmObj.value;
   var passwordValue = passwordObj.value;
   var msg ="&nbsp;&nbsp;&nbsp;";
   if (!confirmValue)
    msg = "<font color='red'>确认密码必须填写!</font>";
   else if (confirmValue != passwordValue)
    msg = "<font color='red'>密码必须一致!</font>";
   var span = document.getElementById("confirmSpan");
   span.innerHTML = msg;
    
  }
  
   
   
  

  
  
  
  //去除用户名前后的空格
  function trim(s){
   return s.replace(/^\s+|\s+$/g,"");
  }
  
  
 }
 
 </Script>
    </body>
</html>



 

