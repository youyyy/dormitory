<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="../static/css/bootstrap.min.css"/>
    <link rel="stylesheet" href="../static/css/bootstrap-theme.min.css"/>
    <script type="text/javascript" src="../static/js/jquery-3.3.1.min.js"></script>
    <script type="text/javascript" src="../static/js/bootstrap.min.js"></script>
</head>
<body>
<form role="form">
    <h1>登陆界面</h1>
    <div class="form-group">
        <label for="name" text-align="center">名称</label>
        <input type="text" class="form-control" id="name" placeholder="请输入名称">
    </div>
    <div class="form-group">
        <label for="pw" text-align="center">名称</label>
        <input type="password" class="form-control" id="pw" placeholder="请输入密码">
    </div>
    <button type="button" id="login" class="btn btn-default">提交</button>
</form>
<script type="text/javascript" src="../static/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
    $("#login").click(function () {
        if($("#name").val() == "root" && $("#pw").val() == "root"){
            window.location.href = "/";
        }else {
            alert("登陆失败");
        }
    })
</script>
</body>
</html>
