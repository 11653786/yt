//angulrjsģ��
//mycontrollermodule,�����Լ������controller
//myFilters �Զ����������...filters.js�µ�
//myServices �Լ������service
// myDirectives �Զ����ǩ������...
var angulrjs = angular.module('myapp', ['ngRoute', 'ngAnimate', 'mycontroller', 'myFilters','myServices', 'myDirectives']);
//·�ɿ�����
angulrjs.config(function($routeProvider) {
    //�ƶ�html/hello.htmlҳ���·��,����,�ƶ�����controller����Ϊhellocontroller
    $routeProvider.when('/hello', {
        templateUrl: 'html/hello.html',
        controller: 'hellocontroller'
    }).when('/list',{
    	templateUrl:'html/list.html',
    	controller:'listcontroller'
    }).otherwise({
        //Ĭ�ϵ���ҳ
        redirectTo: '/hello'
    })
});
