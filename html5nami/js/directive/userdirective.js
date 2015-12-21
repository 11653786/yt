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

myapp.directive("directive", function () {
    var htmls = "<div>scope隔离:{{scope1}},<b ng-transclude>click</b></div>";
    return {
        restrict: "EA",
        transclude: true,
        //controller是这个标签对外提供的接口
        controller: function ($scope) {
            this.getScope1 = function () {
                return $scope.scope1;
            }
        },
        template: htmls,
        link: function (scope, element, attrs) {
            scope.loads = function () {
            }
        }
    }
});

//scope中=是专门用来处理对象的,@是用来专门处理字符串的
myapp.directive("direct", function () {
    return {
        restrict: 'ECMA',
        template: '<div>scope=：{{attribute.name}}</div>',
        scope: {
            attribute: '='
        }
    }
});

//@的用法这两个写法真尼玛操蛋了
myapp.directive("andone", function () {
    return {
        restrict: 'ECMA',
        template: '<div>scope@:{{scope1}}</div>',
        scope: {
            scope1: '@attribute'
        }
    }
});

myapp.directive("targetp", function () {
    return {
        restrict: "ECMA",
        template: "<div>targetp</div>",
        controller: function ($scope) {
            this.method1 = function () {
                return $scope.scope1;
            }
        },
        link: function (scope, element, attr) {
            scope.loadData = function () {
                console.log(scope.scope1);
            }
        }
    }
});

myapp.directive("target", function () {
    return {
        restrict: "ECMA",
        template: "<div>target</div>",
        require: "?^targetp",
        link: function (scope, element, attr, targetp) {
        }
    }
});




