<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/8/13
  Time: 15:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="blogEditForm" class="blogForm" method="post">
        <input type="hidden" name="id"/>
        <input type="hidden" name="createTime" />
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
        blogAddEditor = Blog.createEditor("#blogEditForm [name=desc]");
        //初始化类目选择和图片上传器
        Blog.init({fun:function(node){

        }});

        var param={"id":getSelectionsIds()};

        //显示博客内容
        $.post("/blog/read",param,function(data){
            if(data.status == 200) {
                blogAddEditor.html(data.data.blogDesc);
            }
            var date=parseInt($('input[name=createTime]').val());//日期格式化
            $('input[name=createTime]').val(new Date(date).format("yyyy-MM-dd hh:mm:ss"));
        });


    });


    //提交表单
    function submitForm(){
        //有效性验证
        if(!$('#blogEditForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        //同步文本框中的博客正文
        blogAddEditor.sync();


        //ajax的post方式提交表单
        //$("#blogAddForm").serialize()将表单序列号为key-value形式的字符串
        $.post("/blog/edit",$("#blogEditForm").serialize(), function(data){
            if(data.status == 200){
                $.messager.alert('提示','编辑成功!');
            }
        });
    }

    //重置
    function clearForm(){

        $('#blogEditForm').form('reset');
        blogAddEditor.html('');
    }
</script>
