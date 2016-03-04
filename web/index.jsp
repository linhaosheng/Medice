<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>药品存销信息管理系统</title>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="format-detection" content="telephone=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp" />
    <!--    <link rel="alternate icon" type="image/png" href="assets/i/favicon.png">-->
    <link rel="stylesheet" href="css/amazeui.min.css"/>
    <style>
        .header {
            text-align: center;
        }
        .header h1 {
            font-size: 200%;
            color: #333;
            margin-top: 30px;
        }
        .header p {
            font-size: 14px;
        }
    </style>
</head>
<body>
<div class="header">
    <div class="am-g">
        <br>
        <br>
        <h1>药品存销信息管理系统</h1>
    </div>
    <hr />
</div>
<div class="am-g">
    <div class="am-u-lg-3 am-u-md-8 am-u-sm-centered">
        <br>
        <br>

        <form method="post" class="am-form" id="login-frm" action="login.action">
            <label for="username">用户名:</label>
            <input type="text" name="uid" id="username" value="">
            <br>
            <label for="password">密码:</label>
            <input type="password" name="password" id="password" value="">
            <br>
            <br/>
            <div class="am-cf">
                <input type="submit" name=" " id="btn-login" value="登 录" class="am-btn am-btn-primary am-btn-sm am-fr"/>
            </div>
        </form>
        <hr>
        <p>© 2015 Power By DH.Studio.</p>
    </div>
</div>
<script src="js/jquery.min.js"></script>
<!--<![endif]-->
    <!--<script src="/js/login.js"></script>    -->
</body>
</html>