<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>主页</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <link rel="stylesheet" href="static/css/bootstrap.css">
    <script>
        function checkUsername() {
            if ($("#username").val() !== '') {
                $.post({
                    url: "${pageContext.request.contextPath}/check",
                    data: {
                        'username': $("#username").val(),
                        'password': $("#password").val()
                    },
                    success: function (data, status) {
                        console.log(data);
                        if ('username' in data) {
                            if (data.username !== 'y') {
                                $("#usernameInfo").show();
                            } else {
                                $("#usernameInfo").hide();
                            }
                        }
                        if ('password' in data && $("#password").val() !== '') {
                            if (data.password !== 'y') {
                                $("#passwordInfo").show();
                            } else {
                                $("#passwordInfo").hide();
                            }
                        }
                    },
                    error: function (data) {
                        alert(data);
                    }
                });
            }
            if ($("#password").val() === '') {
                $("#usernameInfo").hide();
                $("#passwordInfo").hide();
            }
        }

    </script>
</head>
<body>
    <div class="container" style="margin: 20px">
        <form class="form-horizontal" style="margin-top: 100px">
            <div class="form-group">
                <label for="username" class="col-sm-2 control-label">用户名：</label>
                <div class="col-sm-10">
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="username" onblur="checkUsername()">
                    </div>
                    <div class="col-sm-2">
                        <button type="button" id="usernameInfo" style="display:none;" class="btn btn-xs btn-danger"
                                disabled="disabled">
                            用户名已存在
                        </button>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label for="password" class="col-sm-2 control-label">密码：</label>
                <div class="col-sm-10">
                    <div class="col-sm-8">
                        <input type="password" class="form-control" id="password" onblur="checkUsername()">
                    </div>
                    <div class="col-sm-2">
                        <button type="button" id="passwordInfo" style="display:none;" class="btn btn-xs btn-danger"
                                disabled="disabled">
                            密码不正确
                        </button>
                    </div>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-8">
                    <button type="submit" class="btn btn-default">提交</button>
                </div>
            </div>
        </form>

        <a class="btn btn-primary col-sm-offset-2" href="user.jsp">查看用户</a>
    </div>

</body>
</html>
