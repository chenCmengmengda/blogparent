sysParameterApp.service('sysParameterService',function($http){
   this.getSysParameter=function(){
       return $http.get('/sys/getSysParameter.do');
   }

   this.editSysParameter=function(entity){
       return $http.post('/sys/editSysParameter.do',entity);
   }
});