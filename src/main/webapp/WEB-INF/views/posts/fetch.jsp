<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="Insert you title"/>

<div class="container">
	<form action="/posts/new" method="post">
	  <fieldset class="form-group">
	    <label for="url">链接地址</label>
	    <input class="form-control" id="url" placeholder="http(s)://" name="url" value="${c.extra.info.url}" readonly>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="title">标题</label>
	    <input class="form-control" id="title" placeholder="标题" name="title" value="${c.extra.info.title}">
	    <small class="text-muted">请输入友好的显示标题</small>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="description">描述</label>
	    <input class="form-control" id="description" placeholder="描述" name="description" value="${c.extra.info.description}">
	    <small class="text-muted">请输入简短的描述内容</small>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="tags">标签</label>
	    <input class="form-control" id="tags" placeholder="标签" name="tags" value="${c.extra.info.tags}">
	    <small class="text-muted">标签，使用英文逗号(,)分隔</small>
	  </fieldset>
	  <fieldset class="form-group">
	    <label for="groupId">选择类别</label>
	    <select class="form-control" id="groupId" name="groupId">
	      <c:forEach items="${c.result.content}" var="row">
			<option value="${row.id}">${row.title}</option>
		  </c:forEach>
	    </select>
	  </fieldset>
	 
	  <button type="submit" class="btn btn-primary">确定</button>
	</form>
</div>

<my:footer/>