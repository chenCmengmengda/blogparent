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

    $scope.selectIds=[];//选中的ID集合
    $scope.checkone=false;//默认未选中
    var flag=false;//是否点击了全选，是为true
    //全选
    $scope.selectAll = function () {
        $scope.selectIds=[];

        if(flag==false){
            $scope.master=true;
        } else{
            $scope.master=false;
        }
        if($scope.master==true){
            $scope.checkone=true;
            angular.forEach($scope.list, function (i) {
                $scope.selectIds.push(i.photoId);
            });

            flag=true;
        }else{
            $scope.checkone=false;
            $scope.selectIds=[];
            flag=false;
        }
    //    console.log($scope.selectIds);

    };
    //更新复选
    $scope.updateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.selectIds.push( id);
    //        console.log($scope.selectIds);
        }else{
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除 位置，个数
    //        console.log($scope.selectIds);
        }
    }

    $scope.delete=function(){
        if($scope.selectIds==null || $scope.selectIds==''){
            alert("请选择图片!");
            return;
        }
        photoService.delete($scope.selectIds).success(
            function(response){
                if(response.status==200){
                    alert("删除成功");
                    $scope.reloadList();//重新加载
                }
            }
        );
    }

});
/*    .directive('onFinishRenderFilters', function ($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            if (scope.$last === true) {    //判断是否是最后一条数据

                $timeout(function () {
                    baguetteBox.run('.table-box');
                });
            }
        }

    };

});*/