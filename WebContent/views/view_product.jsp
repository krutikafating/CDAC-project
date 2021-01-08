
<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<title>E-Auction</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

tr, th	{
    text-align:center;
      padding:20px;
}

table {
    background-color: #FFFFCC;
}


</style>

</head>
<body>

	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">E-Auction</a>
			</div>

		</div>
	</nav>
	<center>
		<h2 style="color: #8321B4; font-family: Cursive">Product List</h2>
	</center>

	<center>

	<table border="1" cellspacing="10" cellpadding="10">
		<thead>
			<th>id</th>
			<th>Username</th>
			<th>Product</th>
			<th>Details</th>
			<th>Minimum bid</th>
			<th>Opening date</th>
			<th>Closing date</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Action</th>

		</thead>
		<jstlc:forEach var="product" items="${product_list}">
			<tr>
				<td>${product.id}</td>
				<td>${product.username}</td>
				<td>${product.product}</td>
				<td>${product.details}</td>
				<td>${product.minimum_bid}</td>
				<td><fmt:formatDate value="${product.opening_date}" pattern="yyyy-MM-dd"/></td>
				<td><fmt:formatDate value="${product.closing_date}" pattern="yyyy-MM-dd"/></td>
				<td>${product.email}</td>
				<td>${product.mobile}</td>
				
				<td>
					<a href = "view_bid">View bids</a>
				</td>
			</tr>
		</jstlc:forEach>
	</table>
	</center>

</body>
</html>