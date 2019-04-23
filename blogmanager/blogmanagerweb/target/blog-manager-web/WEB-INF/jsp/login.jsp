<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/8/16
  Time: 15:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <meta charset="UTF-8"/>
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
    <link rel="stylesheet" type="text/css" href="/js/jquery-easyui-1.4.1/themes/icon.css" />
    <link rel="stylesheet" type="text/css" href="/css/main.css"></head>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
</head>
<script type="text/javascript">
    function submitForm(){
        if(!$('#userAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $('#frmLogin').form('submit',{
            url:"/user/login.do",
            success:function(data){
            /*    var data = eval('(' + data + ')');
            //    alert(data.msg);
                if(data.status ==400){
                    $.message.alert("提示","用户名或密码错误");
                    return;
                }

                window.location.href=data.msg;*/
                window.location.href="/";
            }

        });
    }
    function clearForm(){
        $('#frmLogin').form('clear');
    }
    function register(){
        $('#frmRegister').form('submit');
    }
    function clearRegister(){
        $('#frmRegister').form('clear');
    }
    //按回车键执行登录
    function enterLogin(event) {
        var e = event || window.event || arguments.callee.caller.arguments[0];
        if (e && e.keyCode == 13) {
            $('#frmLogin').form('submit');
        }
    }
</script>
<body>
<div class="easyui-window" title="登录" maximizable="false" minimizable="false" style="width:100%;max-width: 400px;padding: 30px 60px;">
    <form id="frmLogin" method="post" >
        <table cellpadding="5" style="margin:auto">
            <tr>
                <td>用户名：</td>
                <td><input class="easyui-textbox" name="username" style="width:100%" maxlength="20" data-options="label:'用户名',required:true"></td>
            </tr>
            <tr>
                <td>密码：</td>
                <td><input class="easyui-textbox" name="password" type="password" style="width:100%" data-options="label:'密   码:',required:true"></td>
            <tr>
        </table>
        <div style="text-align:center;padding:5px 0">
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-ok'" onclick="submitForm()" style="width:80px">登录</a>
            <a href="javascript:void(0)" class="easyui-linkbutton" data-options="iconCls:'icon-reload'" onclick="clearForm()" style="width:80px">重置</a>
        </div>
    </form>
</div>
</body>
</html>
