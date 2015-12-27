<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>分组列表</title>
</head>
<body>
	<h4><a href="/groups/new">ADD GROUPS</a></h4>

	<ul>
		<c:forEach items="${c.result.content}" var="row">
		<li><a href="/groups/${row.id}/posts">${row.title}</a></li>
		</c:forEach>
	</ul>
</body>
</html>