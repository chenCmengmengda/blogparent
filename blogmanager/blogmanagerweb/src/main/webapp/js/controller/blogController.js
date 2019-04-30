//博客控制层
app.controller('blogController' ,function($scope,blogService){
    //读取列表数据绑定到表单中
    $scope.findAll=function(page,rows){
        blogService.findAll(page,rows).success(
            function(response){
                $scope.paginationConf.totalItems=response.total;//总记录数
                $scope.list=response.rows;//给列表变量赋值
            }
        );
    }
    //分页控件配置
    /**
     * currentPage:当前页
     * totalItems:总记录
     * itemsPerPage:每页记录
     * perPageOptions:分页选项
     *  onChange：更改页面时触发事件
     * @type {{currentPage: number, totalItems: number, itemsPerPage: number, perPageOptions: number[], onChange: onChange}}
     */
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
    //    $scope.search( $scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
        $scope.findAll($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    };

    $scope.findOne=function(id){
        blogService.findOne(id).success(
            function (response){
                $scope.entity=response;
                blogEditEditor.html($scope.entity.blogDesc);
            }
        );
    }

    $scope.update=function(){
        $scope.entity.imageUrl=$("input[name='imageUrl']").val();
        $scope.entity.blogDesc=blogEditEditor.html();
        blogService.update($scope.entity).success(
            function (response) {
                if (response.status==200) {
                    //重新查询
                    $scope.reloadList();//重新加载
                } else {
                    alert("编辑失败");
                }
            }
        );
    }

    $scope.selectIds=[];//选中的ID集合
    //更新复选
    $scope.updateSelection = function($event, id) {
        if($event.target.checked){//如果是被选中,则增加到数组
            $scope.selectIds.push( id);
        }else{
            var idx = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(idx, 1);//删除 位置，个数
        }
    }
    //批量删除
    $scope.dele=function(){
        //获取选中的复选框
        blogService.dele($scope.selectIds).success(
            function(response){
                if(response.status==200){
                    $scope.reloadList();//刷新列表
                }
            }
        );
    };




}).filter(
    'to_trusted', ['$sce', function ($sce) {
        return function (text) {
            return $sce.trustAsHtml(text);
        }
    }]
);
/*
app.filter(
    'to_trusted', ['$sce', function ($sce) {
        return function (text) {
            return $sce.trustAsHtml(text);
        }
    }]
)
*/
blogWriteApp.controller('blogWrite',function($scope,blogWriteService){
    $scope.blogAdd=function(){
        $scope.entity.imageUrl=$("input[name='imageUrl']").val();
        $scope.entity.blogDesc=blogAddEditor.html();
        if($scope.entity==null || $scope.entity.blogDesc==''){
            alert("内容不能为空");
            return;
        }
        blogWriteService.blogAdd($scope.entity).success(
            function(response){
                if(response.status==200){
                    alert("保存成功");
                } else{
                    alert("写博客失败");
                }
            }
        );

   //     blogService;
    }
});