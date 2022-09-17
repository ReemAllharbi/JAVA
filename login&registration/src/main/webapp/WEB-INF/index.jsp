<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html>
<head>
   
	<title>Register&Login</title>
		   <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	
	<script type="text/javascript" src="/js/app.js"></script>
	 <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
	<div class="container">
	<h2>Register</h2>

<form:form action="/register" method="post" modelAttribute="newUser">

  <div class="form-group">
        <form:label path="username">User Name</form:label>
        <form:errors path="username" class="errr"/>
                <form:input  class="form-control" path="username"/>
          </div>

          
  <div class="form-group">
 <form:label path="email">Email</form:label>
        <form:errors path="email" class="errr"/>
        <form:input  class="form-control" path="email"/>
  </div>
  
  
  <div class="form-group">
  <form:label path="Password">Password</form:label>
        <form:errors path="password" class="errr"/>
        <form:input  class="form-control" path="password" type="Password"/>
  </div>
  
    <div class="form-group">
  <form:label path="confirmPassword">Confirm Password</form:label>
        <form:errors path="confirmPassword" class="errr"/>
        <form:input  class="form-control" path="confirmPassword" type="Password"/>
  </div>
    <br/>
  <button type="submit" class="btn btn-primary">Register</button>
</form:form> <br/>






	<h2>Login</h2>
<form:form action="/login" method="post" modelAttribute="userLoginRequest">
			<div>
				Enter email address
				<form:errors  path="email" class="errr"/>
				<form:input  class="form-control" path="email"/>
			</div>

			<div>
				Enter password
				<form:errors  class="errr" path="password"  />
				<form:input  class="form-control" path="password" type="Password"/>
			</div>
				 <br/>
			<input class="btn btn-primary" type="submit" value="Login">
		</form:form>
		
		 <br/>

