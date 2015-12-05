//这里只写每一个页面的路由映射,其他的子div映射之类的重新起一个js文件写
//http://rensanning.iteye.com/blog/2149056
//url只是显示路径。
//参数1state1 是传入的参数
//temlateUrL真实路径
//views,一个页面上如果有多个ui-view使用,命名规则:state名@ui-view名
myapp.config(function ($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/hello");
    //匹配ui-sref=state1超链接,的属性路径为/hello,真实地址是html/form.html
    //$apply()方法可以在angular框架之外执行angular JS的表达式，例如：DOM事件、setTimeout、XHR或其他第三方的库。这仅仅是个开始，水还有很深，欢迎大家一起来deep dive！
    $stateProvider.state('hello', {
        //匹配路径
        url: "/hello",
        views: {
            //当前页面的ui-view为''的直接显示html/form.html,也可以理解为设置首页
            '': {
                templateUrl: "datagrid.html",
                //controller: "datagridcontroller"
            }
        }
    })
});




