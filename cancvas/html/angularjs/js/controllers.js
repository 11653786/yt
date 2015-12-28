var mycontroller = angular.module('mycontroller', []);

mycontroller.controller('hellocontroller', ['$scope',
    function($scope) {
       $scope.world="world!!!";
    }
]);

mycontroller.controller('listcontroller', ['$scope',
    function($scope) {
        alert('list');
    }
]);

/**
 * 这里接着往下写，如果控制器的数量非常多，需要分给多个开发者，可以借助于grunt来合并代码
 */