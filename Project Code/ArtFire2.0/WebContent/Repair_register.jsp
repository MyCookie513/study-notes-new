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
        
        <form action="repair_register_Action" method="post" id="form">
            <table border="0" width="60%" align="center" cellpadding="5" cellspacing="0">
                <tr>
                    <td width="20%">
                        设备ID:
                    </td>
                    <td>
                        <input type="text" name="address" class="username" id="address"><span id="usernameSpan"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        报警信息:
                    </td>
                    <td>
                        <input type="text" name="password" class="password"id="password0" oncontextmenu="return false" onpaste="return false"><span id="passwordSpan"></span>
                    </td>
                </tr>
               
           
         
               <tr>
                    <td id="stunum">
                                维修人员姓名:
                    </td>
                    <td>
                        <input type="text" class="username" name="install_staff" id="install_staff"><span id="install_staffSpan"></span>

                    </td>
                </tr>
     
                  <tr>
                    <td >
                                维修记录:
                    </td>
                    <td>
                        <input type="text" class="username" name="username" id="username"><span id="usernamespan"></span>
                    </td>
                </tr>

       <tr>
                  <td id="demo" >
                                          维修时间默认为注册时间
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
		var password = document.getElementById("password0").value;
		 
		  var install_staff = document.getElementById("install_staff").value;

		   var username= document.getElementById("username").value;
		   if (username== "") {
				alert("  维修记录不能为空");
				return false;
			}
			
		  if (install_staff == "") {
			alert("维修人员姓名:不能为空"+touch_screen);
			
			return false;
		}
		
			
		  
		  if (password == "") {
			alert("报警信息不为空");
			return false;
		}
		
		if (address == "") {
			alert("设备ID不能为空");
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



 

