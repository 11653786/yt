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
    <simple:Script hasJquery="true" hasAngularjs="true" hasBootStrap="true" hasBootStrapModal="true" ></simple:Script>
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
<!--dialog-->
<div class="menu">
    <button class="btn" data-toggle="modal" href="#dialog">添加</button>
    <div id="dialog" class="modal hide fade" tabindex="-1" data-width="760" data-height="500" >
        <div class="modal-header">
            <h3>title</h3>
        </div>
        <div class="modal-body">
            <div class="row-fluid">
                <div class="span6">
                    <h4>Some Input</h4>
                    <p><input type="text" class="span12" /></p>
                </div>
                <div class="span6">
                    <h4>Some More Input</h4>
                    <p><input type="text" class="span12" /></p>
                </div>
            </div>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn">Close</button>
            <button type="button" class="btn btn-primary">Save changes</button>
        </div>
    </div>
</div>

</body>
</html>
