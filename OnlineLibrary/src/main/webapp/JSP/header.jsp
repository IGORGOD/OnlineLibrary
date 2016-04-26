<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Enumeration"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="style.css">
</head>
<body>
	<header id="header">
		<%! private boolean isLogin = false;%>
		<%Enumeration<String> names = session.getAttributeNames();
		while(names.hasMoreElements())
			if(names.nextElement().equals("isLogin")){
				isLogin = Boolean.getBoolean(session.getAttribute("isLogin").toString());
				break;
			}
		%>
		<a class="header outline" id="main" href="http://localhost:8080/OnlineLibrary/">Main page</a>
		<%if(isLogin){%>
			<a class="header outline" id="logout" href="http://localhost:8080/OnlineLibrary/logout">Logout</a>
		<%}else {%>
			<a class="header outline" id="register" href="http://localhost:8080/OnlineLibrary/register">Register</a>
			<a class="header outline" id="signin" href="http://localhost:8080/OnlineLibrary/signin">Sign In</a> 
		<%}%>
	</header>
</body>
</html>