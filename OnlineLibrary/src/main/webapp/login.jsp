<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<form method="POST" action="signin">
		<table align="center">
			<tr>
				<th>Login:</th>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Sign In"></td>
			</tr>
		</table>
	</form>
</body>
</html>