(function() {
"use strict";

angular.module('ngtreetable',[]).directive('onFinishRenderFilters', function ($timeout) {
    return {
        restrict: 'A',
        link: function (scope, element, attr) {
            if (scope.$last === true) {    //判断是否是最后一条数据

                $timeout(function () {
                    scope.$emit('ngRepeatFinished'); //向父级scope传送ngRepeatFinished命令
                    $("table").treetable({
                        expandable: true
                    });
                });
            }
        }

    };

});



})();
