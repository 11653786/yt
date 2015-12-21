myapp.directive("userdirective", function () {
    return {
        restrict: "EACM",
        replace: false,
        //妈蛋,引入的url路径要写当前html页面所在位置从html到引入html的位置，而不是app.js所在位置
        template: "<div>自定义标签</div>"
    }
});

myapp.directive("usertransclude", function () {
    return {
        restrict: "EACM",
        replace: false,
        transclude: true,
        template: "<div >hello,<span ng-transclude>transclude!</span></div>"

    }
});

myapp.directive("directive",function(){
        var htmls="<div>scope隔离:{{scope1}},<b ng-transclude>click</b></div>"
    return{
        restrict:"EA",
        transclude:false,
        template:htmls,
        link:function(scope,element,attrs){
            scope.loads=function(){
            }
        }
    }
});