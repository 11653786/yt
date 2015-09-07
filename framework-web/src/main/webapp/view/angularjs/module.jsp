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
  <head >
    <title>模块化</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/angularjs/angular.js"></script>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/style.css">--%>
    <%--<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/style.css">--%>
    <style type="text/css">
      .test1{
        font-size: 20px;
      }
    </style>
  </head>
  <!--angularjs取件-->
  <body ng-app="myapp">
<!--angularjs el表达式-->
  <div ng-controller="testController">
  <input type="text" name="username1" ng-model="username" /><br>
  </div>
  </div>



  </body>
</html>
<script type="text/javascript">
  //初始化angularjs
  var app=angular.module('myapp',[]);
  app.controller('testController',['$scope',function($scope){
      //给testController中的model复制
        $scope.username='hello,angular!';
  }]);
</script>
