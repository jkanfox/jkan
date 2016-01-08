<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="zh-CN">
<head>
<meta charset="utf-8">
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<link rel="shortcut icon" href="/favicon.ico">

<title>${title}</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="/humans.txt">

<link rel="stylesheet" href="/commons/css/bootstrap.min.css">
<link rel="stylesheet" href="/js/jquery-easyui-1.4.4/themes/bootstrap/easyui.css">
<link rel="stylesheet" href="/js/jquery-easyui-1.4.4/themes/icon.css">
<script src="/js/jquery-easyui-1.4.4/jquery.min.js"></script>
<script src="/js/jquery-easyui-1.4.4/jquery.easyui.min.js"></script>
<script src="/js/jquery-easyui-1.4.4/locale/easyui-lang-zh_CN.js"></script>
</head>
<body>

<nav class="navbar navbar-light bg-faded" style="margin-bottom: 20px;">
  <a class="navbar-brand" href="/admin">MEISHER ADMIN</a>
  <ul class="nav navbar-nav">
    <li class="nav-item active">
      <a class="nav-link" href="/admin/users">用户管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/organizations">组织机构</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/roles">角色管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/permissions">权限管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/groups">类别管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/labels">标签管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/platforms">平台管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/posts">链接管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/shares">分享管理</a>
    </li>
    <li class="nav-item">
      <a class="nav-link" href="/admin/tracks">异常追踪</a>
    </li>
  </ul>
  <form class="form-inline navbar-form pull-right">
    <input class="form-control" type="text" placeholder="Search">
    <button class="btn btn-success-outline" type="submit">Search</button>
  </form>
</nav>
