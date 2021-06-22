<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</head>

<body>
	<header>
		<h1>Welcome to Lookify</h1>
		<div>
			<a href="/songs/new">Add Song</a>
			<a href="/dashboard">Dashboard</a>		
		</div>
		<div>
			<form action="/search" method="post">
				<div class="form-group">
					<label class="form-control">
						<input name="artist" type="text" />
						<input type="submit" value="Search Artist"/>
					</label>
				</div>
			</form>
		</div>
	</header>
	<main>
		<table class="table table-hover">
			<thead>
				<tr>
					<th>Title</th>
					<th>Artist</th>
					<th>rating</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items='${ allSongs }' var='song'>
					<tr>
						<td>
							<h5>
								<a href="/songs/${song.id}">${ song.title }</a> 
							</h5>
						</td>
						<td>
							<h5>${song.artist}</h5>
						</td>
						<td>
							<h5>${song.rating}</h5>
						</td>
						<td><a href="/songs/${song.id}/delete"> Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</main>
</body>
</html>