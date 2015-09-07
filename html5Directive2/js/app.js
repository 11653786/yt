var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);


myapp.config(function($stateProvider, $urlRouterProvider) {
    //o
    $urlRouterProvider.otherwise("/hello");
    //匹配ui-sref=state1超链接,的属性路径为/hello,真实地址是html/prototype.html
    //$apply()方法可以在angular框架之外执行angular JS的表达式，例如：DOM事件、setTimeout、XHR或其他第三方的库。这仅仅是个开始，水还有很深，欢迎大家一起来deep dive！
    //这里只定义路由其他的不用ui-route管理
    $stateProvider.state('hello',{
        //匹配路径
        url: "/hello",
        views:{
            //当前页面的ui-view为''的直接显示html/prototype.html,也可以理解为设置首页
            'tohello':{
                //去hello,页面
                templateUrl: "html/prototype.html",
            }
        }
    })
});