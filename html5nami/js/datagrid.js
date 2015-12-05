var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);

var datagrid = myapp.controller('datagridcontroller', function ($scope) {
    $scope.name = "欢迎来到angularjs,angularjs文档:http://docs.angularjs.cn/api/ng/function/angular.copy";
    $scope.items = ["item1", "item2", "item3"];
    $scope.user.name = "angularjs";
});