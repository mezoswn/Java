<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/info1.css">
</head>
<body>
<a href="/">Dashboard</a>

<h1><c:out value="${language.name}"/></h1>
<h1><c:out value="${language.creator}"/></h1>
<h1><c:out value="${language.currentVersion}"/></h1>
<p><a href="/languages/edit/${language.id}">edit</a></p>
<form:form action="/languages/${language.id}" method="DELETE" >
    <input type="submit" value="Delete"/>
</form:form>
</body>
</html>