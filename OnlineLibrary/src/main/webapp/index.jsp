<html>

<head>
    <title>Online Library</title>
    <link rel="stylesheet" href="JSP/style.css">
</head>

<body>
    <%@ include file="/JSP/header.jsp" %>
    <form class="panel" id="search" method="GET" action="SearchServlet">
        <div>
            <a>Author</a>
            <input type="text">
        </div>
        <div>
            <a>Title</a>
            <input type="text">
        </div>
        <div>
            <a>Genre</a>
            <input type="text">
        </div>
        <div id="submit">
            <input type="submit" value="Filter">
        </div>
    </form>
    <%@ include file="/JSP/footer.jsp" %>
</body>

</html>