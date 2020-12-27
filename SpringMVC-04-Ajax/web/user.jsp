<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户表</title>
    <script src="${pageContext.request.contextPath}/static/js/jquery.js"></script>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/bootstrap.css">
    <script>
        function getUser() {
            $.post({
                url: "${pageContext.request.contextPath}/get/user",
                success: function (data) {
                    let html = "";
                    for (let i = 0; i < data.length; i++) {
                        html += "<tr>" +
                            "<td>" + data[i].name + "</td>" +
                            "<td>" + data[i].age + "</td>" +
                            "<td>" + data[i].sex + "</td>" +
                            "</tr>"
                    }
                    $("#userContent").html(html);
                }
            })
        }


    </script>
</head>


<body>
    <div class="container">

        <div class="row" style="margin: 15px">
            <div class="col-md-4">
                <button type="button" class="btn btn-primary" id="btn" onclick="getUser()">加载数据</button>
            </div>
        </div>


        <div class="row">
            <div class="col-md-12">
                <table class="table table-bordered table-striped table-hover">
                    <thead>
                    <tr>
                        <th>姓名</th>
                        <th>年龄</th>
                        <th>性别</th>
                    </tr>
                    </thead>
                    <tbody id="userContent">
                    </tbody>
                </table>
            </div>
        </div>
    </div>


</body>
</html>
