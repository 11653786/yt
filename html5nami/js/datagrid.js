var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);

var datagrid = myapp.controller('datagridcontroller', function ($scope) {
    $scope.name = "name";
});