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
    <title>Posts List</title>
</head>
<body>
	<c:if test="${c.extra.flag}">
	<h2>${c.extra.group.title}</h2>
	</c:if>

	<ul>
		<c:forEach items="${c.result.content}" var="row">
		<li><label>${row.id}：</label><a href="${row.url}" target="_blank">${row.title}</a></li>
		</c:forEach>
	</ul>
</body>
</html>