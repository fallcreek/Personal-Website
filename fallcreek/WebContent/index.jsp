<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
     import="hibernate.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fallcreek</title>
<link href="css/font.css" type="text/css" rel="stylesheet">
<link href="css/base.css" type="text/css" rel="stylesheet">

<!-- <script src="js/jquery-1.4.3.min.js"></script>
<script src="js/hibernateinit.js" type="text/javascript"></script> -->
</head>
<body>

<div id="logo">Zhengyao Li</div>
<div id="nav"><img alt="nav" src="img/nav.png" ></div>
<div id="menu">
<div class="menu_item"><a href="<%=request.getContextPath()%>/">Home</a></div>
<div class="menu_item"><a href="leetcode">LeetCode</a></div>
<div class="menu_item"><a href="blog">Blog</a></div>
<div class="menu_item"><a href="contact">Contact</a></div>
</div>

<%-- <% 
hibernateinit h = new hibernateinit();
h.init();
%> --%>

</body>
</html>