<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2015/9/8
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>list页面</title>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/jquery/jquery.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/angularjs/angular.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/angularjs/angular-animate.js"></script>
  <script type="text/javascript" src="${pageContext.request.contextPath}/resource/js/angularjs/angular-ui-router.js"></script>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resource/css/bootstrap/bootstrap.css" >
</head>
<body ng-app="myapp" >
<input type="hidden" id="path" value="${pageContext.request.contextPath}" />
<div style="width:400px;float:left;">
  <ul class="list-group" style="width:200px;">
    <li class="list-group-item">首页</li>
    <li class="list-group-item">list页面</li>
    <li class="list-group-item">呵呵</li>
    <li class="list-group-item">空白页</li>
    <li class="list-group-item">呵呵</li>
  </ul>

</div>
<div style="float:left;">
<div ng-controller="userlist">
  <table class="table table-striped table-bordered row">
    <thead>
    <tr>
      <th class="col-md-1">id</th>
      <th class="col-md-1">名称</th>
    </tr>
    </thead>
    <tbody>
    <tr>
      <td>Sachin</td>
      <td>Mumbai</td>
    </tr>
    </tbody>
  </table>
</div>
</div>
</body>
</html>
<script type="text/javascript">
var myapp=angular.module('myapp',[]);
  myapp.controller('userlist',function($scope,myservice,$http){
    myservice.getPages();
  });
//顶一个myfactory



//创建service的几种方法,service 的第一种使用方法,
// 1.创建一个factory对象
// 2.给这个对象添加属性,
// 3.传入到controller中去
// 4.生存周期应该是和controller同时销毁
//5.我把他做成了dao
//6.对象已经写好了一样
myapp.factory('myfactory',function($http){
  var list=[1,2,3,4,5];
  var service={};
  service.getList=function(){
    return list;
  }
  return service;
});
//第二种方法service,
// 可以在所有的controller中使用
//生命周期很长
//new 出来得都要用this
//这里面把myfctory层当成了dao层引入
myapp.service("myservice",function(myfactory,$http){
  this.obj={name1:"name11",name2:"name22",name3:"name33",name4:"name44"};
  this.list=myfactory.getList();
  this.pageSize=this.list.length;
  this.pages={obj:this.obj,list:this.list,pageSize:this.pageSize};
  this.getPages=function(){
    $http({method:'post',url:'/api/user/datagrid.do',params:{page:1,pageSize:10}}).
            success(function(response) {
              alert(response);
            }).error(function(){
              alert(4);
            });
  }

});




</script>
