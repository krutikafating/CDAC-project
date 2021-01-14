
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>AddProduct</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link
	href="<%=request.getContextPath()%>/resources/css/farmerCSS/mainfarmer/addcrop.css"
	rel="stylesheet" />
</head>

<body>
	<%
		response.setHeader("cache-control", "no-cache, no-store, must-revalidate");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);
	if (session.getAttribute("mobileno") == null) {
		String redirectURL = "loginfarmer";
		response.sendRedirect(redirectURL);
	}
	%>
	<div class="login-form">
		<form action="<%=request.getContextPath()%>/savecrop" method="post"
			enctype="multipart/form-data">
			<h2>Add Crop Here</h2>

			<div class="form-group">
				<label>Name:</label> <input type="text" class="form-control"
					name="userName" placeholder="Enter Your Name" required="required">
			</div>
			<div class="form-group">
				<label>Crop Name:</label> <select class="form-control colorPicker"
					name="cropName">
					<option selected value="base">Please Select</option>
					<option value="1975">Wheat</option>
					<option value="2620">Jowar</option>
					<option value="1850">Maize</option>
					<option value="5825">Cotton</option>
				</select>
			</div>
			<div class="form-group">
				<label>MSP Rate ( Rs :)</label> <input type="text"
					class="colorDisplay form-control" value="Autofill here" name="msp"
					required="required" disabled="disabled">
			</div>
			<div class="form-group">
				<label>Quantity (In Quintal)</label> <input type="number"
					class="form-control" name="quantity" placeholder="Enter Crop Name"
					required="required">
			</div>
			<div class="form-group">
				<label>Date of Upload Crop:</label> <input type="date"
					class="form-control" name="uploadDate"
					placeholder="Enter Date of Uploading the Crop" required="required">
			</div>
			<div class="form-group">
				<label>Date of Harvest Crop:</label> <input type="date"
					class="form-control" name="harvestDate"
					placeholder="Enter Date of Harvest Crop" required="required">
			</div>
			<div class="form-group">
				<label>Village</label> <input type="text" class="form-control"
					name="village" placeholder="Enter Village Name" required="required">
			</div>
			<div class="form-group">
				<label>City</label> <input type="text" class="form-control"
					name="city" placeholder="Enter City Name" required="required">
			</div>
			<div class="form-group">
				<label>Pincode</label> <input type="number" class="form-control"
					name="pincode" placeholder="Enter Village Name" required="required">
			</div>
			<hr />

			<div class="form-group">
				<label>Upload Crop image:</label> <input class="form-control"
					type="file" name="image">
			</div>
			<div class="form-group ">
				<div class="row-fluid">
					<button type="submit" class="btn btn btn-success btn-lg">Submit</button>
					<hr class="horizontal" />
					<button type="reset" class="btn btn btn-success btn-lg">
						Reset<br>
					</button>
					<hr class="horizontal" />
					<a type="button" href="<%=request.getContextPath()%>/mainfarmer"
						class="btn btn btn-success btn-lg "> Close<br>
					</a>
				</div>
			</div>
		</form>
	</div>
	<script>
		$(document).ready(function() {
			//when the select changes:
			$('.colorPicker').on("change", function() {
				//set the value of the input to the value of the select.
				$('.colorDisplay').val($(this).val());
			});
		});
	</script>
</body>
</html>