<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
    <%@ include file="header.jsp" %>
	<form method="POST" action="register">
		<table align="center">
			<tr>
				<th>Login:</th>
				<td><input type="text" name="login"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password1"></td>
			</tr>
			<tr>
				<th>Repeat Password:</th>
				<td><input type="password" name="password2"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>
	</form>
    <%@ include file="footer.jsp" %>
</body>
</html>