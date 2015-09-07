<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2015/8/11
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>directive</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/angularjs/angular.js"></script>
</head>
<!--angularjs取件-->
<body ng-app="myapp" ng-init="parent1='parent123456'">
http://my.oschina.net/u/1992917/blog/406421
<b>{{parent1}}</b>
<hello></hello>
<!-- a-->
<div hello></div>
<directitle title='biaoti' desc="hehe"></directitle>

<div ng-controller="test">
    {{name}},
    {{parent1}}
    <mydec></mydec>
</div>
directive指令<br>

<form name="form2">
    <!--提交表单的属性一定要有名称啊,否则他么的没法show-->
    min,max,required.pattern:<input type="text" name="email" ng-model="email" ng-pattern="/[0-9]/" ng-trim="true"
                                    required ng-minlength="5" ng-maxlength="10"/>
    <span ng-show="form2.email.$error.required">必填!</span>
    <span ng-show="form2.email.$error.minlength">最少5位</span>
    <span ng-show="form2.email.$error.maxlength">最多10位啊!</span>
    <span ng-show="form2.email.$error.pattern">请输入数字啊!</span><br>

    <p>number:<input type="number" name="age" ng-model="age"/>
        <span ng-show="form2.age.$error.number">记得加model,请输入数字!</span>
    </p>

    <p>url:<input type="url" name="url1" ng-model="urls"/>
        <span ng-show="form2.url1.$error.url">请正确输入网址!</span>
    </p>

    <p>
        email:<input type="email" name="email1" ng-model="user.email"/>
        <Strong ng-show="form2.email1.$error.email">请正确输入邮箱!</Strong>
    </p>

    <p>
        <input type="phone" name="phone1" ng-model="phone1"/>
        <Strong ng-show="form2.phone1.$error.phone">是手机号码?</Strong>
    </p>
</form>

<p ng-controller="test1">

<form name="myForm">
    <input name="userName" type="text" ng-model="user.userName" required/>
    <input name="password" type="password" ng-model="user.password" required/>
    <input type="submit"/>
</form>
</p>


</body>
</html>
<script type="text/javascript">
    var app = angular.module("myapp", []);
    //表单的提交
    app.controller("test1", function ($scope) {
        $scope.bb = function () {
            alert(12312312);
        }
    });


    //自定义标签了，卧槽?
    app.directive("hello", function () {
        //restrict EA,是作为标签
        return {
            //E标签。A属性,标签和属性吧,EA表示即可以当属性又可以当标签
            restrict: 'EA',
            //指定的html
            template: "<div><h3>hello world</h3></div>"
            //templateUrl,通过url方式制定html
        };
    });

    app.directive("directitle", function () {
        return {
            restrict: 'EAC',
            //element就是directitle这个标签,attr就是属性
            template: function (element, attr) {
                var _html = '';
                _html += '<div>' + attr.title + ',' + attr.desc + '</div>';
                return _html;
            }
        };
    });

    app.controller('test', function ($scope) {
        $scope.name = "name1";
        $scope.parent1 = "parnet111";
    });

    app.directive('mydec', function () {
        return {
            restrict: 'EA',
            scope: false,
            template: function (element, attr) {
                return "<div>231{{name}},{{parent1}}</div>";
            }
        }
    });

</script>
