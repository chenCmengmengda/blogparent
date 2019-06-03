blogCatApp.controller('blogCatController',function($scope,blogCatService){

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
        $scope.findAll($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);

    }

    $scope.findAll=function(page,rows){
        blogCatService.getBlogCatList(page,rows).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }

    $scope.add=function(){
        blogCatService.addBlogCat($scope.entity).success(
            function(response){
                if(response.status==200){
                    alert('添加成功');
                    $scope.reloadList();
                } else{
                    alert(response.msg);
                }
            }
        );
    }
});