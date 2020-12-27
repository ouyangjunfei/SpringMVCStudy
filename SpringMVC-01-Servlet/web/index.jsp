<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>我的标题</title>
</head>
<body>
    <form action="${pageContext.request.contextPath}/hello" method="post">
        <label for="method">方法 :</label><input type="text" id="method" name="method">
        <input type="submit">
    </form>
</body>
</html>
