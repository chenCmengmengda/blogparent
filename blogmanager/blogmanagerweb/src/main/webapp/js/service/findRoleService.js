findRole.service('findRoleService',function($http){
    this.findRole=function(userId){
        return $http.get('../user/findUserRolePermissionById.do?userId='+userId);
    }

    this.deleRoleToUser=function(userRoleKey){
        return $http.post('../user/deleteRoleToUser.do',userRoleKey);
    }
});