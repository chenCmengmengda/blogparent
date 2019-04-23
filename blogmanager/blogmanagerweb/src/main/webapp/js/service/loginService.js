login.service('loginService',function($http){
   this.login=function(entity){
       return $http.post('/user/login.do',entity);
   }
});