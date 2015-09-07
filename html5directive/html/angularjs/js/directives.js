//hello标签
//属性和标签
//<hello></hello>
// <div hello></div>  都可以显示如下内容
myapp.directive('hello',function(){
    return {
        //可以用作注释、属性、标签,主要用作属性和标签
        //匹配模式
        restrict:'EA',
        template:"<div>i am hello tags!</div>"
    }
});

myapp.directive('forms',function(){
    return {
        restrict:"EACM",
        //妈蛋,引入的url路径要写当前html页面所在位置从html到引入html的位置，而不是app.js所在位置
        templateUrl:"html/form.html",
    }
});

//angularjs，缓存使用
//使用缓存缓存起来
myapp.run(function($templateCache){
    $templateCache.put("hello","<div class='aa'>hello,templateCache....</div>");
});
//在标签里标用缓存
myapp.directive('mycache',function($templateCache){
    return{
        restrict:"EA",
        template:$templateCache.get('hello')
    }
});

//directive transclude transclude
//transclude的使用,让自定义的标签内部嵌套内容(比如你定义的hello标签内部是无法嵌套自己的内容的这里就要用transclude)
myapp.directive('hellotransclude',function(){
        return {
            restrict:"EA",
            transclude:true,
            //html元素如下
            //根元素是div里面随便添加标签
            //html代码如下: <hellotransclude><span>transclude,在自定义标签内部添加元素</span><div>,添加div</div></hellotransclude>
            //这个hello标签里面随便写都是嵌套的
            template:"<div ng-transclude>use transclude</div>"
        }
});
//directive的三个阶段，加载、编译（缓存）、链接  compile:functionz(){},一般不写
//link函数,操作dom元素,所有的事件,自定义标签的click事件
myapp.directive('loader',function(){
    return{
        restrict:"EA",
        //link专门用来绑定dom元素
        link:function(scope,element,attr){
            //绑定事件,2个都是一个意思
            //element.bind('click',function(){
            //    scope.loadData();
            //});
            element.on('click',function(){
                //scope.loadData();
                //使用
                scope.$apply('loadData()');
            });
        }
    }
});

//自定义百度标签
myapp.directive('baidu',function(){
    return {
        restrict:'EAMC',
        //没有使用scope,从directive中的controller里获取了{{html}}
        template:"百度tag,emac,{{html}}"
    }
});
