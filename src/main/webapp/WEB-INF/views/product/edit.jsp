<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<c:url var="theContextPath" value="/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name} - Edit Page</title>

<link rel="stylesheet" type="text/css"
	href="${theContextPath}/resources/css/bootstrap.min.css">
	
	<style type="text/css">
		.error {
			color: red;
		}
	</style>

</head>
<body>

	<div class="container">
		<h1>${product.name} - Edit</h1>

		<hr>

		<form:form modelAttribute="product" action="${theContextPath}/product/edit">
		
			<form:hidden path="id"/>
		
			<div>
				<label for="name">Name: </label>
				<form:input cssClass="form-control" id="name" path="name"/>
				<form:errors path="name" cssClass="error"/>
			</div>
			
			<div>
				<label for="desc">Description: </label>
				<form:textarea rows="4" cssClass="form-control" id="desc" path="description"></form:textarea>
			</div>
			
			<div>
				<label for="price">Price: </label>
				<form:input type="number" min="1" cssClass="form-control" id="price" path="price"/>
				<form:errors path="price" cssClass="error"/>
			</div>
			
			<div class="mb-2">
				<label for="quantity">Quantity: </label>
				<form:input type="number" min="1" cssClass="form-control" id="quantity" path="quantity"/>
				<form:errors path="quantity" cssClass="error"/>
			</div>
		
			<div>
				<input class="btn btn-sm btn-primary" type="submit" value="Update">
			</div>
		
		</form:form>		
		
		<hr>
		
		<a href="${theContextPath}/product">Back</a>

	</div>

</body>
</html>