<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>标题</title>
    <script>
        function check(form) {
            console.log(form)
            if (form.file.value === null) {
                alert("请添加文件");
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
    <h2>
        <a href="${pageContext.request.contextPath}/user/toLogin">登录</a>
    </h2>
    <h2>
        <a href="${pageContext.request.contextPath}/user/main">主页</a>
    </h2>
    <form action="${pageContext.request.contextPath}/upload" enctype="multipart/form-data" method="post"
          onsubmit="return check(this)">
        <input type="file" name="file">
        <input type="submit" value="上传">
    </form>
</body>
</html>
