
<%@ taglib prefix="jstlc" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
.image {
	width: 100px;
	height: 100px;
	margin: 0 auto;
}

.image img {
	width: 100%;
	transition: padding-top 0.3s ease-in-out, padding-bottom 0.3s
		ease-in-out;
}

.image:hover img {
	transform: scale(2);
}

.navbar {
	margin-bottom: 0;
	border-radius: 0;
	transition: padding-top 0.3s ease-in-out, padding-bottom 0.3s
		ease-in-out;
}

tr, th {
	text-align: center;
	padding: 20px;
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
		<h2 style="color: #cc0000;font-style: italic;font-weight: bold;font-size:30px">Product List</h2>
	</center>

	<center>

		<table border="1" cellspacing="10" cellpadding="10">
			<thead>
				<th>Product</th>
				<th>Details</th>
				<th>Minimum bid</th>
				<th>Opening date</th>
				<th>Closing date</th>
				<th>Email</th>
				<th>Mobile</th>
				<th>Product Image</th>
				<th>Action</th>

			</thead>
			<jstlc:forEach var="product" items="${product_list}">
				<tr>
					<td>${product.product_name}</td>
					<td>${product.details}</td>
					<td>${product.minimum_bid}</td>
					<td><fmt:formatDate value="${product.opening_date}"
							pattern="yyyy-MM-dd" /></td>
					<td><fmt:formatDate value="${product.closing_date}"
							pattern="yyyy-MM-dd" /></td>
					<td>${product.email}</td>
					<td>${product.mobile}</td>
					<td><div class="image">
							<img width="100" height="100" src="getImage/${product.id}">
						</div></td>
					<td><a href="viewbid/${product.id}">View bids</a></td>
				</tr>
			</jstlc:forEach>
		</table>

		<button onclick="goBack()" style="margin-top: 20px">Go Back</button>
		<script>
			function goBack() {
				 window.location.href = "http://localhost:8080/E-Auction/dashboard_user";
			}
		</script>
	</center>

</body>
</html>