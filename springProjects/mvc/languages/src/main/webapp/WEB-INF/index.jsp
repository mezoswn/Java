<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<h1>All Languages</h1>
<br><br>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Creator</th>
        <th>Version</th>
        <th>action</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${allLanguages}" var="language">
        <tr>
            <td><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
            <td><c:out value="${language.creator}"/></td>
            <td><c:out value="${language.currentVersion}"/></td>
            <td><form:form action="/languages/${language.id}" method="DELETE" class="d">
                	<input type="submit" value="Delete">
                </form:form> |
                <a href="/languages/edit/${language.id}">Edit</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<%@ page isErrorPage="true" %>
<form:form action="/languages" method="post" modelAttribute="language">
    <p>
        <form:label path="name">Name</form:label>
        <form:errors path="name"/>
        <form:input path="name"/>
    </p>
    <p>
        <form:label path="creator">Creator</form:label>
        <form:errors path="creator"/>
        <form:textarea path="creator"/>
    </p>
    <p>
        <form:label path="currentVersion">Version</form:label>
        <form:errors path="currentVersion"/>
        <form:input path="currentVersion"/>
    </p>
    <br><br>
    <input type="submit" value="Submit"/>
</form:form>
   
</body>
</html>