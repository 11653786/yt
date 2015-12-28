var myServices = angular.module('myServices', []);

myServices.service('myServices_1', ['$scope',
    function($scope) {
        alert('service1');
    }
]);

myServices.service('myServices_2', ['$scope',
    function($scope) {}
]);
