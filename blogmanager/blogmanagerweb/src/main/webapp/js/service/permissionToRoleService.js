permissionToRole.service('permissionToRoleService',function($http){
    this.findOtherPermissions=function(id){
        return $http.get('../role/findOtherPermissions.do?id='+id);
    }

    this.addPermissionToRole=function(roleId,permissionIds){
        return $http.get('/role/addPermissionToRole.do?roleId='+roleId+'&permissionIds='+permissionIds);
    }
});