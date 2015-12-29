<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://meisher.com/jkan/taglib" prefix="my" %>
<my:header title="Insert you title"/>

<div class="container">
	<form action="/posts/fetch" method="get">
	  <fieldset class="form-group">
	    <label for="url">链接</label>
	    <input class="form-control" id="url" name="url" placeholder="http(s)://">
	    <small class="text-muted">请输入一个有效的URL链接地址.</small>
	  </fieldset>
	  <button type="submit" class="btn btn-primary">确定</button>
	</form>
</div>
<my:footer/>