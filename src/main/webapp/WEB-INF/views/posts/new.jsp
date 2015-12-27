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
    <title>添加Posts</title>
</head>
<body>
	<form action="/posts/fetch" method="get">
	<ul>
		<li>
			<label>链接</label>
			<input name="url">
		</li>
		<li>
			<input type="submit">
		</li>
	</ul>
	</form>
</body>
</html>