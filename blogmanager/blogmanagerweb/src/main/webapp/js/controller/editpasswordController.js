editpasswordApp.controller('editpasswordController',
    function($scope,$location,editpasswordService){
    $scope.entity={};

    $scope.init=function() {

    }
    $scope.editpassword=function(){
        $scope.entity.user.nickname = $location.search().username;
        console.log($location.search());
   //     alert($scope.entity.user.nickname);
        editpasswordService.editpassword($scope.entity).success(
            function(response){
                if(response.status==200){
                    alert("系统密码修改成功");
                } else{
                    alert("修改失败");
                }
            }
        )
    }
}).config([ '$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode({
        //设置为html5Mode(模式)，当为false时为Hashbang模式
        enabled : true,
        //是否需要加入base标签，这里设置为false，设置为true时，需在html的head配置<base href="" />标签
        requireBase : false
    });
} ]);