<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/25
  Time: 23:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="easyui-datagrid" id="userInfo" title="用户列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
            <th data-options="field:'ck',checkbox:true"></th>
            <th data-options="field:'id',width:60">用户ID</th>
            <th data-options="field:'nickname',width:200">用户昵称</th>
            <th data-options="field:'password',width:100">用户密码</th>
            <th data-options="field:'sex',width:100">性别</th>
            <th data-options="field:'birthday',width:100,formatter:Blog.formatDateTime">出生日期</th>
            <th data-options="field:'email',width:70,align:'right'">邮箱</th>
            <th data-options="field:'phone',width:70,align:'right'">联系电话</th>
        </tr>
    </thead>
</table>
<div id="userEditWindow" class="easyui-window" title="编辑用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/user-edit'" style="width:80%;height:80%;padding:10px;"></div>
<div id="userAddWindow" class="easyui-window" title="添加用户" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/user-add'" style="width:80%;height:80%;padding:10px;">
</div>
<script>
    function getSelectionsIds(){
        var userList = $("#userInfo");
        var sels = userList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].id);
        }
        ids = ids.join(",");
        return ids;
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            $("#userAddWindow").window({}).window('open');
        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','必须选择一个用户才能编辑!');
                return ;
            }
            if(ids.indexOf(',') > 0){
                $.messager.alert('提示','只能选择一个用户!');
                return ;
            }

            $("#userEditWindow").window({
                onLoad :function() {
                    //回显数据
                    var data = $("#userInfo").datagrid("getSelections")[0];
                    //日期格式化
                    data.birthday=new Date(data.birthday).format("yyyy-MM-dd");
                    $("#userEditForm").form("load", data);

                }
            }).window('open');
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中用户!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的用户吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/user/delete",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除用户成功!',undefined,function(){
                                $("#userInfo").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>

