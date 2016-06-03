<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" import="java.util.Enumeration"%>
	<header id="header">
		<%! private boolean isLogin = false;%>
		<%Enumeration<String> names = request.getAttributeNames();
		String str;
		while(names.hasMoreElements()){
			str = names.nextElement().toString();
			if(str.startsWith("isLogin")){
				isLogin = true;
				break;
			}
		}
		System.out.println(isLogin);
		%>
		<a class="header outline" id="main" href="http://localhost:8080/OnlineLibrary/">Main page</a>
		<%if(isLogin){%>
			<a class="header outline" id="logout" href="http://localhost:8080/OnlineLibrary/logout">Logout</a>
		<%}else {%>
			<a class="header outline" id="register" href="http://localhost:8080/OnlineLibrary/register">Register</a>
			<a class="header outline" id="signin" href="http://localhost:8080/OnlineLibrary/signin">Sign In</a> 
		<%}%>
	</header>