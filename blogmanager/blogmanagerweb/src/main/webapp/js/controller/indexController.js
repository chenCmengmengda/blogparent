indexApp.controller('indexController',function($scope,indexService){
   $scope.index=function() {
       indexService.index().success(
           function(response){
                $scope.entity=response.data;
           }
       );
   }
})
