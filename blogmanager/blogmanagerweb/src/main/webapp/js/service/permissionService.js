permissionApp.service('permissionService',function($http){
   this.findPage=function(page,rows){
       return $http.get('../permission/list.do?page='+page+"&rows="+rows);
   }

   this.addPermission=function(entity){
       return $http.post('../permission/add.do',entity);
   }
});