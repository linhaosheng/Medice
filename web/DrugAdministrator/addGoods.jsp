
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    <link rel="stylesheet" href="../css/admin.css">
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

<div class="am-cf admin-main">
    <!-- sidebar start -->
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
    <div class="admin-content">

        <div class="am-cf am-padding">
            <div class="am-fl am-cf"><strong class="am-text-primary am-text-lg">增加药品</strong></div>
        </div>
        <br><br>


        <form class="am-form am-form-horizontal am-u-sm-12 am-u-md-10 am-u-lg-7" id="addGoods-form" method="post"
              action="../addGoods.action">
            <div class="am-form-group">
                <label for="goodsid" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label" style="text-align: left">条码
                </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="username" placeholder="" name="goodsId">
                </div>
            </div>
            <div class="am-form-group">
                <label for="goodsName" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 药品名称</label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="goodsName" placeholder="" name="goodsName">
                </div>
            </div>
            <div class="am-form-group">
                <label for="unit" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 库存单位 </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="unit" placeholder="" name="unit">
                </div>
            </div>
            <div class="am-form-group">
                <label for="spec" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 包装规格 </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="spec" placeholder="" name="spec">
                </div>
            </div>
            <div class="am-form-group">
                <label for="source" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 来源 </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="source" placeholder="" name="source">
                </div>
            </div>
            <div class="am-form-group">
                <label for="contact" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 联系人 </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="contact" placeholder="" name="contact">
                </div>
            </div>
            <div class="am-form-group">
                <label for="tel" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 联系电话 </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="tel" placeholder="" name="tel">
                </div>
            </div>
            <div class="am-form-group">
                <label for="alertValue" class="am-u-sm-4 am-u-md-4 am-u-lg-3 am-form-label"style="text-align: left"> 库存警戒值 </label>
                <div class="am-u-sm-8 am-u-md-8 am-u-lg-9">
                    <input type="text" id="alertValue" placeholder="" name="alertValue">
                </div>
            </div>

            <button class="am-btn am-btn-primary" id="btn-submit" type="submit"
                    style="position:absolute;right:25px;">提  交</button>
            <br><br>
        </form>


    </div>
    <!-- content end -->
</div>

<a href="#" class="am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}">
    <span class="am-icon-btn am-icon-th-list"></span>
</a>

<footer>
    <hr>
    <p class="am-padding-left">© 2015 Power By DH.Studio.</p>
</footer>

<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.1/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

<!--[if (gte IE 9)|!(IE)]><!-->
<script src="../js/jquery.min.js"></script>
<!--<![endif]-->
<script src="../js/amazeui.min.js"></script>
<script src="../js/app.js"></script>

   <!--<script src="../js/addGoods.js"></script>  -->

 <s:if test="#session.status==100">
     <script language="JavaScript">
         alert("添加成功");
     </script>

 </s:if>
<s:elseif test="#session.status==-200">
    <script language="JavaScript">
        alert("添加失败");
    </script>
</s:elseif>
<s:elseif test="#session.status==-100">
    <script language="JavaScript">
        alert("内部错误");
    </script>
</s:elseif>
<s:set name="status" value="0" scope="session"/>
                <!---<s:property value="#session.status"/>  从session里去数据  -->

</body>
</html>
