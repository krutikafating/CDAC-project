
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
		<h2 style="color: #8321B4; font-family: Cursive">Bids List</h2>
	</center>
	

	<center>

	<table border="1" cellspacing="10" cellpadding="10">
		<thead>
			<th>Sr.No</th>
			<th>Buyer Name</th>
			<th>Product</th>
			<th>Bid Amount</th>
			<th>Applied Date</th>
			<th>Status</th>
			<th>Action</th>

		</thead>
		
		<jstlc:forEach var="auction" items="${bids_list}">
			<tr>
				<td></td>
				<td>${auction.buyer_name}</td>
				<td>${auction.product_name}</td>
				<td>${auction.bid_amount}</td>
				<td><fmt:formatDate value="${auction.date}" pattern="yyyy-MM-dd"/></td>
				<td>${auction.status}</td>
				<td>
					<a href = "accept_bid/${auction.id}">Accept</a>
				</td>
			</tr>
		</jstlc:forEach>
	</table>
	
	<button onclick="goBack()" style="margin-top:20px">Go Back</button>
	
	<script>
function goBack() {
  window.history.back();
}
</script>
	
	</center>
	


</body>
</html>