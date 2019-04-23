userApp.controller('userController',function($scope,$window,userService){
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [10, 20, 30, 40, 50],
        onChange: function(){
            $scope.reloadList();//重新加载

        }
    };

    //读取列表数据绑定到表单中
    $scope.findAll=function(page,rows){
        userService.findAll(page,rows).success(
            function(response){
                if(response.status==403){
                    $window.location.href=response.msg;
                }
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }

    $scope.reloadList=function(){
        //切换页码
        $scope.findAll($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    /**
     * 查询一个用户信息
     * @param id
     */
    $scope.findOne=function(id){
        userService.findOne(id).success(
            function (response){
                $scope.entity=response.data;

            }
        );
    }

    $scope.userAdd=function(){
        userService.userAdd($scope.entity).success(
            function(response){
                if(response.status==200){
                    $scope.reloadList();//重新加载
                }
            }
        );
    }

    //页面跳转
    $scope.goAddRole=function(id){

        $window.location.href='add_role_to_user.html?id='+id;
    }

    $scope.goFindRole=function(id){
        $window.location.href='findRole.html?id='+id;
    }

});