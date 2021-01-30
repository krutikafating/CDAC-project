<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>AddProduct</title>
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
    color: #969fa4;
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
    width: 25%;
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
    color: #999;
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

<%-- <jsp:include page = "header.jsp"/>--%>
<div class="login-form">
    <form action="${pageContext.request.contextPath}/add_product_user" method="post" modelAttribute="product_user" enctype="multipart/form-data">
        <h2>Add Product</h2>
        
        
        <div class="form-group">
             <label for="product_name">Product:</label>
            <input type="text" class="form-control" name="product_name" required="required">
        </div>   
         <div class="form-group">
             <label for="details">Details:</label>
            <input type="text" class="form-control" name="details" required="required">
        </div>    
          <div class="form-group">
             <label for="min_bid">Minimum Bid:</label>
            <input type="number" class="form-control" name="minimum_bid" required="required">
        </div> 
         <div class="form-group">
             <label for="openDate">Opening Date:</label>
            <input type="date" class="form-control" name="opening_date" placeholder="Opening Date" required="required">
        </div> 
         <div class="form-group">
             <label for="closeDate">Closing Date:</label>
            <input type="date" class="form-control" name="closing_date" required="required">
        </div>  
         <div class="form-group">
             <label for="email">E-mail:</label>
            <input type="email" class="form-control" name="email" required="required">
        </div>   
        <div class="form-group">
             <label for="mobile">Mobile No:</label>
            <input type="tel" class="form-control" name="mobile" required="required">
        </div>  
         <div class="form-group">
             <label for="image">Select image:</label>
             <input type="file" id="file" name="file" accept="image/*">
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