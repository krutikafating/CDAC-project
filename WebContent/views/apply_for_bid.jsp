<!DOCTYPE html>




<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>Apply for bid</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>



<style>
body {
    color: #000;
    background: #272A2B;
    font-family: 'Roboto', sans-serif;
}
.form-control {
    height: 40px;
    box-shadow: none;
    color: #272525;
}
.login-form {
    width: 450px;
    margin: 0 auto;
    padding: 30px 0;
    font-size: 15px;
}
.login-form h2 {
    color: #272525;
    margin: 0 0 15px;
    position: relative;
    text-align: center;
}
.login-form h2:before, .login-form h2:after {
    content: "";
    height: 2px;
    width: 20%;
    background: #716D6D;
    position: absolute;
    top: 50%;
    z-index: 2;
}   
.login-form h2:before {
    left: 0;
}
.login-form h2:after {
    right: 0;
}
.login-form .hint-text {
    color: #999;
    margin-bottom: 30px;
    text-align: center;
}
.login-form form {
    color: #1b1818;
    border-radius: 3px;
    margin-bottom: 15px;
    background: #f2f3f7;
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    padding: 30px;
    border-color: #fff
}
.login-form .form-group {
    margin-bottom: 20px;
}
.login-form input[type="checkbox"] {
    margin-top: 3px;
}
.login-form .btn {        
    font-size: 16px;
    font-weight: bold;      
    min-width: 140px;
    outline: none !important;
    color: #fff;
}
.login-form .row div:first-child {
    padding-right: 10px;
}
.login-form .row div:last-child {
    padding-left: 10px;
}       
.login-form a {
    color: #fff;
    text-decoration: underline;
}
.login-form a:hover {
    text-decoration: none;
}
.login-form form a {
    color: #FFD700;
    text-decoration: none;
}   
.login-form form a:hover {
    text-decoration: underline;
}  
</style>


</head>
<body>



<div class="login-form">
    <form action="${pageContext.request.contextPath}/bid_action_product" method="post"  modelAttribute="applyBid"   enctype="multipart/form-data">
        <h2>Apply for Bid</h2>
        
        <div class="form-group">
             <label for="product">Product:</label>
            <input type="text" value = <%= session.getAttribute("product") %> class="form-control" name="bid_product" required="required"  disabled="disabled" >
        </div>   
         <div class="form-group">
             <label for="details">Details:</label>
            <input type="text" value = <%= session.getAttribute("product_details") %> class="form-control" name="bid_details" required="required"  disabled="disabled">
        </div> 
        <div class="form-group">
             <label for="details">Owner:</label>
            <input type="text" value = <%= session.getAttribute("product_username") %> class="form-control" name="bid_owner" required="required"  disabled="disabled">
        </div>   
          <div class="form-group">
             <label for="min_bid">Bid Amount:</label>
            <input type="number" class="form-control" name="bid_amount" required="required">
        </div>    
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block" style="background-color: #272A2B; border-color: none">Add</button>
        </div>
         <div class="form-group">
            <button type="reset" class="btn btn-success btn-lg btn-block" style="background-color: #272A2B; border-color: none">Reset</button>
        </div>
    </form>
</div>

</body>
</html>