<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/25
  Time: 19:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>陈C个人博客后台管理系统</title>
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="css/main.css"></head>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript" src="js/common.js"></script>

    <script type="text/javascript">
        $(function(){

        })

        /**
         * 打开选项卡
         * @param text  选项卡标题
         * @param url   请求打开路径
         * @param icon  选项卡图标
         */
        function openTab(text,url,icon) {
            //判断当前选项卡是否存在
            if($('#tabs').tabs('exists',text)){
                //如果存在 显示
                $("#tabs").tabs("select",text);
            }else{
                //如果不存在 则新建一个
                $("#tabs").tabs('add',{
                    title:text,
                    closable:true,      //是否允许选项卡摺叠。
                    iconCls:icon,    //显示图标
                //    content:"<iframe frameborder=0 scrolling='auto' style='width:100%;height:100%' src='${blog}/admin/"+url+"'></iframe>"
                    //url 远程加载所打开的url
                    href:url,
                    bodyCls:"content"
                })
            }
        }
    </script>

</head>
<body class="easyui-layout">
    <div class="head" data-options="region:'north',split:false">
        <div class="head-content">
            <h1 style="float:left;width:50%">陈C个人博客的后台管理系统</h1>
            <div class="head-right">
                <ul>
                    <li><a href="#">欢迎:${username}</a></li>
                    <li><a href="/page/login" >退出登陆</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div data-options="region:'west',title:'菜单',border:false" style="width:180px;">
        <div id="menu" class="easyui-accordion" data-options="fit:false,border:false">
            <div title="博客管理" data-options="iconCls:'icon-item'" style="padding: 10px">
                <a href="javascript:openTab('写博客','blog-write','icon-write')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-writeblog' " style="width: 150px">写博客</a>
                <a href="javascript:openTab('用户信息','user-info','icon-man')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-man'" style="width: 150px">用户信息</a>
                <a href="javascript:openTab('已发博客','blog-list','icon-text')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-review'" style="width: 150px">已发博客</a>
                <a href="javascript:openTab('博客详细','blog-desc','icon-write')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-review'" style="width: 150px">博客详情</a>
                <a href="javascript:openTab('用户评论','user-comment','icon-write')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-review'" style="width: 150px">用户评论</a>
                <a href="javascript:openTab('评论回复','reply','icon-write')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-review'" style="width: 150px">评论回复</a>
            </div>
            <div title="系统管理" data-options="selected:true,iconCls:'icon-system'" style="padding:10px">
                <a href="/" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">系统首页</a>
                <a href="javascript:openTab('修改密码','edit-password','icon-write')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-modifyPassword'" style="width: 150px;">修改密码</a>
                <a href="javascript:openTab('帮助','help','icon-write')" class="easyui-linkbutton"
                   data-options="plain:true,iconCls:'icon-help'" style="width: 150px;">帮助</a>
            </div>
        </div>

    </div>
    <div data-options="region:'center',title:''">
        <div id="tabs" class="easyui-tabs" fit="true" border="false" id="tabs" >
            <div title="博客首页" style="padding: 20px">
                <div align="center" style="padding-top: 100px">
                    <font color="red" size="10">欢迎使用</font>
                </div>

            </div>
        </div>
    </div>
    <div region="south" style="height: 25px;padding: 5px" align="center">
    Copyright © 2018-2025 陈C的SSM博客系统 版权所有
    </div>

</body>
</html>
