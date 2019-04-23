findPermission.service('findPermissionService',function($http){
    this.findPermission=function(roleId){
        return $http.get('../role/findRolePermissionById.do?id='+roleId);
    }
});