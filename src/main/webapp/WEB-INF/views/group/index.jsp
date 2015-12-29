<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="Insert you title"/>

<div class="container clearfix">
	<a class="btn btn-primary-outline pull-right" href="/groups/new">ADD GROUPS</a>
</div>
	
<div class="container">
	<ol>
		<c:forEach items="${c.result.content}" var="row">
		<li><a href="/groups/${row.id}/posts">${row.title}</a></li>
		</c:forEach>
	</ol>
</div>

<my:footer/>