<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Leave A Message</title>
	<%
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect("login.jsp");
		}
	 %>
</head>
<body>
	<form action="addMessage" method="post">
	<table border="1">
		<caption>Message Information</caption>
		<tr><td>Title</td>
			<td><input type="text" name="title" style="width: 309px; "></td></tr>
		<tr><td>Password:</td>
			<td><textarea name="content" namerows="5" cols="35" style="height: 93px; width: 309px; "></textarea> </td></tr>
	</table><br>
	<input type="submit" value="submit">
	<input type="reset" value="reset">
	</form>
</body>
</html>