myapp.directive('hello1',function(){
        return {
            restrict:"EA",
            replace:false,      //默认
            //新开启的独立作用于
            scope:{},
            //这个controller是独立的controller，用来给外部提供接口的
            controller:function($scope){
               $scope.name="hehe1";
                this.getName=function(){
                    $scope.name="name1";
                };

                this.getSex=function(){
                    $scope.name="sex1";
                };
            },
            transclude: true,
            //允许使用内部自定义,里面不管写什么标签都是包在String中
            template: '<div>Hi there <strong ng-transclude></strong></div>',
            link:function(scope,ele,attr){
                    ele.on("click",function(){
                        alert(132);
                    })
            }
        }
});

//这是扩展，而非继承
myapp.directive('object1',function(){
        return{
            restrict:"EA",
            scope:{},
            replace:false,
            transclude:true,
            controller:function($scope){
            $scope.name="自定义scope,name";
            },
            template:function(){
                return "<div>{{name}}<strong ng-transclude></strong></div>";
            }
        }
});

myapp.directive('interfaces1',function(){
        return {
            restrict:"E",
            replace:false,
            transclude:true,
            scope:{},
            template:"interfaces1",
            //controller是对外提供接口的
            controller:function($scope){
                $scope.name="this name";
                $scope.age="this age";
                $scope.sex="this sex";
                $scope.email="this email";

                this.getName=function(){
                    return $scope.name;
                };
                this.getAge=function(){
                    return $scope.age;
                };
                this.getSex=function(){
                    return $scope.sex;
                };
                this.getEmail=function(){
                    return $scope.email;
                };
            },link:function(scope,ele,attr){
                ele.on("click",function(){
                        console.log(scope.age);
                })
            }
        }
});

//扩展貌似只能扩展属性,不能新生成标签,大爷的
myapp.directive('name',function(){
    return {
        require:"^?interfaces1",
        link:function(scope,ele,attr,parentDirective){
            ele.on("click",function(){
                console.log(parentDirective.getName());
            })
        }
    }
})
//扩展的第二个属性
myapp.directive('sex',function(){
    return {
        require:"^interfaces1",
        link:function(scope,ele,attr,parentDirective){
            ele.on("click",function(){
                console.log(parentDirective.getSex());
            })
        }
    }
})

myapp.directive('email',function(){
    return {
        require:"^interfaces1",
        link:function(scope,ele,attr,parentDirective){
            ele.on("click",function(){
                console.log(parentDirective.getEmail());
            })
        }
    }
})

//执行自定义标签在作用域上的方法
myapp.directive("loader",function(){
        return {
            restrict:"E",
            replace:false,
            transclude:true,
            template:"<div>loader,tag<b ng-transclude></b></div>",
            link:function(scope,ele,attr){
                //给当前元素绑定事件,不绑定的话控制台会报错
                ele.on('click',function(){
                    //给当前标签的激活howtoload事件
                    scope.$apply(attr.howtoload);
                });
            }
        }
});












