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
    url:'/admin/groups/list',
    fitColumns: true,
    idField: "id",
    rownumbers: true,
    pagination: true,
    columns:[[
        {field:'name',title:'名称',width:100},
        {field:'title',title:'标题',width:100},
        {field:'description',title:'描述',width:100},
        {field:'state',title:'状态',width:100},
        {field:'stars',title:'星标记',width:100},
        {field:'count',title:'计数',width:100},
        {field:'parent',title:'父类别',width:100},
        {field:'parentIds',title:'类别树',width:100},
        {field:'created',title:'创建时间',width:100},
        {field:'lastModified',title:'最后更新时间',width:100},
        {field:'createBy',title:'创建用户',width:100},
        {field:'auditBy',title:'审核用户',width:100},
        {field:'audit_remark',title:'审核意见',width:100}
    ]]
});
</script>