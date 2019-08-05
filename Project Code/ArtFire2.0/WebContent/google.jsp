<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>google</title>
<style type="text/css">

.container {
				width: 500px;
				height: 50px;
				margin: 100px auto;
			}
			
			.parent {
				width: 100%;
				height: 42px;
				top: 4px;
				position: relative;
			}
			
			.parent>input:first-of-type {
				/*输入框高度设置为40px, border占据2px，总高度为42px*/
				width: 380px;
				height: 40px; 
				border: 1px solid #ccc;
				font-size: 16px;
				outline: none;
			}
			
			.parent>input:first-of-type:focus {
				border: 1px solid #317ef3;
				padding-left: 10px;
			}
			
			.parent>input:last-of-type {
				/*button按钮border并不占据外围大小，设置高度42px*/
				width: 100px;
				height: 44px; 
				position: absolute;
				background: #317ef3;
				border: 1px solid #317ef3;
				color: #fff;
				font-size: 16px;
				outline: none;
			}
h1 {
	font-weight: bold;
	font-family: "微软雅黑";
	font-size: 130%;
}
</style>



</head>
<body>
<h1>输入所用设备的id号进行查询使用的维修记录</h1>
<div class="container">
    <form action="repairAction" class="parent" id="form">
        <input type="text" id="google_text" name="id">
        <input type="button" id="google"  onclick="Google()" value="搜索一下">
    </form>
</div>
<Script>

function  Google(){
	
	var google_text = document.getElementById("google_text").value;
	//看输入框内的数字是否符合正则表达式，如果符合的话提交表单，负责弹出框；
	  if (isNumber(google_text)) {
		  document.getElementById("form").submit();
		}else{
			
			alert("输入不为正确的ID号");
			
		}
}
function isNumber(str){
    var reg =/^([0-9])+$/;
    return reg.test(str);
}

</Script>
</body>

</html>