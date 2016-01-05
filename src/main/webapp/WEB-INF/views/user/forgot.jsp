<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="找回密码"/>
<div class="container">
	<h3>找回密码</h3>
	<form action="/users/forgot" method="post">
	  <fieldset class="form-group">
	    <label for="name">邮箱</label>
	    <input type="email" class="form-control" id="email" name="email" placeholder="邮箱">
	  </fieldset>
	  <button type="submit" class="btn btn-primary">发送邮件</button>
	</form>
</div>
<my:footer/>