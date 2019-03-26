<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/25
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript">

    $(function(){
        $("#editPasswordBtn").click(function(){
            var obj=$("#passwordEditForm").serializeJson();//表单序列化
            obj.nickname="${username}";
            bl.ajax("/user/editpassword",obj,function(data){
               if(data.status==400){
                   $.messager.alert('提示','两次密码不一致');
               }
               else{
                   $.messager.alert('提示','修改成功');
               }
            });
        })
    })

/*
    $(function(){

        $('#editPasswordBtn').click(function () {
        var obj=new Object();
        obj=$("#passwordEditForm").serializeArray();
        alert(obj[0]);
        });
    });*/
</script>

<form style="margin:150px auto;width:300px;text-align: center" id="passwordEditForm" class="blogForm" method="post">
    <table>
        <tr>
            <td>密码:</td>
            <td><input class="easyui-textbox" type="password" name="password"/></td>
        </tr>
        <tr>
            <td>确认密码:</td>
            <td><input class="easyui-textbox" type="password" name="repassword"/></td>
        </tr>
    </table>
    <a id="editPasswordBtn" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-edit'">提交</a>
</form>

