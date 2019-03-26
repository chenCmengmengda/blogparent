<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2019/3/4
  Time: 10:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<link href="/js/kindeditor-4.1.10/themes/default/default.css" type="text/css" rel="stylesheet">
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/kindeditor-all-min.js"></script>
<script type="text/javascript" charset="utf-8" src="/js/kindeditor-4.1.10/lang/zh_CN.js"></script>
<div style="padding:10px 10px 10px 10px">
    <form id="photoAddForm" class="blogForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>相册标题:</td>
                <td><input class="easyui-textbox" type="text" name="photoTitle" data-options="required:true" style="width: 280px;"/></td>
            </tr>
            <tr>
                <td>相册说说:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="photoExplain" data-options="required:true" style="width: 280px;" />
                </td>
            </tr>
            <tr>
                <td>相册图片:</td>
                <td>
                    <a href="javascript:void(0)" class="easyui-linkbutton onePicUpload">上传图片</a>
                    <input type="hidden" name="photoImages"/>
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
    var photoAddEditor ;
    //页面初始化完毕后执行此方法
    $(function(){

        //初始化类目选择和图片上传器
        Blog.init({fun:function(node){

            }});
    });

    function submitForm(){
        if(!$('#photoAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
    //    alert($('#photoAddForm').serialize());

        $('#photoAddForm').form('submit',{
            url:'/photo/add',

            success:function(data){
                var data = eval('(' + data + ')');//转化为json对象
                if(data.status==200){
                    $.messager.alert('消息','添加成功');

                    return;
                }
                $.messager.alert('消息','添加失败');
            }
        });
    }

    //重置
    function clearForm(){
        $('#photoAddForm').form('reset');
        photoAddEditor.html('');
    }

</script>