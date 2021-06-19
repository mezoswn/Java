<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninja Gold Game</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
	<script type="text/javascript" src="js/app.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function(){
        var scrolldown = document.getElementById('log');
        scrolldown.scrollTop = scrolldown.scrollHeight;
            }
        });
    </script>
</head>
<body>
<main>
        <div class="top">
            <label for="gold">Your Gold</label>
            <input value= <c:out value="${total}"/> readonly>
        </div>
        <div class="forms">
            <form method="post" action="/process_money">
                <h1>Farm</h1>
                <h4>Earns 10-20 golds</h4>
                <input type="hidden" name="gold" value="farm">
                <button type="submit">Find Golds</button>
            </form>
            <form method="post" action="/process_money">
                <h1>Cave</h1>
                <h4>Earns 5-10 golds</h4>
                <input type="hidden" name="gold" value="cave">
                <button type="submit">Find Golds</button>
            </form>
            <form method="post" action="/process_money">
                <h1>House</h1>
                <h4>Earns 2-5 golds</h4>
                <input type="hidden" name="gold" value="house">
                <button type="submit">Find Golds</button>
            </form>
            <form method="post" action="/process_money">
                <h1>Casino</h1>
                <h4>Earns/Takes 50 golds</h4>
                <input type="hidden" name="gold" value="casino">
                <button type="submit">Find Gold</button>
            </form>
        </div>
        <div class="log">
            <label>Activities:</label>
            <div contenteditable="false" style="width: 850px;max-height:200px;
            overflow-y:scroll; border:solid black 1px;">
               <c:forEach items="${active}" var="item">
        <c:choose>
		    <c:when test="${item.contains('lost')}">
		        <p style="color: red;"><c:out value="${item}"/></p>
		    </c:when>
		    <c:otherwise>
		        <p style="color: green;"><c:out value="${item}"/></p>
		    </c:otherwise>
		</c:choose>       
		</c:forEach>
            </div>
        </div>
        <div class="clear">
        <form method="post" action="/clear">
            <input type="hidden" name="clear">
            <button type="submit">Clear</button>
        </form>
        </div>

    </main>
</body>
</html>