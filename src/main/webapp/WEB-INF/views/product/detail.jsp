<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="theContextPath" value="/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${product.name} - Detail</title>

<link rel="stylesheet" type="text/css"
	href="${theContextPath}/resources/css/bootstrap.min.css">

</head>
<body>

	<div class="container">
		<h1>${product.name}-Detail</h1>

		<hr>

		<p>Full description: ${product.description }</p>

		<p>Price: ฿${product.price }</p>

		<p>Quantity: ${product.quantity }</p>
		
		<a class="btn btn-sm btn-primary" href="${theContextPath}/product/edit/${product.id}">Edit</a>
		<a onclick="if(!confirm('Are you sure you want to delete ${product.name}')) return false;"
			href="${theContextPath}/product/delete/${product.id}"
			class="btn btn-sm btn-danger">
			Delete
		</a>
		
		<hr>
		
		<a href="${theContextPath}/product">Back</a>

	</div>

</body>
</html>