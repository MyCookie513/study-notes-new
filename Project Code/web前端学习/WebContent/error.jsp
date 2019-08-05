<%@page contentType="text/html" pageEncoding="GB18030"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=GB18030">
        <title>错误提示</title>
    </head>
    <body>
                         <!--  从请求中得到错误信息，然后在页面中显示； -->
        <h1>${error}</h1>
                         <!--    点及返回按钮，退回一步 -->
		<input name="btn_return" type="button" value="返回" onClick="history.back(-1);">
    </body>
</html>
