<%--
  Created by IntelliJ IDEA.
  User: yt
  Date: 2016/3/1 0001
  Time: 8:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/top.jsp" %>
<html ng-app="auth">
<head>
    <title>权限管理</title>
    <simple:Script hasJquery="true" hasAngularjs="true" hasEasyUi="true" hasBootStrap="true"
                   hasZtree="false"></simple:Script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/view/auth/js/auth.js"></script>
</head>
<body ng-controller="auth_controller">
{{name}}
</body>
</html>
