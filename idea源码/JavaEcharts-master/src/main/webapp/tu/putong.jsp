<%--
  Created by IntelliJ IDEA.
  User: Elric
  Date: 2017/7/7
  Time: 14:48
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/echarts.common.min.js"></script>
    <!-- 引入jquery.js -->
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.min.js"></script>
</head>

<body>


<center>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 600px;height:500px; text-align: center;"></div>

<script type="text/javascript">

    var myChart = echarts.init(document.getElementById('main'));
    // 显示标题，图例和空的坐标轴
    myChart.setOption( {
        title : {
            text: '数据表的主题',
            subtext: '数据监控'
        },
        tooltip : {
            trigger: 'axis'
        },
        legend: {
            data:['湿度变化','温度变化']
        },
        toolbox: {
            show : true,
            feature : {
                mark : {show: true},
                dataView : {show: true, readOnly: false},
                magicType : {show: true, type: ['line', 'bar']},
                restore : {show: true},
                saveAsImage : {show: true}
            }
        },
        calculable : true,
        xAxis : [
            {
                type : 'category',
                boundaryGap : false,
                data : ['标志一','标志二','三','四','五','六','日']
            }
        ],
        yAxis : [
            {
                type : 'value',
                axisLabel : {
                    formatter: '{value} '
                }
            }
        ],
        series : [
            {
                name:'CO2',
                type:'line',
                data:[11, 11, 15, 13, 12, 13, 10],
                markPoint : {
                    data : [
                        {type : 'max', name: '最大值'},
                        {type : 'min', name: '最小值'}
                    ]
                },
                markLine : {
                    data : [
                        {type : 'average', name: '平均值'}
                    ]
                }
            }
        ]
    }
    );

    myChart.showLoading();    //数据加载完之前先显示一段简单的loading动画

    var value0='<%= session.getAttribute("leibie")%>';
    var type='<%= session.getAttribute("type")%>';
    /*if(value0=='wendu')
        alert('wendu')*/


    var isLoaded = false;
    function req(myChart,value0,type){
        var names = [];    //类别数组（实际用来盛放X轴坐标值）
        var numsso2 = [];    //销量数组（实际用来盛放Y坐标值）
        var numsno2 = [];
        var numso3 = [];


        $.ajax({
            type: "post",
            async: true,            //异步请求（同步请求将会锁住浏览器，用户其他操作必须等待请求完成才可以执行）
            url: "${pageContext.request.contextPath}/gettype1_data?type="+type,    //请求发送到TestServlet处
            data: {},
            dataType: "json",        //返回数据形式为json
            success: function (result) {

                //请求成功时执行该函数内容，result即为服务器返回的json对象
                if (result) {

                    for (var i = 0; i < result.length; i++) {
                        var obj=result[i];
                        numsso2.push(obj[value0]);

                    }
                    for (var i = 0; i < result.length; i++) {
                        names.push(result[i].time);    //挨个取出销量并填入销量数组
                    }
                    myChart.hideLoading();    //隐藏加载动画
                    myChart.setOption({        //加载数据图表
                        xAxis: {
                            type : 'category',
                            boundaryGap : false,
                            data : names
                        },
                        series: [{
                            name:value0,
                            type:'line',
                            data:numsso2

                        }
                        ]
                    });

                }

            },
            error: function (errorMsg) {
                //请求失败时执行该函数
                alert("图表请求数据失败!");
                myChart.hideLoading();
            }
        })
    }
    req(myChart,value0,type);
    setInterval(req, 3000,myChart,value0,type);


</script></center>
</body>
</html>