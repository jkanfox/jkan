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
    <title>编辑Posts</title>
</head>
<body>
	<form action="/posts/${c.result.id}/edit" method="post">
	<input type="hidden" name="id" value="${c.result.id}">
	<input type="hidden" name="name" value="${c.result.name}">
	<input type="hidden" name="created" value="${c.result.created}">
	<input type="hidden" name="lastModified" value="${c.result.lastModified}">
	<ul>
		<li>
			<label>链接</label>
			<input name="url" value="${c.result.url}">
		</li>
		<li>
			<label>名称</label>
			<input name="title" value="${c.result.title}">
		</li>
		<li>
			<label>描述</label>
			<input name="description" value="${c.result.description}">
		</li>
		<li>
			<label>标签</label>
			<input name="tags" value="${c.result.tags}">
		</li>
		<li>
			<label>状态</label>
			<input name="state" value="${c.result.state}">
		</li>
		<li>
			<label>分组</label>
			<select name="group.id">
				<c:forEach items="${c.extra.groups.content}" var="row">
				<option value="${row.id}" <c:if test="${row.id == c.result.group.id}">selected</c:if>>${row.title}</option>
				</c:forEach>
			</select>
		</li>
		<li>
			<input type="submit">
		</li>
	</ul>
	</form>
</body>
</html>