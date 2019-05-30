messageApp.controller('messageController',
    function($scope,messageService){
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
            messageService.findPage(page,rows).success(
                function(response){
                    $scope.paginationConf.totalItems=response.total;//总记录数
                    $scope.list=response.rows;//给列表变量赋值
                }
            );
        }

        $scope.message={};
        $scope.findId='';
        $scope.findOne=function(messageId){
            $scope.message={};
            $scope.entity={};
            $scope.findId=messageId;
            messageService.findOne(messageId).success(
                function(response){
                    if(response.status==200){
                        $scope.message=response.data;
                    }
                }
            );
        }

        $scope.addReply=function(entity){
            if(entity.message==null){
                alert("回复不能为空");
                return;
            }
            if($scope.message.myreply==null){
                $scope.message.myreply={};
            }
            $scope.message.myreply.message=entity.message;

            messageService.addReply($scope.message).success(
                function(response){
                    if(response.status==200){
                        alert("发送成功");
                        $scope.reloadList();//重新加载
                        $scope.findOne($scope.findId);
                    }
                }
            );
        }
})