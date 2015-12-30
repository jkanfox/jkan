<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="设置"/>
<div class="container">
	<h3>设置</h3>

	<form action="/user/${id}/settings" method="post">
	  <input type="hidden" name="id"  value="${c.result.id}">
	  <input type="hidden" name="isEmailSet"  value="${c.result.isEmailSet}">
	  <input type="hidden" name="salt"  value="${c.result.salt}">
	  <input type="hidden" name="created"  value="${c.result.created}">
	  <input type="hidden" name="lastModified"  value="${c.result.lastModified}">
	  <input type="hidden" name="createIp"  value="${c.result.createIp}">
	  <input type="hidden" name="password"  value="${c.result.password}">
	  
	  <fieldset class="form-group">
	    <label for="name">用户名</label>
	    <input type="text" class="form-control" id="name" name="name" placeholder="用户名" value="${c.result.name}">
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="title">昵称</label>
	    <input type="text" class="form-control" id="title" name="title" placeholder="昵称" value="${c.result.title}">
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="email">邮箱</label>
	    <input type="email" class="form-control" id="email" name="email" placeholder="邮箱" value="${c.result.email}">
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="description">自我介绍</label>
	    <input class="form-control" id="description" name="description" placeholder="一句话介绍自己" value="${c.result.description}">
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="state">状态</label>
	    <input class="form-control" id="state" name="state" value="${c.result.state}">
	  </fieldset>
	  
	  <button type="submit" class="btn btn-primary">确定</button>
	</form>
</div>
<my:footer/>