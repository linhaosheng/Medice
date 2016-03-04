<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html class="no-js">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>药品存销信息管理系统</title>
    <meta name="description" content="这是一个 index 页面">
    <meta name="keywords" content="index">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    <meta name="renderer" content="webkit">
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="../i/favicon.png">
    <link rel="apple-touch-icon-precomposed" href="../i/app-icon72x72@2x.png">
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.4.2/css/amazeui.css"/>
    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.4.2/css/amazeui.min.css"/>
<!--    <link rel="stylesheet" href="http://cdn.amazeui.org/amazeui/2.4.2/css/admin.css"/>-->
    <link rel="stylesheet" href="../css/admin.css">
<!--    <link rel="stylesheet" href="../css/amazeui.min.css">-->
</head>
<body>
<!--[if lte IE 9]>
<p class="browsehappy">你正在使用<strong>过时</strong>的浏览器，Amaze UI 暂不支持。 请 <a href="http://browsehappy.com/" target="_blank">升级浏览器</a>
    以获得更好的体验！</p>
<![endif]-->

<header class="am-topbar admin-header">
    <div class="am-topbar-brand">
        <strong>药品存销信息</strong>
        <small>后台管理系统</small>
    </div>

    <button class="am-topbar-btn am-topbar-toggle am-btn am-btn-sm am-btn-success am-show-sm-only"
            data-am-collapse="{target: '#topbar-collapse'}"><span class="am-sr-only">导航切换</span> <span
            class="am-icon-bars"></span></button>

    <div class="am-collapse am-topbar-collapse" id="topbar-collapse">

        <ul class="am-nav am-nav-pills am-topbar-nav am-topbar-right admin-header-list">
            <li><a href="javascript:;"><span class="am-icon-envelope-o"></span> 收件箱 <span
                        class="am-badge am-badge-warning">5</span></a></li>
            <li class="am-dropdown" data-am-dropdown>
                <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
                    <span class="am-icon-users"></span> 药品管理员 <span class="am-icon-caret-down"></span>
                </a>
                <ul class="am-dropdown-content">
                    <li><a href="#"><span class="am-icon-user"></span> 资料</a></li>
                    <li><a href="#"><span class="am-icon-cog"></span> 设置</a></li>
                    <li><a href="#"><span class="am-icon-power-off"></span> 退出</a></li>
                </ul>
            </li>
            <li class="am-hide-sm-only"><a href="javascript:;" id="admin-fullscreen"><span
                        class="am-icon-arrows-alt"></span> <span class="admin-fullText">开启全屏</span></a></li>
        </ul>
    </div>
</header>


    <div class="admin-sidebar am-offcanvas" id="admin-offcanvas">
        <div class="am-offcanvas-bar admin-offcanvas-bar">
            <ul class="am-list admin-sidebar-list">
                <li><a href="index.jsp"><span class="am-icon-home"></span> 首页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav'}"><span class="am-icon-file"></span>
                        药品信息管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav">
                        <li><a href="addGoods.jsp" class="am-cf"><span class="am-icon-file"></span>增加药品</a></li>

                        <li><a href="getGoodsInfo.jsp"><span class="am-icon-file"></span>查询药品</a></li>

                    </ul>
                </li>
                <li><a href="checkGoods.jsp"><span class="am-icon-table"></span>库存信息查询</a></li>

                <li><a href="#"><span class="am-icon-sign-out"></span> 注销</a></li>
            </ul>

            <div class="am-panel am-panel-default admin-sidebar-panel">
                <div class="am-panel-bd">
                    <p><span class="am-icon-bookmark"></span> 公告</p>

                    <p>时光静好，与君语；细水流年，与君同。—— Amaze UI</p>
                </div>
            </div>

            <div class="am-panel am-panel-default admin-sidebar-panel">
                <div class="am-panel-bd">
                    <p><span class="am-icon-tag"></span> wiki</p>

                    <p>Welcome to the Amaze UI wiki!</p>
                </div>
            </div>
        </div>
    </div>
    <!-- sidebar end -->

    <!-- content start -->
   <form method="post" action="../getGoodsInfo.action">
     <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">查询药品</strong></div>
            <div class="am-u-sm-12 am-u-md-3 am-fl" >
                <div class="am-input-group am-input-group-sm">
                    <input type="text" class="am-form-field" name="goodsId" id="goodsId">
                    <span class="am-input-group-btn">
                    <button class="am-btn am-btn-default" type="submit" id="search">搜索</button>
                    </span>
                </div>
            </div>
        </div>
    </div>

</form>

<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>

<s:if test="#session.goodsInfo !=null">
<label id="1">物品条码:&nbsp;&nbsp;<s:property value="#session.goodsInfo.goodsId"/></label><br>
<label id="2">货物名称:&nbsp;&nbsp;<s:property value="#session.goodsInfo.goodsName"/></label><br>
<label id="3">库存单位:&nbsp;&nbsp;<s:property value="#session.goodsInfo.unit"/></label><br>
<label id="4">包装规格:&nbsp;&nbsp;<s:property value="#session.goodsInfo.spec"/></label><br>
<label id="5">来源:&nbsp;&nbsp;<s:property value="#session.goodsInfo.source"/></label><br>
<label id="6">联系人:&nbsp;&nbsp;<s:property value="#session.goodsInfo.contact"/></label><br>
<label id="7">联系电话:&nbsp;&nbsp;<s:property value="#session.goodsInfo.tel"/></label><br>
<label id="8">药品数量:&nbsp;&nbsp;<s:property value="#session.goodsInfo.stock_number"/></label><br>
</s:if>

<s:set name="goodsInfo" value="null" scope="session"/>



<footer>
    <hr>
    <p class="am-padding-left">© 2015 Power By DH.Studio.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../js/jquery.min.js"></script>
<!--<![endif]-->
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>

  <!--<script src="../js/getGoodsInfo.js"/>   -->


</body>
</html>
