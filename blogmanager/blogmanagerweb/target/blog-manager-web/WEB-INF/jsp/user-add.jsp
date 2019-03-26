<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/29
  Time: 20:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div style="padding:10px 10px 10px 10px">
    <form id="userAddForm" class="userForm" method="post">
        <table cellpadding="5">
            <tr>
                <td>用户昵称:</td>
                <td><input class="easyui-textbox" type="text" name="nickname" data-options="required:true" style="width: 280px;"></input></td>
            </tr>
            <tr>
                <td>用户密码:</td>
                <td><input class="easyui-textbox" type="password" name="password" data-options="validType:'length[6,20]'" style="height:100%;width: 280px;"></input></td>
            </tr>
            <tr>
                <td>性别:</td>
                <td><select class="easyui-combobox" name="sex" data-options="required:true,editable:false,panelHeight:'auto'" style="width:200px;height:100%;">
                    <option value="男">男</option>
                    <option>女</option>
                </select>
                </td>
            </tr>
            <tr>
                <td>生日:</td>
                <td><input class="easyui-datebox" type="text" name="birthday" data-options="precision:0,required:true" /></td>
            </tr>
            <tr>
                <td>邮箱:</td>
                <td>
                    <input class="easyui-textbox" type="email" name="email" data-options="validType:'email'" />
                </td>
            </tr>
            <tr>
                <td>联系电话:</td>
                <td>
                    <input class="easyui-textbox" type="text" name="phone" data-options="validType:'length[1,30]'" />
                </td>
            </tr>
        </table>
    </form>
    <div style="padding:5px">
        <a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提交</a>
    </div>
</div>
<script type="text/javascript">
    function submitForm(){
        if(!$('#userAddForm').form('validate')){
            $.messager.alert('提示','表单还未填写完成!');
            return ;
        }
        $('#userAddForm').form('submit',{
            url:'/user/add',

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
</script>
