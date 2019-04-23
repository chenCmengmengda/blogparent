roleApp.controller('roleController',function($scope,$window,roleService){
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载

        }
    };

    $scope.reloadList=function(){
        //切换页码
        $scope.findPage($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    //读取列表数据绑定到表单中
    $scope.findPage=function(page,rows){
        roleService.findPage(page,rows).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }

    $scope.addRole=function(){
        roleService.addRole($scope.entity).success(
            function(response){
                if(response.status==200){
                    $scope.reloadList();//重新加载
                }
            }
        );
    }

    $scope.goAddPermission=function(id){
        $window.location.href='add_permission_to_role.html?id='+id;
    }

    $scope.goFindPermission=function(id){
        $window.location.href='findPermission.html?id='+id;
    }



});