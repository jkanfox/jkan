<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="USER LOGIN"/>
<div class="container">

	<h3>USER LOGIN</h3>

	<form action="/users/login" method="post">
	  <fieldset class="form-group">
	    <label for="name">用户名 / 邮箱</label>
	    <input type="text" class="form-control" id="name" name="name" placeholder="用户名 / 邮箱">
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="password">密码</label>
	    <input type="password" class="form-control" id="password" name="password" placeholder="6-16位长度">
	  </fieldset>
	  
	  <button type="submit" class="btn btn-primary">登录</button>
	</form>
</div>
<my:footer/>