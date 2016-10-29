<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fallcreek-upload</title>
</head>
<body>

<form action="update" method="post">
	
	
	
</form>

<form action="update" enctype="multipart/form-data" method="post">			
		password:<input type="password" name="password"><br><br>
		
	
		id:<input type="text" name="id"><br>
		title:<input type="text" name="title"><br>
		difficulty:<input type="text" name="difficulty"><br>
		tag:<input type="text" name="tag"><br>
		date:<input type="text" name="date"><br><br>
		
		html:<s:file name="html" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		algorithm1:<s:file name="algorithm1" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		runtime1:<s:file name="runtime1" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		algorithm2:<s:file name="algorithm2" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		runtime2:<s:file name="runtime2" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		algorithm3:<s:file name="algorithm3" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		runtime3:<s:file name="runtime3" label="" id="uploadBtn1" cssClass="uploadBtn" ></s:file><br>
		
		<s:submit value="上传" id="submitBtn1" cssClass="submitBtn"/>
	</form>


</body>
</html>