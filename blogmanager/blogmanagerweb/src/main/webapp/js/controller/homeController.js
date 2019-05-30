homeApp.controller('homeController' ,function($scope,homeService){

    $scope.init=function(){
        $scope.getNewBlogTitle(6);
        $scope.getSysParameter();
    }

    $scope.getNewBlogTitle=function(rows){
        homeService.getNewBlogTitle(rows).success(
            function(response){
                if(response.status==200){
                    $scope.newBlogList=response.data;
                }
            }
        )
    }

    $scope.getSysParameter=function(){
        homeService.getSysParameter().success(
            function(response)  {
                $scope.entity=response.data;
            }
        );
    }
});