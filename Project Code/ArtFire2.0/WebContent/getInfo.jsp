<%@page import="com.cn.hibernate_javabean.Ach_users"%>
<%@page import="com.cn.hibernate_javabean.Ach_wifi_data_01"%>
<%@page import="net.sf.json.JSONObject"%>
<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.cn.hibernate_Init.HibernateInitialize"%>
<%@page import="java.util.Map"%>
<%@page import="com.opensymphony.xwork2.ActionContext"%>
<%@ page language="java" contentType="text/html; charset=GB18030"
    pageEncoding="GB18030"%>


 <%
 //Map容器内部放置数据；json对象放置map容器对象；最后将从response对像中获取的printwriter对象进行write操作；
 
 JSONObject jsonObject = new JSONObject();
 jsonObject.put("id", request.getAttribute("id") );
 jsonObject.put("name", request.getAttribute("name") );
 jsonObject.put("type", request.getAttribute("type") );
 jsonObject.put("touch_screen", request.getAttribute("touch_screen") );
 jsonObject.put("jiujingyewei", request.getAttribute("jiujingyewei") );
 jsonObject.put("jibanwendu", request.getAttribute("jibanwendu") );
 jsonObject.put("fire_tem", request.getAttribute("fire_tem") );
 jsonObject.put("first_level", request.getAttribute("first_level") );
 jsonObject.put("second_level", request.getAttribute("second_level") );
 jsonObject.put("anzhuang_time", request.getAttribute("anzhuang_time") );
 jsonObject.put("addtime", request.getAttribute("addtime") );
 jsonObject.put("system_state", request.getAttribute("system_state") );
out.print(jsonObject.toString());

%>

