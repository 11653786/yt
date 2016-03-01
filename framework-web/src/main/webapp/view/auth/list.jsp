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
    <script src="${pageContext.request.contextPath}/resource/js/jquery/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/angularjs/angular.1.2.29.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/angular_tree/angular-tree-control.js"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/angular_tree/css/tree-control.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resource/css/angular_tree/css/tree-control-attribute.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/view/auth/js/auth.js"></script>
</head>
<body >
<section  ng-controller="auth_controller">
    <treecontrol class="tree-classic"
                 tree-model="treedata"
                 on-selection="showSelected(node, selected, $parentNode, $index, $first, $middle, $last, $odd, $even)"
                 on-node-toggle="showToggle(node, expanded, $parentNode, $index, $first, $middle, $last, $odd, $even)">
        label: {{node.label}} ({{node.id}})
    </treecontrol>
</section>
<script>





</script>

</body>
</html>
