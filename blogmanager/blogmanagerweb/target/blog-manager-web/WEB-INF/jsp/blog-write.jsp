<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/25
  Time: 22:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="blogAddForm" class="blogForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>文章标题:</td>
                <td><input class="easyui-textbox" type="text" name="title" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>博客正文:</td>
                <td>
                    <textarea style="width:800px;height:300px;visibility:hidden;" name="desc"></textarea>
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">重置</a>
    </div>
</div>
<script type="text/javascript">
    var blogAddEditor ;
    //页面初始化完毕后执行此方法
    $(function(){
        //创建富文本编辑器
        blogAddEditor = Blog.createEditor("#blogAddForm [name=desc]");
        //初始化类目选择和图片上传器
        Blog.init({fun:function(node){

        }});
    });

    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#blogAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        //同步文本框中的博客正文
        blogAddEditor.sync();


        //ajax的post方式提交表单
        //$("#blogAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/blog/add",$("#blogAddForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','写博客成功!');
            }
        });
    }

    //重置
    function clearForm(){
        $('#itemAddForm').form('reset');
        itemAddEditor.html('');
    }
</script>
