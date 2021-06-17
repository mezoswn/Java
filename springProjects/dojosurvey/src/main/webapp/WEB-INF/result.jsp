<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Result Page</title>
<link rel="stylesheet" type="text/css" href="css/result.css">
</head>
<body>
 <div>
        <h1>Submitted info</h1>
        <p class="dotted">Name : <c:out value="${name}"/></p>
        <p class="dotted">Favorite Language : <c:out value="${lang}"/></p>
        <p class="dotted">Location : <c:out value="${location}"/></p>
        <p class="dotted">Comment : <c:out value="${comment}"/></p>
    </div>
    <form>
        <a href="http://localhost:8080/"><input type="button" value="Go Back" ></a>
    </form>
</body>
</html>