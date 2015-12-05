var myapp = angular.module('myapp', ['ui.router', 'ngAnimate']);

var datagrid = myapp.controller('datagridcontroller', function ($scope) {
    $scope.name = "欢迎来到angularjs,angularjs文档:http://docs.angularjs.cn/api/ng/function/angular.copy";
    $scope.items = ["item1", "item2", "item3"];
    $scope.user = {name: "name", age: "18"};
    $scope.user.name = "zhangsan";
    $scope.member = {name: "zhagnsan1", age1: "16s"};
    //点击按钮user对象被member对象替换

    $scope.angularcode = function () {
        angular.copy($scope.member, $scope.user);
    }
});


//自定义百度标签
myapp.directive('baidu', function () {
    return {
        restrict: 'EAMC',
        //为true的时候只显示原标签内容
        replace: true,
        //没有使用scope,从directive中的controller里获取了{{html}}
        template: function (element, attr) {
            if (attr.baidu == "google") {
                return "百度标签,google";

            } else if (attr.baidu == 'baidu') {
                return "<h3>百度标签,baidu</h3>";
            } else {
                return "其他标签,{{name}}";
            }
        },
        link: function (scope, element, attr) {
            element.on("click", function () {
                alert(attr.baidu);
            });
        }
    }
});