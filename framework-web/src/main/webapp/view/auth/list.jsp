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
    <simple:Script hasJquery="true" hasAngularjs="true" hasBootStrap="true" hasBootStrapModal="true"></simple:Script>
    <simple:angular hasAngularTree="true"></simple:angular>
    <script type="text/javascript" src="${pageContext.request.contextPath}/view/auth/js/auth.js"></script>
</head>
<body ng-controller="auth_controller">
<section>
    <treecontrol class="tree-classic"
                 tree-model="treedata"
                 on-selection="showSelected(node, selected, $parentNode, $index, $first, $middle, $last, $odd, $even)"
                 on-node-toggle="showToggle(node, expanded, $parentNode, $index, $first, $middle, $last, $odd, $even)">
        {{node.label}} {{node.id}}{{node.name}}
    </treecontrol>
</section>
<!--dialog-->
<div class="menu">
    <button class="btn" data-toggle="modal" href="#adddialog">添加</button>
    <%--dialog编辑菜单--%>
    <div id="adddialog" class="modal hide fade" tabindex="-1" data-width="600" data-height="400">
        <div class="modal-header">
            <h3>添加权限</h3>
        </div>
        <div class="modal-body">
            <div class="row-fluid">
                <form method="post" name="form1" role="form">
                    <div class="form-group">
                        <label>父名称</label>
                        <label>{{parent_name}}{{parentId}}</label>
                    </div>
                    <div class="form-group">
                        <label for="name">名称</label>
                        <input type="text" required="true" id="name" style="width: 100%;" placeholder="请输入名称">
                    </div>
                    <div class="form-group">
                        <label for="name">权限类型</label>
                        <select id="authType" name="authType" style="width: 100%;">
                            <option value="">请选择</option>
                            \
                            <option value="1">按钮</option>
                            <option value="2">页面</option>
                            <option value="3">菜单</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="authUrl">url:</label>
                        <input type="text" id="authUrl" name="authUrl" style="width: 100%;" placeholder="请输入url">
                    </div>
                    <div class="form-group">
                        <label for="authUrl">权限描述:</label>
                        <textarea style="width: 100%;" id="authUrl" name="authUrl" class="form-control"
                                  rows="5"></textarea>
                    </div>

            </div>
        </div>
        <div class="modal-footer">
            <button type="button" data-dismiss="modal" class="btn">Close</button>
            <input type="submit" id="save" class="btn btn-primary" value="Save changes"/>
        </div>
        </form>
    </div>
</div>
</body>
</html>
