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
    color: #969fa4;
}
.login-form {
    width: 450px;
    margin: 0 auto;
    padding: 30px 0;
    font-size: 15px;
}
.login-form h2 {
    color: #716D6D;
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



<div class="login-form">
    <form action="${pageContext.request.contextPath}/register_action_user" method="post" modelAttribute="register_new">
        <h2>Register User</h2>
        
        <div class="form-group">
            <input type="text" class="form-control" name="first_name" placeholder="First Name" required="required">
        </div>
        <div class="form-group">
            <input type="text" class="form-control" name="last_name" placeholder="Last Name" required="required">
        </div>   
         <div class="form-group">
            <input type="email" class="form-control" name="email" placeholder="Email id" required="required">
        </div>    
          <div class="form-group">
            <input type="text" class="form-control" name="address" placeholder="Address" required="required">
        </div> 
         <div class="form-group">
            <input type="date" class="form-control" name="dob" placeholder="Date of birth" required="required">
        </div> 
        <div class="form-group">
            <input type="tel" class="form-control" name="mobile" placeholder="Mobile no" required="required">
        </div> 
         <div class="form-group">
            <input type="password" class="form-control" name="password" placeholder="Password" required="required">
        </div>  
         <div class="form-group">
            <input type="password" class="form-control" name="confirm_password" placeholder="Confirm Password" required="required">
        </div>       
        <div class="form-group">
            <button type="submit" class="btn btn-success btn-lg btn-block" style="background-color: #272A2B; border-color: none">Register</button>
        </div>
    </form>
</div>
</body>
</html>