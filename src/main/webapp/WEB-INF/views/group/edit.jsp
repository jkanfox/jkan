<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>编辑分组</title>
</head>
<body>
<form action="/groups/${c.result.id}/edit" method="post">
	<input type="hidden" name="id" value="${c.result.id}">
	<input type="hidden" name="name" value="${c.result.name}">
	<input type="hidden" name="created" value="${c.result.created}">
	<input type="hidden" name="lastModified" value="${c.result.lastModified}">
	<ul>
		<li>
			<label>名称</label>
			<input name="title" value="${c.result.title}">
		</li>
		<li>
			<label>描述</label>
			<input name="description" value="${c.result.description}">
		</li>
		<li>
			<label>状态</label>
			<input name="state" value="${c.result.state}">
		</li>
		<li>
			<label>排序</label>
			<input name="position" value="${c.result.position}">
		</li>
		<li>
			<input type="submit">
		</li>
	</ul>
	</form>
</body>
</html>