<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();

%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="${pageContext.request.contextPath}/css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="${pageContext.request.contextPath}/js/jquery.js"></script>

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
            <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico02.png" /></span>我的主页</div>
            <ul class="menuson">
                <li><cite></cite><a href="../getUser"  target="rightFrame">USER Information</a><i></i></li>    </ul>
        </dd>


        <dd>
            <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico02.png" /></span>人员管理</div>
            <ul class="menuson">
                <li><cite></cite><a href="../getDataList"  target="rightFrame">签到信息</a><i></i></li>    </ul>
        </dd>


        <dd>
            <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico02.png" /></span>近地面</div>
            <ul class="menuson">
                <li><cite></cite><a href="../getByTypeAndlei?type=1&&canshu=wendu"  target="rightFrame">温度</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=1&&canshu=shidu"  target="rightFrame">湿度</a><i></i></li>
                <li><cite></cite><a href="../gettype1_qiti?type=1"  target="rightFrame">气体</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=1&&canshu=pm"  target="rightFrame">PM2.5</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=1&&canshu=fengsu"  target="rightFrame">风速</a><i></i></li>  </ul>
        </dd>

        <dd>
            <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico02.png" /></span>近地面远距离</div>
            <ul class="menuson">
                <li><cite></cite><a href="../getByTypeAndlei?type=2&&canshu=wendu"  target="rightFrame">温度</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=2&&canshu=shidu"  target="rightFrame">湿度</a><i></i></li>
                <li><cite></cite><a href="../gettype1_qiti?type=2"  target="rightFrame">气体</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=2&&canshu=pm"  target="rightFrame">PM2.5</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=2&&canshu=fengsu"  target="rightFrame">风速</a><i></i></li>    </ul>
        </dd>

        <dd>
            <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico02.png" /></span>远地面</div>
            <ul class="menuson">
                <li><cite></cite><a href="../getByTypeAndlei?type=3&&canshu=wendu"  target="rightFrame">温度</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=3&&canshu=shidu"  target="rightFrame">湿度</a><i></i></li>
                <li><cite></cite><a href="../gettype1_qiti?type=3"  target="rightFrame">气体</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=3&&canshu=pm"  target="rightFrame">PM2.5</a><i></i></li>
                <li><cite></cite><a href="../getByTypeAndlei?type=3&&canshu=fengsu"  target="rightFrame">风速</a><i></i></li>    </ul>
        </dd>
        <dd>
            <div class="title">
                <span><img src="${pageContext.request.contextPath}/Images/leftico01.png" /></span>空气质量预测
            </div>
            <ul class="menuson">
                <li>
                    <div class="header">
                        <cite></cite>
                        <a href="../getzhexian" target="rightFrame">PM2.5</a>
                        <i></i>
                    </div>
            </ul>
        </dd>


        <dd>
            <div class="title">
                <span><img src="${pageContext.request.contextPath}/Images/leftico02.png" /></span>记录
            </div>
            <ul class="menuson">
                <li>
                    <div class="header">
                        <cite></cite>
                        <a href="../search_data" target="rightFrame">历史纪录查看</a>
                        <i></i>
                    </div>
                </li>

                <%-- <li > <div class="header">
                     <cite></cite>
                     <a href="online_manage/Short_term_alarm.jsp" target="rightFrame">近期报警</a>
                     <i></i>
                     </div>    </li>

                 <li > <div class="header">
                     <cite></cite>
                     <a href="../Repair_register.jsp" target="rightFrame">手动报修</a>
                     <i></i>
                     </div>
                 </li>--%>

            </ul>
        </dd>

    <%--    <dd>
    <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico02.png" />人员管理</span></div>
    <ul class="menuson">
        
        <li>
            <div class="header">
            <cite></cite>
            <a href="../getDataList" target="rightFrame">签到信息</a>
            <i></i>
            </div>
        </li>
        
       &lt;%&ndash; <li>
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
        </li>&ndash;%&gt;
       </ul>    
    </dd>--%>
       <%--
    <dd>
    <div class="title"><span><img src="${pageContext.request.contextPath}/Images/leftico04.png" /></span>联系我们</div>
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
    
    </dd>--%>
    
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
