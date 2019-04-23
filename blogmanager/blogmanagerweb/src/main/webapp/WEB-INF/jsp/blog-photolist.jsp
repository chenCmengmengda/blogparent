<%--
  Created by IntelliJ IDEA.
  User: 陈_C
  Date: 2019/2/28
  Time: 10:24
  To change this template use File | Settings | File Templates.
  相册列表页面
  需要标题，说明，图片
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<table class="easyui-datagrid" id="blogPhotoList" title="博客相册"
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'/photo/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
    <tr>
        <th data-options="field:'ck',checkbox:true"></th>
        <th data-options="field:'photoId',width:60">相册ID</th>
        <th data-options="field:'photoTitle',width:100">相册标题</th>
        <th data-options="field:'photoExplain',width:200">相册说说</th>
        <th data-options="field:'createTime',width:100,formatter:Blog.formatDateTime">创建时间</th>
        <th data-options="field:'updateTime',width:100,formatter:Blog.formatDateTime">更新时间</th>
        <th data-options="field:'photoImages',width:100,formatter:formatUrl">查看图片</th>
    </tr>
    </thead>
</table>
<div id="photoAddWindow" class="easyui-window" title="添加相册" data-options="modal:true,closed:true,iconCls:'icon-save',href:'/photo-add'" style="width:80%;height:80%;padding:10px;"></div>
<script>
    //选择列表，获取id
    function getSelectionsIds(){
        var blogList = $("#blogPhotoList");
        var sels = blogList.datagrid("getSelections");
        var ids = [];
        for(var i in sels){
            ids.push(sels[i].photoId);
        }
        ids = ids.join(",");
        return ids;
    }

    // 格式化连接
    function formatUrl(val,row){
        if(val){
            return "<a href="+val+" target='_blank'>查看</a>";
        }
        return "";
    }

    var toolbar = [{
        text:'新增',
        iconCls:'icon-add',
        handler:function(){
           //打开添加相册页面
            $("#photoAddWindow").window('open');
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

            $("#photoEditWindow").window({
                onLoad :function() {
                    //回显数据
                    var data = $("#blogPhotoList").datagrid("getSelections")[0];
                    //日期格式化
                    data.birthday=new Date(data.birthday).format("yyyy-MM-dd");
                    /*    var param={"id":ids};
                        bl.ajaxAsync("/blog/read",param,function(data){
                            if(data.status == 200) {
                                data.desc=data.data.blogDesc;

                            }
                        });*/
                    $("#photoEditForm").form("load", data);

                }
            }).window('open');
        }
    },{
        text:'删除',
        iconCls:'icon-cancel',
        handler:function(){
            var ids = getSelectionsIds();
            if(ids.length == 0){
                $.messager.alert('提示','未选中相册!');
                return ;
            }
            $.messager.confirm('确认','确定删除ID为 '+ids+' 的相册吗？',function(r){
                if (r){
                    var params = {"ids":ids};
                    $.post("/photo/delete",params, function(data){
                        if(data.status == 200){
                            $.messager.alert('提示','删除相册成功!',undefined,function(){
                                $("#itemList").datagrid("reload");
                            });
                        }
                    });
                }
            });
        }
    }];
</script>