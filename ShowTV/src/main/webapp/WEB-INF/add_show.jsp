<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<!DOCTYPE html>
<head>
    <meta charset="UTF-8">
    <title>Add a TV show</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<body>
	<div class="container w-75">
		<c:if test="${not empty success}">
			<div class="alert alert-success mt-4"><c:out value="${success}"/></div>
		</c:if>
		
		<div class="d-flex align-items-center justify-content-between">
			<div class="mt-4">
				<h1 style="color:darkcyan">Welcome <c:out value="${name}"/></h1>
				<br>
				
			</div>
			<div class="d-flex flex-column align-items-end">
				<a style="color:darkcyan" href = "/logout">Logout</a>
				<br>
				
			</div>
			
		</div>
		
		<div class="w-75 mr-4">
				
<hr>
	
				
	
				
					<h3 style="color:darkcyan">Add a TV show</h3>
				
				<form:form class="border border-3 p-4 border-dark" method="post" modelAttribute="tvshow" action="/new">
					<div class="mb-3"> 
						<form:label path="name" class="form-label">Name:</form:label>
						<form:input  path="name" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
						<form:errors path="name" cssClass="invalid-feedback"/>
					</div>
					<div class="mb-3">
						<form:label path="network" class="form-label">Network: </form:label>
						<form:input  path="network" cssClass="form-control" cssErrorClass="form-control is-invalid"  />
						<form:errors  path="network" cssClass="invalid-feedback"/>
					</div>
					          
  <div class="form-group">
 <form:label path="desctiption">Description</form:label>
        <form:errors path="desctiption" class="errr"/>
        <form:textarea class="form-control" id="exampleFormControlTextarea1" rows="3" path="desctiption"/>
  </div>
  
					         
 
  
					<input style="background-color:darkcyan" type="submit" value="Create TVshow" class="btn btn-dark">
								<a href="/tvshows">	<input style="background-color:#808080;width:11%" value="Cancel" class="btn btn-dark"/>
				</a>
			
				</form:form>
			
			</div>
	
</body>
</html>