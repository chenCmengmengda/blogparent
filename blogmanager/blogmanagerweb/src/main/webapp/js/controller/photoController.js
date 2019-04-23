photoApp.controller('photoController',function($scope,photoService){
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

    $scope.findPage=function(page,rows){
        photoService.findPage(page,rows).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }

    $scope.check=function(imgUrl){
        window.location.href=imgUrl;
    }

    $scope.add=function(){
        $scope.entity.photoImages=$("input[name='photoImages']").val();
        photoService.add($scope.entity).success(
            function(response){
                if(response.status==200){
                    $scope.reloadList();
                } else{
                    alert("上传失败");
                }
            }
        );
    }
});