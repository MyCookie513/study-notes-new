<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="../css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="../js/jquery.js"></script>

<script type="text/javascript">
$(function(){	
	//导航切换
	$(".menuson .header").click(function(){
		var $parent = $(this).parent();
		$(".menuson>li.active").not($parent).removeClass("active open").find('.sub-menus').hide();
		
		$parent.addClass("active");
		if(!!$(this).next('.sub-menus').size()){
			if($parent.hasClass("open")){
				$parent.removeClass("open").find('.sub-menus').hide();
			}else{
				$parent.addClass("open").find('.sub-menus').show();	
			}
			
			
		}
	});
	
	// 三级菜单点击
	$('.sub-menus li').click(function(e) {
        $(".sub-menus li.active").removeClass("active")
		$(this).addClass("active");
    });
	
	$('.title').click(function(){
		var $ul = $(this).next('ul');
		$('dd').find('.menuson').slideUp();
		if($ul.is(':visible')){
			$(this).next('.menuson').slideUp();
		}else{
			$(this).next('.menuson').slideDown();
		}
	});
})	
</script>


<script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>

<body style="background:#fff3e1;" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-53" data-genuitec-path="/ArtFire/WebRoot/framejsp/teacherleft.jsp">
	
	
	
	
    <!-- 利用div标签实现一个新的标题 -->
	<div class="lefttop" data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-53" data-genuitec-path="/ArtFire/WebRoot/framejsp/teacherleft.jsp"><span></span>功能菜单</div>
    
    <dl class="leftmenu">
        
    <dd>
    <div class="title">
    <span><img src="../images/leftico01.png" /></span>壁炉网络管理平台
    </div>
    	<ul class="menuson">
        <li>
            <div class="header">
            <cite></cite>
            <a href="common/Handmade_charm.jsp" target="rightFrame">手工魅力</a>
            <i></i>
            </div>
        </li><li>
            <div class="header">
            <cite></cite>
            <a href="common/Know_us.jsp" target="rightFrame">认识勇舜</a>
            <i></i>
            </div>
        </li><li>
            <div class="header">
            <cite></cite>
            <a href="common/Future_prospects.jsp" target="rightFrame">未来展望</a>
            <i></i>
            </div>
        </li><li>
            <div class="header">
            <cite></cite>
            <a href="common/Fireplace_value.jsp" target="rightFrame">壁炉价值</a>
            <i></i>
            </div>
        </li><li>
            <div class="header">
            <cite></cite>
            <a href="common/Fireplace_type.jsp" target="rightFrame">壁炉种类</a>
            <i></i>
            </div>
        </li>
       </ul>    
    </dd>
        
    
     <dd>
    <div class="title">
    <span><img src="../images/leftico02.png" /></span>在线管理
    </div>
    <ul class="menuson">
    <li>
            <div class="header">
            <cite></cite>
            <a href="dataAction" target="rightFrame">实时状态</a>
            <i></i>
            </div>                
        </li>
        
        <li > <div class="header">
            <cite></cite>
            <a href="online_manage/Short_term_alarm.jsp" target="rightFrame">近期报警</a>
            <i></i>
            </div>    </li>
            
        <li > <div class="header">
            <cite></cite>
            <a href="../Repair_register.jsp" target="rightFrame">手动报修</a>
            <i></i>
            </div>   
        </li>
       
        </ul>    
    </dd> 
    <!-- <dd>
    <div class="title"><span><img src="images/leftico04.png" /></span>成绩管理</div>
    <ul class="menuson">
        <li><cite></cite><a href="teacherjsp/ScoreAddIndex.jsp"  target="rightFrame">成绩录入</a><i></i></li>    </ul>
    </dd>    --> 
    <dd>
    <div class="title"><span><img src="../images/leftico04.png" /></span>常见问题</div>
    <ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="faq/General_problem.jsp" target="rightFrame">一般问题</a>
            <i></i>
            </div>
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="faq/Security_issue.jsp" target="rightFrame">安全问题</a>
            <i></i>
            </div>                
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="faq/Installation_icon.jsp" target="rightFrame">安装图示说明</a>
            <i></i>
            </div>                
        </li>
       </ul>    
    </dd>
    <dd>
    <div class="title"><span><img src="../images/leftico04.png" /></span>联系我们</div>
    <ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="contact_us/Technical_support.jsp" target="rightFrame">技术支持</a>
            <i></i>
            </div>
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="contact_us/Merchants_association.jsp" target="rightFrame">招商加盟</a>
            <i></i>
            </div>                
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="contact_us/Online_customer_service.jsp" target="rightFrame">在线客服</a>
            <i></i>
            </div>                
        </li>
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="contact_us/Feedback.jsp" target="rightFrame">意见反馈</a>
            <i></i>
            </div>                
        </li>
        
        </ul>    
    
    </dd>
    
    <%-- <dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>实验室规章制度
			</div>
			<ul class="menuson">
				<li>
					<div class="header">
						<cite></cite> <a href="<%=path %>/flexpaper/index.html?doc=2"
							target="rightFrame">实验室仪器设备管理办法</a> <i></i>
					</div>
				</li>
				<li>
					<div class="header">
						<cite></cite> <a href="<%=path %>/flexpaper/index.html?doc=5"
							target="rightFrame">实验项目要求</a> <i></i>
					</div>
				</li>
			</ul>
		</dd>

		<dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>实践教学体系
			</div>
			<ul class="menuson">
				<li>
					<div class="header">
						<cite></cite> <a href="<%=path %>/flexpaper/index.html?doc=1"
							target="rightFrame">实践教学体系简介</a> <i></i>
					</div>
				</li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>中心管理体制
			</div>
			<ul class="menuson">
				<li>
					<div class="header">
						<cite></cite> <a href="<%=path %>/flexpaper/index.html?doc=3"
							target="rightFrame">中心管理体制简介</a> <i></i>
					</div>
				</li>
			</ul>
		</dd>
		
		<dd>
			<div class="title">
				<span><img src="images/leftico02.png" /></span>中心开放体制
			</div>
			<ul class="menuson">
				<li>
					<div class="header">
						<cite></cite> <a href="<%=path %>/flexpaper/index.html?doc=4"
							target="rightFrame">中心开放体制简介</a> <i></i>
					</div>
				</li>
			</ul>
		</dd>     --%>
    
    </dl>
    
</body>
</html>
