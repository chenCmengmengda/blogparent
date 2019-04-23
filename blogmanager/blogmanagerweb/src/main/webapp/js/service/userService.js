userApp.service('userService',function($http){
    //读取列表数据绑定到表单中
    this.findAll=function(page,rows){
        return $http.get('../user/list.do?page='+page+"&rows="+rows);
    }

    this.findOne=function(id){
        return $http.get('../user/findOne.do?id='+id);
    }

    this.userAdd=function(entity){
        return $http.post('../user/add.do',entity);
    }
});