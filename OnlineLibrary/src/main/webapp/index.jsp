<html>

<head>
    <title>Online Library</title>
    <link rel="stylesheet" href="style.css">
</head>

<body>
    <header id="header">
        <a class="header outline" id="main" href="http://localhost:8080/OnlineLibrary/">Main page</a>
        <a class="header outline" id="logout" href="http://localhost:8080/OnlineLibrary/logout">Logout</a>
        <a class="header outline" id="register" href="http://localhost:8080/OnlineLibrary/register">Register</a>
        <a class="header outline" id="signin" href="http://localhost:8080/OnlineLibrary/signin">Sign In</a>
    </header>
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
    <footer id="footer">
        <a class="outline" id="copyright">&copy; 2016 Ihor I Great. All rights reserved</a>
    </footer>
</body>

</html>