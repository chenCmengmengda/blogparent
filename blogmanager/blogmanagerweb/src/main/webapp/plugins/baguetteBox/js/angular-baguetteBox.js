(function() {
    "use strict";

    angular.module('ngbaguette',[]).directive('onFinishRenderFilters', function ($timeout) {
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

    });



})();