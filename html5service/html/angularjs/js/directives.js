var myDirectives = angular.module('myDirectives', []);

myDirectives.directive('myDirectives_1', ['$scope',
    function($scope) {
        alert('directives1');
    }
]);

myDirectives.directive('myDirectives_2', ['$scope',
    function($scope) {}
]);