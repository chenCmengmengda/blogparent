sysParameterApp.controller('sysParameterController',function($scope,sysParameterService){

    $scope.init=function(){
        $scope.getSysParameter();
    }

    $scope.getSysParameter=function(){
        sysParameterService.getSysParameter().success(
            function(response)  {
                  $scope.entity=response.data;
            }
        );
    }

    $scope.editSysParameter=function(){
        if($scope.entity.cmsname==null || $scope.entity.cmsname==''){
            alert("网站名称不能为空");
            return;
        }
        if($scope.entity.author==null || $scope.entity.author==''){
            alert("开发作者不能为空");
            return;
        }
        sysParameterService.editSysParameter($scope.entity).success(
            function(response)  {
                if(response.status==200) {
                    $scope.entity = response.data;
                    alert("保存成功");
                } else{
                    alert(response.msg);
                }
            }
        );
    }
});