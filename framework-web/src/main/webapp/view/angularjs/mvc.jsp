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
    <title>Mvc</title>
    <script type="text/javascript"
            src="${pageContext.request.contextPath}/resource/js/angularjs/angular-1.3.0.js"></script>
    <style type="text/css">
        .test1 {
            font-size: 20px;
        }
    </style>
</head>
<body ng-app>
<div ng-controller="controller1">
    {{name1}},{{name2}}
    <hr>
    //ng-repeat,和foreach差不多
    <div ng-repeat="foreach in foreachs">
        {{foreach}} in {{name1}},{{name2}}
    </div>
</div>
<hr>
<div ng-controller="controller2">
    {{count}}
</div>
</body>
</html>
<script type="text/javascript">
    //ng-app不写名称
    function controller1($scope, $rootScope) {
        $scope.name1 = "name11111";
        $rootScope.name2 = "name2222";
        $scope.foreachs = ['array1', 'array2', 'array3', 'array4', 'array5', 'array6', 'array7'];
    }
    //写法2
    function controller2($scope, $rootScope) {
        $scope.count=99;

    }
    //angulrjs切分模块!和互相依赖,就是依赖注入

</script>
