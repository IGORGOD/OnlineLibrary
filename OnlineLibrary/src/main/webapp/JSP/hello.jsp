<html>
<head>
<title>My First JSP</title>
<link rel="stylesheet" href="style.css">
</head>

<body>
	<h1>
		<%
			String name = request.getParameter("name");
		%>
		Hello,
		<%
			if (name == null || name.length() == 0) {
		%>
		world!
		<%
			} else {
		%>
		<%=name%>!
		<%
			}
		%>
	</h1>
</body>
</html>