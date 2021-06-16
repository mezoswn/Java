<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Date Display</title>
	<link rel="stylesheet" type="text/css" href="css/date.css">
    <script type="text/javascript" src="js/date.js"></script>
</head>
<body>
<h1>The Date for Today is</h1>
<div class="center">
<h2><c:out value="${theDate}"/></h2>
</div>
<br><br><br>
<div class="btn-group" style="width:100%">
<a href="../"><button type="button" style="width:100%" class="btn btn-primary">Home</button></a>

</div>
</body>
</html>