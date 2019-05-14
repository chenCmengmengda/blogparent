

findRole.controller('findRoleController',
    function($scope,$timeout,$window,$location,findRoleService){

    $scope.id={};
    $scope.findRole=function(){
        $scope.id=$location.search().id;

        findRoleService.findRole($scope.id).success(
            function(response){
                $scope.list=response;
                data=response;

            }
        );
/*
        $timeout(function(){
            $("#collapse-table").treetable({
                expandable: true
            });
        },100);*/
    }

    $scope.userRoleKey={};
    $scope.getId=function(roleId){
        $scope.userRoleKey.userid=$scope.id;
        $scope.userRoleKey.roleid=roleId;
    }

    $scope.deleRoleToUser=function(){
        findRoleService.deleRoleToUser($scope.userRoleKey).success(
            function(response){
                if(response.status==200){
                    $window.location.reload();
                }
            }
        );
    }


}).config([ '$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode({
        //设置为html5Mode(模式)，当为false时为Hashbang模式
        enabled : true,
        //是否需要加入base标签，这里设置为false，设置为true时，需在html的head配置<base href="" />标签
        requireBase : false
    });
} ]);
