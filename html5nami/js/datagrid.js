var datagrid = myapp.controller('datagridcontroller', function ($scope, userService,$http) {
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
        scope: {},
        controller: function ($scope) {
            $scope.name = "$scope.name";
        },
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

//自定义百度标签
myapp.directive('hello', function () {
    return {
        restrict: 'EA',
        //transclude的使用,显示当前标签的原始内容,并且显示出template中添加的内容
        template: '<h3>Hello, Directive, <span ng-transclude></span></h3>',
        replace: true,
        transclude: true
    };
});

