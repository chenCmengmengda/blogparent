logApp.service('logService',function($http){
    //读取列表数据绑定到表单中
    this.findPage=function(page,rows){
        return $http.get('../syslog/list.do?page='+page+"&rows="+rows);
    }
})