indexApp.service('indexService',function($http){
    this.index=function(){
        return $http.get('../index.do');
    }
});