<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
	<div class="container mt-5">
		<div class="col-7 mx-auto">
			<h1>Create License</h1>
			<div id="createForm">
				<form:form action="/licenses/create" method="post"
					modelAttribute="license">
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<label class="input-group-text">Driver:</label>
							</div>
							<select name="driver" class="form-control">
								<c:forEach items="${people}" var="driver">
									<option value="${driver.id}">${driver.firstName}  ${driver.lastName}</option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<form:label path="state" class="input-group-text">State:</form:label>
							</div>
							<form:input path="state" class="form-control" />
							<form:errors path="state" />
						</div>
					</div>
					<div class="form-group">
						<div class="input-group">
							<div class="input-group-prepend">
								<form:label path="expirationDate" class="input-group-text">Expiration Date:</form:label>
							</div>
							<form:input type="date" path="expirationDate" class="form-control" />
							<form:errors path="expirationDate" />
						</div>
					</div>
					
					<form:errors path="number" />
					
					<input type="submit" />
				</form:form>
			</div>
		</div>
	</div>

</body>
</html>