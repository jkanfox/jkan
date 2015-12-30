<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="Create Group"/>

<div class="container">
	<form action="/groups/new" method="post">
	  <fieldset class="form-group">
	    <label for="title">名称</label>
	    <input class="form-control" id="title" name="title" placeholder="标题">
	    <small class="text-muted">请输入一个唯一的名称</small>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="description">描述</label>
	    <input class="form-control" id="description" name="description" placeholder="描述">
	    <small class="text-muted">请输入简短的描述内容</small>
	  </fieldset>
	  <button type="submit" class="btn btn-primary">确定</button>
	</form>
</div>

<my:footer/>