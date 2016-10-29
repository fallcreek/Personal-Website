<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fallcreek-leetcode</title>
<link href="css/font.css" type="text/css" rel="stylesheet">
<link href="css/base.css" type="text/css" rel="stylesheet">
<link href="css/leetcode.css" type="text/css" rel="stylesheet">

<script src="js/jquery-1.4.3.min.js"></script>
<script src="js/leetcode.js"></script>

</head>
<body>

<%@ include file="head.jsp" %>

<div id="wrap-content">
<div id="title-content">Contents</div>

<div id="wrap-difficulty">
<div id="title-difficulty">Difficulty</div>

<select id="select-difficulty">
  <option value="All" selected="selected">All</option>
  <option value="Easy">Easy</option>
  <option value="Medium">Medium</option>
  <option value="Hard">Hard</option>
</select>
</div>


<div id="wrap-tag">
<div id="title-tag">Tag</div>
	
<select id="select-tag">
	<option value="All" selected="selected">All</option>
	<s:iterator id="tagList" status="i"  value="tagList">  
		<option value="<s:property value="name"/>"><s:property value="name"/></option>
	</s:iterator>
</select>
</div>

<div id="wrap-item">

<s:iterator value="article" status="i">
<div class="article-line">
	<div class="article-id"><s:property value="id"/></div>
	<div class="article-title"><s:property value="title"/></div>
	<div class="article-difficulty"><s:property value="difficulty"/></div>
	<div class="article-tag"><s:property value="tag"/></div>
</div>
</s:iterator>
</div>
</div>

<div id="wrap-showwindow">
<div id="title-content">Recent Articles</div>

<div id="wrap-item">



</div>

</div>


</body>
</html>