<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:url var="theContextPath" value="/" />

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Product Manager</title>

<link rel="stylesheet" type="text/css"
	href="${theContextPath}/resources/css/bootstrap.min.css">

</head>
<body>

	<div class="container">
		<h1>Product - Manager</h1>
		<hr>

		<div>
			<a class="btn btn-sm btn-primary mb-2"
				href="${theContextPath}/product/add">Add Product</a>
		</div>
				<form class="row g-3 mb-2" action="${theContextPath}/product">
					<div class="col-auto">
						<label class="col-form-label" for="search">Search: </label> 
					</div>
					<div class="col-auto">
						<input id="search" class="form-control" type="search" name="search"
							placeholder="Product name">
					</div>
					<div class="col-auto">
						<input class="form-control btn btn-primary" type="submit" value="Go">
					</div>
				</form>
		<table class="table table-dark">
			<thead>
				<tr>
					<th><a href="${theContextPath}/product?sort=name">Name</a></th>
					<th>Description</th>
					<th>Price</th>
					<th><a href="${theContextPath}/product?sort=quantity">Quantity</a></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="p">
					<tr>
						<td>${p.name}</td>
						<td><c:choose>
								<c:when test="${p.description.length() > 20 }">
									${p.description.substring(0, 20)}...
								</c:when>
								<c:otherwise>
									${p.description}
								</c:otherwise>
							</c:choose></td>
						<td>฿${p.price}</td>
						<td>${p.quantity}</td>
						<td><a class="btn btn-sm btn-secondary"
							href="${theContextPath}/product/${p.id}">Detail</a> <a
							class="btn btn-sm btn-primary"
							href="${theContextPath}/product/edit/${p.id}">Edit</a> <a
							class="btn btn-sm btn-danger"
							onclick="if(!confirm('Are you sure you want to delete ${p.name}')) return false;"
							href="${theContextPath}/product/delete/${p.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>

	</div>

</body>
</html>