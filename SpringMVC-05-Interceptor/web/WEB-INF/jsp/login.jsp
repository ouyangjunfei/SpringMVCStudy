<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆页面</title>
    <link rel="stylesheet" href="../../static/css/bootstrap.css">
</head>
<body>
    <div class="container" style="margin: 20px">
        <form class="form-horizontal" action="${pageContext.request.contextPath}/user/login" method="post"
              style="margin-top: 100px">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名：</label>
                <div class="col-sm-10">
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" name="username">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码：</label>
                <div class="col-sm-10">
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" name="password">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>

    </div>
</body>
</html>
