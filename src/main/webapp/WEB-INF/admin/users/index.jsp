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
    url:'/admin/users/list',
    fitColumns: true,
    idField: "id",
    rownumbers: true,
    pagination: true,
    columns:[[
        {field:'name',title:'用户名',width:100},
        {field:'title',title:'昵称',width:100},
        {field:'description',title:'描述',width:100},
        {field:'password',title:'密码',width:100},
        {field:'accessKey',title:'密钥',width:100},
        {field:'email',title:'邮箱',width:100},
        {field:'isEmailSet',title:'是否验证',width:100},
        {field:'state',title:'状态',width:100},
        {field:'created',title:'创建时间',width:100},
        {field:'lastModified',title:'最后更新时间',width:100}
    ]]
});
</script>