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
 * �����������д������������������ǳ��࣬��Ҫ�ָ���������ߣ����Խ�����grunt���ϲ�����
 */