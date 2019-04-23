//博客服务层
app.service('blogService',function($http){
    //读取列表数据绑定到表单中
    this.findAll=function(page,rows){
        return $http.get('../blog/list.do?page='+page+"&rows="+rows);
    }

    this.findOne=function(id){
        return $http.get('../blog/findOne.do?id='+id);
    }

    this.update=function(entity){
        return $http.post('../blog/edit.do',entity);
    }

    this.dele=function(selectIds){
        return $http.get('../blog/delete.do?ids='+selectIds);
    }

});

blogWriteApp.service('blogWriteService',function($http){
   this.blogAdd=function(entity){
       return $http.post('../blog/add.do',entity);
   }
});
