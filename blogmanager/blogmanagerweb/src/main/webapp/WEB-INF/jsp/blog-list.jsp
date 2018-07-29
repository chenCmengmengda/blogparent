<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/25
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="easyui-datagrid" id="blogList" title="已发博客列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/user/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'id',width:60">博客ID</th>
        <th data-options="field:'title',width:200">标题</th>
        <th data-options="field:'abstract',width:100">摘要</th>
        <th data-options="field:'createTime',width:100">创建时间</th>
        <th data-options="field:'updateTime',width:100">更新时间</th>
    </tr>
    </thead>
</table>
<script type="text/javascript">
    function getSelectionsIds(){
        var blogList = $("#blogList");
        var sels = blogList.datagrid("getSelections");
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

        }
    },{
        text:'编辑',
        iconCls:'icon-edit',
        handler:function(){
            var ids = getSelectionsIds();
            /*    if(ids.length == 0){
             $.messager.alert('提示','必须选择一个博客才能编辑!');
             return ;
             }
             if(ids.indexOf(',') > 0){
             $.messager.alert('提示','只能选择一个博客!');
             return ;
             }
             */

        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中博客!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的博客吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/blog/delete",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除博客成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>