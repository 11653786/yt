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
    <title>form提交</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery/jquery.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/angularjs/angular.js"></script>
    <style type="text/css">
        body{
            font-size:12px;
        }
        .test1 {
            font-size: 20px;
        }
    </style>
</head>
<!--angularjs取件-->
<body ng-app="myapp">
<input type="hidden" value="${pageContext.request.contextPath}" id="path" ng-model="path" />
<div ng-controller="mycontroller" ng-submit="sum()">
    <form name="form1" ng-submit>
        <p>
        <input type="text" name="username" ng-model="user.username" required ng-minlength="6" />
        <span ng-show="form1.username.$error.required">用户名必填!</span>
            <span ng-show="form1.username.$error.minlength">最少6位!</span>
        </p>
        <p>
        <input type="email" name="emails" ng-model="user.email" required  />
        <span ng-show="form1.emails.$error.required">请输入邮箱!</span>
        <span ng-show="form1.emails.$error.email">输入的不是邮箱!</span>
        </p>
        <input type="submit"      value="提交"/>

    </form>

    <div ng-controller="AngularjsF">
        <input type="button" value="click" ng-click="add1()" />
    </div>
</div>


</body>
</html>
<script type="text/javascript">
function AngularjsF($scope){
        $scope.add1=function(){
            alert(555);
        }
}

    //项目路径
    var path=$("#path").val();
    //初始化angularjs
    var app = angular.module('myapp', []);



    function emailRouteConfig($routeProvider) {
        $routeProvider.
                when('/', {
                    controller: ListController,
                    templateUrl: 'list.html'
                }).
                when('/view/:id', { //在id前面加一个冒号，从而制订了一个参数化URL
                    controller: DetailController,
                    templateUrl: 'detail.html'
                }).
                otherwise({
                    redirectTo: '/'
                });
    }

    app.config(emailRouteConfig);//配置我们的路由



    app.controller("mycontroller", function ($scope,$http) {
    $scope.sum=function(){
        // $scope.user={username:"1",email:"11@qqa"};
        var user = {username:$scope.user.username,email:$scope.user.email};
        //提交表单
        $http({method:'post',url:path+'/api/user/form.html',params:user}).
                success(function(response) {
                            alert(response);
                  });
    }

    });

</script>
