//angulrjs模板
//mycontrollermodule,是我自己定义的controller
//myFilters 自定义的拦截器...filters.js下的
//myServices 自己定义的service
// myDirectives 自定义标签的玩意...
var angulrjs = angular.module('myapp', ['ngRoute', 'ngAnimate', 'mycontroller', 'myFilters','myServices', 'myDirectives']);
//路由控制器
angulrjs.config(function($routeProvider) {
    //制定html/hello.html页面的路由,并且,制定他的controller名称为hellocontroller
    $routeProvider.when('/hello', {
        templateUrl: 'html/hello.html',
        controller: 'hellocontroller'
    }).when('/list',{
    	templateUrl:'html/list.html',
    	controller:'listcontroller'
    }).otherwise({
        //默认的首页
        redirectTo: '/hello'
    })
});
