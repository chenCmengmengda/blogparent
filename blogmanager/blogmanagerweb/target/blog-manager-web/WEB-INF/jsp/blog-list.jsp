<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2018/7/25
  Time: 23:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="easyui-datagrid" id="blogList" title="已发博客列表"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/blog/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <%--<th data-options="field:'id',width:60">博客ID</th>--%>
        <th data-options="field:'title',width:100">标题</th>
        <th data-options="field:'summary',width:200">摘要</th>
        <th data-options="field:'createTime',width:100,formatter:Blog.formatDateTime">创建时间</th>
        <th data-options="field:'updateTime',width:100,formatter:Blog.formatDateTime">更新时间</th>
        <th data-options="field:'id',width:100,formatter:formatUrl">查看详细</th>
    </tr>
    </thead>
</table>
<div id="blogReadWindow" class="easyui-window" title="查看博客内容" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:80%;height:80%;padding:10px;">
</div>
<div id="blogEditWindow" class="easyui-window" title="编辑博客" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/blog-edit'" style="width:80%;height:80%;padding:10px;">
</div>
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

    // 格式化连接
    function formatUrl(val,row){
        if(val){
            return "<a href='javascript:readBlog("+val+")' target='_blank'>查看</a>";
        }
        return "";
    }

    function readBlog(val){
        var param={ "id":val };
        $("#blogReadWindow").window({

            onOpen:function() {
                $.post("/blog/read",param,function(data){
                    if(data.status == 200) {
                        $("#blogReadWindow").html(data.data.blogDesc);
                    }
                });

            }
        }).window('open');
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
            //打开写博客界面
            openTab('写博客','blog-write','icon-write');
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

            $("#blogEditWindow").window({
                onLoad :function() {
                    //回显数据
                    var data = $("#blogList").datagrid("getSelections")[0];
                    //日期格式化
                    data.birthday=new Date(data.birthday).format("yyyy-MM-dd");
                /*    var param={"id":ids};
                    bl.ajaxAsync("/blog/read",param,function(data){
                        if(data.status == 200) {
                            data.desc=data.data.blogDesc;

                        }
                    });*/
                    $("#blogEditForm").form("load", data);

                }
            }).window('open');
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