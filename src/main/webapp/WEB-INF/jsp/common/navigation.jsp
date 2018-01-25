<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head>
    <title>Todo's for ${name}</title>
    <link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css"
          rel="stylesheet">
</head>

<body>

<nav role="navigation" class="navbar navbar-default">
    <div class="">
        <a href="http://www.in28minutes.com" class="navbar-brand">in28Minutes</a>
    </div>
    <div class="navbar-collapse">
        <ul class="nav navbar-nav">
            <li class="active"><a href="/">Home</a></li>
            <li><a href="/list-todos">Todos</a></li>

        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li class="active"><a href="/logout">logout</a></li>


        </ul>
    </div>
</nav>

</body>

</html>