<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:include page="../header.jsp" />
  <div class="container-fluid">
  	<table id="dg"></table>
  </div>
</body>
</html>
<script>
var userDataGrid = $('#dg').datagrid({
    url:'/admin/permissions/list',
    fitColumns: true,
    idField: "id",
    rownumbers: true,
    pagination: true,
    columns:[[
        {field:'name',title:'名称',width:100},
        {field:'title',title:'标题',width:100},
        {field:'description',title:'描述',width:100},
        {field:'type',title:'类型',width:100},
        {field:'url',title:'链接',width:100},
        {field:'parent',title:'父节点',width:100},
        {field:'parentIds',title:'节点树',width:100},
        {field:'permission',title:'权限',width:100},
        {field:'state',title:'状态',width:100},
        {field:'created',title:'创建时间',width:100},
        {field:'lastModified',title:'最后更新时间',width:100},
        {field:'createBy',title:'创建用户',width:100},
        {field:'auditBy',title:'审核用户',width:100},
        {field:'auditRemark',title:'审核意见',width:100}
    ]]
});
</script>