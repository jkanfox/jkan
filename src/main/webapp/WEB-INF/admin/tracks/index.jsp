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
    url:'/admin/tracks/list',
    fitColumns: true,
    idField: "id",
    rownumbers: true,
    pagination: true,
    columns:[[
        {field:'exception',title:'异常类型',width:100},
        {field:'object',title:'异常对象',width:100},
        {field:'created',title:'发生时间',width:100}
    ]]
});
</script>