<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Insert title here</title>
    <link href="${pageContext.request.contextPath}/static/css/application.css" rel="stylesheet">
</head>
<body>
<form action="${pageContext.request.contextPath }/goods/add" method="post">
    <table width="100%" border="1" cellpadding="0" cellspacing="1" class="tableLine">
        <tr>
            <td colspan=4 align=center class="tableLineBg">商品新增</td>
        </tr>

        <tr>
            <td>商品名称</td>
            <td><input type="text" name="name"></td>
            <td>图片位置</td>
            <td><input type="text" name="imgPath"></td>
        </tr>
        <tr>
            <td>商品描述</td>
            <td><input type="text" name="description"></td>
        </tr>


        <tr>
            <td colspan=4 align=center><input type="submit" value="新增"></td>
        </tr>
    </table>
</form>
</body>
</html>