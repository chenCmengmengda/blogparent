findRole.service('findRoleService',function($http){
    this.findRole=function(userId){
        return $http.get('../user/findUserRolePermissionById.do?userId='+userId);
    }
});