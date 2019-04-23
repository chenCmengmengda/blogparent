login.controller('loginController',function($scope,$window,loginService){

    $scope.login=function(entity){

        loginService.login(entity).success(
          function(response){
              if(response.status==200){
                  $window.location.href=response.msg;
              } else{
                  alert(response.msg);
              }
          }
        );
    }
});
