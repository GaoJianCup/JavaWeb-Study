<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Page</title>
</head>
<body>
	<form action="registerServlet" method="post">
	
	<table>
		<caption>User Register</caption>
		<tr><td>Username:</td>
			<td><input type="text" name="username" style="width: 156px; "></td></tr>
		<tr><td>Password:</td>
			<td><input type="password" name="password" style="width: 156px; "></td></tr>
	</table><br>
	<input type="submit" value="regis">
	<input type="reset" value="reset">
	</form>
</body>
</html>