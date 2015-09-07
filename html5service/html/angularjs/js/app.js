var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);
//这里只写每一个页面的路由映射,其他的子div映射之类的重新起一个js文件写
//http://rensanning.iteye.com/blog/2149056
//url只是显示路径。
//参数1state1 是传入的参数
//temlateUrL真实路径
//views,一个页面上如果有多个ui-view使用,命名规则:state名@ui-view名
myapp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/hello");
    //匹配ui-sref=state1超链接,的属性路径为/hello,真实地址是html/hello.html
    //$apply()方法可以在angular框架之外执行angular JS的表达式，例如：DOM事件、setTimeout、XHR或其他第三方的库。这仅仅是个开始，水还有很深，欢迎大家一起来deep dive！
    $stateProvider.state('state1',{
            //匹配路径
            url: "/hello",
            templateUrl: "html/hello.html",
            controller:'divcontroller',
        })

});


myapp.controller('divcontroller',function($scope,myfactory,myservice,myprovider){
    $scope.hello=myfactory.getList();
    $scope.servicehello=myservice.pages;
    var str=myprovider.save();
});


//创建service的几种方法,service 的第一种使用方法,
// 1.创建一个factory对象
// 2.给这个对象添加属性,
// 3.传入到controller中去
// 4.生存周期应该是和controller同时销毁
//5.我把他做成了dao
//6.对象已经写好了一样
myapp.factory('myfactory',function($http){
    var list=[1,2,3,4,5];
    var service={};
    service.getList=function(){
        return list;
    }
    return service;
});
//第二种方法service,
// 可以在所有的controller中使用
//生命周期很长
//new 出来得都要用this
//这里面把myfctory层当成了dao层引入
myapp.service("myservice",function(myfactory){
   this.obj={name1:"name11",name2:"name22",name3:"name33",name4:"name44"};
    this.list=myfactory.getList();
    this.pageSize=this.list.length;
    this.pages={obj:this.obj,list:this.list,pageSize:this.pageSize};
});
//第三种方法
//底层实现可
//必须this.$get方法
//为什么请求道不了呢？
//可以封装成方法了啊...
myapp.provider('myprovider', function() {
        this.backendUrl = "http://localhost:8080/api/user/datagrid.html";
        this.$get = function($http) { // injectables go here
            var self = this;
            var service = {
                user: {},
                //setName: function(newName) {
                //    service.user['name'] = newName;
                //},
                //setEmail: function(newEmail) {
                //    service.user['email'] = newEmail;
                //},
                save: function() {return $http.post(self.backendUrl,{user: service.user})}
            };
            return service;
        }
    });


