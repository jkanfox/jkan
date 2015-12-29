<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="Insert you title"/>

<div class="container">
	<form action="/groups/${c.result.id}/edit" method="post">
	  <input type="hidden" name="id" value="${c.result.id}">
	  <input type="hidden" name="name" value="${c.result.name}">
	  <input type="hidden" name="created" value="${c.result.created}">
	  <input type="hidden" name="lastModified" value="${c.result.lastModified}">
	  <fieldset class="form-group">
	    <label for="title">名称</label>
	    <input class="form-control" id="title" placeholder="标题" name="title" value="${c.result.title}">
	    <small class="text-muted">请输入友好的显示标题</small>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="description">描述</label>
	    <input class="form-control" id="description" placeholder="描述" name="description" value="${c.result.description}">
	    <small class="text-muted">请输入简短的描述内容</small>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="state">状态</label>
	    <input class="form-control" id="state" placeholder="1" name="state" value="${c.result.state}">
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="position">排序</label>
	    <input class="form-control" id="position" placeholder="排序" name="position" value="${c.result.position}">
	  </fieldset>
	 
	  <button type="submit" class="btn btn-primary">确定</button>
	</form>
</div>

<my:footer/>