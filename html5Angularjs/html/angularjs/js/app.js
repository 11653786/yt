var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);
//����ֻдÿһ��ҳ���·��ӳ��,��������divӳ��֮���������һ��js�ļ�д
//http://rensanning.iteye.com/blog/2149056
//urlֻ����ʾ·����
//����1state1 �Ǵ���Ĳ���
//temlateUrL��ʵ·��
//views,һ��ҳ��������ж��ui-viewʹ��,��������:state��@ui-view��
myapp.config(function($stateProvider, $urlRouterProvider) {
    $urlRouterProvider.otherwise("/hello");
    //ƥ��ui-sref=state1������,������·��Ϊ/hello,��ʵ��ַ��html/hello.html
    //$apply()����������angular���֮��ִ��angular JS�ı��ʽ�����磺DOM�¼���setTimeout��XHR�������������Ŀ⡣������Ǹ���ʼ��ˮ���к����ӭ���һ����deep dive��
    $stateProvider.state('state1',{
            //ƥ��·��
            url: "/hello",
            templateUrl: "html/hello.html",
            controller:function($scope){
                $scope.world="world!!!!";
                $scope.name="123";
                //$watch����������ݱ仯��,name��������Ѿ����Ҽ����
               $scope.$watch('name',function(oldvalue,newvalue){
                    alert("watch listener: "+oldvalue+","+newvalue);
                });



                //3��֮��ִ��,apply����ִ��3���ķ���
                $scope.setValue=function(){
                    setTimeout(function(){
                        $scope.$apply(function(){
                            $scope.timeout="3secound after!,timeout!";
                        });
                    },3000);
                }
                //�����������
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
            //view��ʹ��
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
//views���ڿ�����ʾһ��html���ж��Ԫ��


//����ҳ���ϵ�div����,��state2 ���ҳ���µ�html/list.
//listҳ��decontroller
myapp.controller('listdiv',function($scope){
    $scope.ak="hello,ak!";
});

myapp.controller("myviewc",function($scope){
    $scope.test="testview!!";
});
