<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index Page</title>
	<link rel="stylesheet" type="text/css" href="css/index.css">
	
</head>
<body>
<div class="center">
<p style="color:red"><c:out value="${error}"/></p>
<br><br>
<h2>What is the code?!</h2>
<form action="/code" method="post">
<input type="text" name="try">
<button type="submit">Try the Code</button>
</form>
</div>

</body>
</html>