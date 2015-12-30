<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="Posts"/>
<div class="container clearfix">
	<c:if test="${c.extra.flag}">
	<h2 class="pull-left">${c.extra.group.title}</h2>
	</c:if>
	<a class="btn btn-primary-outline pull-right" href="/posts/new">ADD POSTS</a>
</div>
<div class="container">
	<ul class="list-unstyled">
		<c:forEach items="${c.result.content}" var="row">
		<li><a href="${row.url}" target="_blank">${row.title}</a></li>
		</c:forEach>
	</ul>
</div>
<my:footer/>