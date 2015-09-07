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
            controller:function($scope){
                $scope.world="world!!!!";
                $scope.name="123";
                //$watch用来监控数据变化的,name这个属性已经被我监控了
               $scope.$watch('name',function(oldvalue,newvalue){
                    alert("watch listener: "+oldvalue+","+newvalue);
                });



                //3秒之后执行,apply用来执行3秒后的方法
                $scope.setValue=function(){
                    setTimeout(function(){
                        $scope.$apply(function(){
                            $scope.timeout="3secound after!,timeout!";
                        });
                    },3000);
                }
                //调用这个方法
                $scope.setValue();

                var ngInjector = angular.injector(['ng']);
                for(var a in ngInjector){
                    alert(a+","+ngInjector[a]);
                }



            },
            service:function($scope){

            }
        })
        .state('state2', {
            url: "/list",
            templateUrl: "html/list.html",
            controller: function($scope) {
                $scope.arrays1=[1,2,3,4];
                $scope.ak="hehe!ak";
            }
        }).state('lookviews',{
            url:"/lookviews",
            //view的使用
            views:{
                '':{
                    templateUrl:"html/lookviews.html",
                    controller:'myviewc',
                },
                'div2@lookviews':{
                    template:"div2!!!!-----------"
                },'div3@lookviews':{
                    templateUrl:"html/hello.html",
                    controller:function($scope){
                        $scope.world="div3,include html/helloworld";
                    }
                }
            }
        })
});
//views用于控制显示一个html上有多个元素


//设置页面上的div属性,对state2 这个页面下的html/list.
//list页面decontroller
myapp.controller('listdiv',function($scope){
    $scope.ak="hello,ak!";
});

myapp.controller("myviewc",function($scope){
    $scope.test="testview!!";
});
