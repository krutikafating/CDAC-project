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
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li><a href="buyers">Add product</a></li>
					<li><a href="sellers">View Product</a></li>
					<li><a href="auctions">Auction</a></li>
					<li><a href="status">Status</a></li>
					<li><a href="logout">Logout</a></li>
				</ul>
			</div>
		</div>
	</nav>
	Welcome <%= session.getAttribute("username_user") %>

</body>
</html>