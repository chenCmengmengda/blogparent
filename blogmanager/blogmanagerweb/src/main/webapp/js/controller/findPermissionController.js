findPermission.controller('findPermissionController',
    function($scope,$timeout,$location,findPermissionService){
        $scope.id={};
        $scope.findPermission=function(){
            $scope.id=$location.search().id;

            findPermissionService.findPermission($scope.id).success(
                function(response){
                    $scope.list=response;
                    data=response;

                }
            );

            $timeout(function(){
                $("#collapse-table").treetable({
                    expandable: true
                });
            },100);
        }

}).config([ '$locationProvider', function($locationProvider) {
    $locationProvider.html5Mode({
        //设置为html5Mode(模式)，当为false时为Hashbang模式
        enabled : true,
        //是否需要加入base标签，这里设置为false，设置为true时，需在html的head配置<base href="" />标签
        requireBase : false
    });
} ]);;