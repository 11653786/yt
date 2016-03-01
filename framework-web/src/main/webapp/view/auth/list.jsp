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
    <simple:Script hasJquery="true" hasAngularjs="true"></simple:Script>
    <simple:angular hasAngularTree="true"></simple:angular>
    <script type="text/javascript" src="${pageContext.request.contextPath}/view/auth/js/auth.js"></script>
</head>
<body>
<section ng-controller="auth_controller">
    <treecontrol class="tree-classic"
                 tree-model="treedata"
                 on-selection="showSelected(node, selected, $parentNode, $index, $first, $middle, $last, $odd, $even)"
                 on-node-toggle="showToggle(node, expanded, $parentNode, $index, $first, $middle, $last, $odd, $even)">
        {{node.label}} {{node.id}}{{node.name}}
    </treecontrol>
</section>
<script>


</script>

</body>
</html>
