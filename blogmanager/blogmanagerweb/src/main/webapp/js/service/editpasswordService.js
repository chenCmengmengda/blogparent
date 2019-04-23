editpasswordApp.service('editpasswordService',function($http){
   this.editpassword=function(entity){
       return $http.post("../user/editpassword.do",entity);
    }

});