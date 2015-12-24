<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="keywords" content="">
    <title>添加分组</title>
</head>
<body>
	<form action="/groups/new" method="post">
	<ul>
		<li>
			<label>名称</label>
			<input name="title">
		</li>
		<li>
			<label>描述</label>
			<input name="description">
		</li>
		<li>
			<input type="submit">
		</li>
	</ul>
	</form>
	
</body>
</html>