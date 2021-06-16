<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Counter Page</title>
        <link rel="stylesheet" type="text/css" href="css/style.css">
        <script type="text/javascript" src="js/app.js"></script>
</head>
<body>

<p>You have visited <a href="http://localhost:8080/"> http://localhost:8080/ </a> <c:out value="${count}"/> times.</p>

<div class="btn-group" style="width:100%">
<a href="../"><button type="button" class="btn btn-primary">Test another Visit?</button></a>
</div>
</body>
</html>