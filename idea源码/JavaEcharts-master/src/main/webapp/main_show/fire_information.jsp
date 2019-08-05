
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" contentType="text/html; charset=utf-8"%>
<%
 String path = request.getContextPath();
/*String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
ArrayList<AchInformationEntity> AIList = (ArrayList<AchInformationEntity>)request.getAttribute("AIList");
 */%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <!-- 此标签 为页面上规定的默认的地址或者目标 -->
    <base href="<%="相关的信息输出"%>">
    
    <title>壁炉信息查询</title>
    

<%--   <link rel="stylesheet" type="text/css" href="<%=path %>/framejsp/css/amazeui.min.css">
 --%>  <script>"undefined"==typeof CODE_LIVE&&(!function(e){var t={nonSecure:"53812",secure:"53815"},c={nonSecure:"http://",secure:"https://"},r={nonSecure:"127.0.0.1",secure:"gapdebug.local.genuitec.com"},n="https:"===window.location.protocol?"secure":"nonSecure";script=e.createElement("script"),script.type="text/javascript",script.async=!0,script.src=c[n]+r[n]+":"+t[n]+"/codelive-assets/bundle.js",e.getElementsByTagName("head")[0].appendChild(script)}(document),CODE_LIVE=!0);</script></head>
  
  <body data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-37" data-genuitec-path="/ArtFire/WebRoot/framejsp/online_manage/Realstatus_list.jsp">
    <h1 data-genuitec-lp-enabled="false" data-genuitec-file-id="wc1-37" data-genuitec-path="/ArtFire/WebRoot/framejsp/online_manage/Realstatus_list.jsp">壁炉设备信息列表</h1>
    <div>
    	<table class="am-table am-table-striped am-table-hover">
    		<tr>
    			<th>序号</th>
    			<th>设备ID</th>
    			<th>持有人</th>
    			<th>安装时间</th>
    			<th>设备类型</th>
    			<th>是否带触摸屏</th>
    			<th>设备状态</th>
    			<th>操作</th>
    		</tr>
    		
    		
    		
    		<!-- 下面是迭代输出一个壁炉的信息以及其使用者的信息 -->
    		<%-- <%
    			if(AIList != null){
    			  int  i = 0;
    				for(i=0;i<1/*AIList.size()*/;i++){%>
    		<tr>
    			<td><%=i+1 %></td>
    			<td><%=AIList.get(i).getAch_ID() %></td>
    			<td><%=AIList.get(i).getAch_user() %></td>
    			<td><%=AIList.get(i).getInstall_time() %></td>
    			<td><%=AIList.get(i).getType() %></td>
    			<td><%=AIList.get(i).getTouch_screen() %></td>
    			<td><%=AIList.get(i).getStatus().equals("0")?"离线":"在线" %></td> 
    			<td><a href="<%=path %>/GetRealstatus.do?id=<%=AIList.get(i).getAch_ID() %>&user=<%=AIList.get(i).getAch_user() %>&type=<%=AIList.get(i).getType() %>&touch=<%=AIList.get(i).getTouch_screen() %>" target="rightFrame"><button type="button" class="am-btn am-btn-primary am-radius" <%if(AIList.get(i).getStatus().equals("0")) out.print("disabled='disabled'"); %>>查看实时状态</button></a></td> 
    			<td><a href="<%=path %>/framejsp/online_manage/Realstatus.jsp" target="rightFrame"><button type="button" class="am-btn am-btn-primary am-radius" >查看实时状态</button></a></td>
    		</tr>
    				<%}
    			}
    		 %> --%>
    		 
    		 
    		 
    		 
    		 <tr>
    			<td>1</td>
    			<td>001</td>
    			<td>张三</td>
    			<td>2017.09.08</td>
    			<td>A</td>
    			<td>是</td>
    			<td>在线</td>
    			<td><a href="<%=path %>/framejsp/online_manage/Realstatus.jsp" target="rightFrame"><button type="button" class="am-btn am-btn-primary am-radius">查看实时状态</button></a></td>
    		</tr>
    		<tr>
    			<td>2</td>
    			<td>002</td>
    			<td>李四</td>
    			<td>2017.09.08</td>
    			<td>A</td>
    			<td>是</td>
    			<td>离线</td>
    			<td><a href="<%=path %>/framejsp/online_manage/Realstatus.jsp" target="rightFrame"><button type="button" class="am-btn am-btn-primary am-radius" disabled="disabled">查看实时状态</button></a></td>
    		</tr>  
		</table>
    </div>
  </body>
</html>
