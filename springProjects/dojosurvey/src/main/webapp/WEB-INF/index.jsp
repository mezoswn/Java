<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information Page</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
   <div class="user">
    <form action="/info" method='post'>
        <label for="name">Your name:</label>
        <input type="text"  name="name">
        <br><br>
        <label for="location">Location:</label>
        <select name="location">
        	<option value="Palestine">Palestine</option>
            <option value="Bellevue">Bellevue</option>
            <option value="Chicago">Chicago</option>
            <option value="Dallas">Dallas</option>
            <option value="LA">LA</option>
            <option value="San-Jose">San-Jose</option>
        </select>
        <br><br>
        <label for="lang">Favorite Language:</label>
        <select name="lang" >
            <option value="java">JAVA</option>
            <option value="python">Python</option>
            <option value="c#/.NET">C#/.NET</option>
            <option value="mern">MERN</option>
            <option value="ruby">RUBY</option>
        </select>
        <br><br>
        <label for="comment">Comment</label>
        <textarea name="comment"></textarea>
        <br><br>
        <input type="submit" value="Submit" >
        <br><br>
      </form>
    </div>
</body>
</html>