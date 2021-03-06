
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  


<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:400,700">
<title>Registration</title>
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
.error
{
	color:red;
	 font-style: italic;
}  
</style>


</head>
<body>



<div class="login-form">
    <form:form action="${pageContext.request.contextPath}/register_action_user" method="post" modelAttribute="register_new">
        <h2>Register User</h2>
        
        <div class="form-group">
          <label for="product">Full Name:</label>
           <form:input path="full_name" type="text" class="form-control" name="full_name" placeholder="Full Name" />
           <form:errors path="full_name" cssClass="error"/>
        </div>
         
         <div class="form-group">
           <label for="product">Email:</label>
          <form:input path="email" type="email" class="form-control" name="email" placeholder="Email id" />
          <form:errors path="email" cssClass="error"/>
        </div>    
          <div class="form-group">
            <label for="product">Address:</label>
          <form:input path="address" type="text" class="form-control" name="address" placeholder="Address" />
          <form:errors path="address" cssClass="error"/>
        </div> 
         <div class="form-group">
           <label for="product">Date of birth:</label>
        <input type="date" class="form-control" name="dob" placeholder="Date of birth">
        </div> 
        <div class="form-group">
          <label for="product">Mobile no:</label>
          <form:input path="mobile" type="tel" class="form-control" name="mobile" placeholder="Mobile no" />
          <form:errors path="mobile" cssClass="error"/>
        </div> 
         <div class="form-group">
           <label for="product">Password:</label>
          <form:input path="password" type="password" class="form-control" name="password" placeholder="Password" />
          <form:errors path="password" cssClass="error"/>
        </div>  
         <div class="form-group">
           <label for="product">Confirm Password:</label>
            <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password" >
        </div>       
          <div class="form-group" style="color:#ff0000">${requestScope.message}
        </div> 
        <div class="form-group">
            <form:button type="submit" class="btn btn-success btn-lg btn-block" style="background-color: #272A2B; border-color: none">Register</form:button>
        </div>
        
        
    </form:form>
</div>
</body>
</html>