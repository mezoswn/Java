<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<body>
	<div class="container border mt-5 text-center  col-7">
		<h1 class="mt-3 mb-2">${ product.name }</h1>
		<div class="container mb-5">
			<br /> <a href="/">Home</a>
			<div class="d-flex justify-content-between">
				<div class="col-5">
					<table class="table table-hover border">
						<thead>
							<tr>
								<th>Categories:</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${ product.categories }" var="category">
								<tr>
									<td>${ category.name }</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<div class="col-5 border p-4">
					<form action="/products/add/categories" method="post">
						<div class="form-group">
							<input name="category_id" type="hidden" value="${ product.id }">
							<div class="input-group">
								<div class="input-group-prepend">
									<label class="input-group-text">categories:</label>
								</div>
								<select name="product_id" class="form-control">
									<c:forEach items="${ categories }" var="category">
										<option value="${ category.id }">${ category.name }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<br>
						<input type="submit" />
					</form>
					
					<br> <a href="/">Home</a><br>
				</div>			
			</div>
		</div>
	</div>
</body>
</html>