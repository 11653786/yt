var myFilters = angular.module('myFilters', []);

myFilters.filter('myFilters_1', ['$scope',
    function($scope) {
        alert('filter1');
    }
]);

myFilters.filter('myFilters_2', ['$scope',
    function($scope) {}
]);
