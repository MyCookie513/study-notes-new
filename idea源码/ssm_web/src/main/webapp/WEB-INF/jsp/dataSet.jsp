<%--
  Created by IntelliJ IDEA.
  User: Jack.xue
  Date: 2019/6/2
  Time: 14:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<style type="text/css">
    .img{
        width:800px;
        height:600px;
        border: 0;
        color: gray;
    }
</style>
<div  style="text-align:center">
    柱状图 <br><br>
    点击生成柱状图<a href="<%=request.getContextPath()%>data/getColumnChart.do">getMajorChart</a>
    <br><br>
    <img src="${chartColumnURL}" >
</div>
<div  style="text-align:center">
    饼状图 <br><br>
    点击生成饼状图<a href="data/getFoldLine">getMajorChart</a>
    <br><br>
    <img src="${chartPieURL}" >
</div>
<div  style="text-align:center">
    折线图 <br><br>
    点击生成折线图<a href="data/getLineChart">getMajorChart</a>
    <br><br>
    <img src="${chartLineURL}" >
</div>

</body>
</html>
