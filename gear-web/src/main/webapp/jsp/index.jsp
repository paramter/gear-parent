<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"+ request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<html>
<head>
    <title>用户登陆</title>
    <meta name="keywords" content="" />
    <meta name="description" content="" />
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="../css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap-theme.min.css" rel="stylesheet" type="text/css">
    <link href="../css/bootstrap-social.css" rel="stylesheet" type="text/css">
    <link href="../css/templatemo_style.css" rel="stylesheet" type="text/css">
</head>
<body class="templatemo-bg-image-1">
<div class="container">
    <div class="col-md-12">
        <form class="form-horizontal templatemo-login-form-2" role="form" action="<%=basePath %>login.do" method="post">
            <div class="row">
                <div class="col-md-12">
                    <h1>用户登陆</h1>
                </div>
            </div>
            <div class="row">
                <div class="templatemo-one-signin col-md-12">
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="userId" class="control-label">登陆用户名</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-user"></i>
                                <input type="text" class="form-control" id="userId" placeholder="用户名">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <label for="password" class="control-label">登陆密码</label>
                            <div class="templatemo-input-icon-container">
                                <i class="fa fa-lock"></i>
                                <input type="password" class="form-control" id="password" placeholder="登陆密码">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <div class="checkbox">
                                <label>
                                    <input type="checkbox" value="true"> 记住我
                                </label>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="form-group">
                            <div class="col-sm-6">
                                <input type="submit" value="登  陆" class="btn btn-warning">
                            </div>
                            <div class="col-sm-6">
                                <input type="submit" value="注  册" class="btn btn-warning">
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-md-12">
                            <a href="forgot-password.html" class="text-center">忘记密码?</a>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>
