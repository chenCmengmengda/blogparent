roleToUser.controller('roleToUserController',
    function($scope,$location,roleToUserService){

    $scope.id={};

    $scope.findOtherRoles=function(){
        $scope.id = $location.search().id;
        console.log($location.search());
        roleToUserService.findOtherRoles($scope.id).success(
            function(response){
                $scope.list=response.rows;
            }
        );
    }

        $scope.selectRoleIds=[];//选中的ID集合
        //更新复选
        $scope.updateSelection = function($event, id) {
            if($event.target.checked){//如果是被选中,则增加到数组
                $scope.selectRoleIds.push( id);
            }else{
                var idx = $scope.selectRoleIds.indexOf(id);
                $scope.selectRoleIds.splice(idx, 1);//删除 位置，个数
            }
        }

        $scope.addRoleToUser=function(){
            console.log($scope.id);
            console.log($scope.selectRoleIds);
            roleToUserService.addRoleToUser($scope.id,$scope.selectRoleIds).success(
                function(response){
                    if(response.status==200){
                        $scope.findOtherRoles();
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