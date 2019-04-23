roleToUser.service('roleToUserService',function($http){

    this.findOtherRoles=function(id){
        return $http.get('../user/findOtherRoles.do?id='+id);
    }

    this.addRoleToUser=function(userId,roleIds){
        return $http.get('/user/addRoleToUser.do?userId='+userId+'&roleIds='+roleIds);
    }
});