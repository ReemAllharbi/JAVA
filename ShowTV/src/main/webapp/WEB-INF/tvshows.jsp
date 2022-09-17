<%@ page isErrorPage="true"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<head>
	<meta charset="UTF-8">
	<title>TV shows</title>
	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        		   <!-- CSS only -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<!-- JavaScript Bundle with Popper -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
	
	<script type="text/javascript" src="/js/app.js"></script>
	 <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    	<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
	<div class="container w-75">
		<c:if test="${not empty success}">
			<div class="alert alert-success mt-4"><c:out value="${success}"/></div>
		</c:if>
		
		<div class="d-flex align-items-center justify-content-between">
			<div class="mt-4">
				<h1 style="color:darkcyan">Welcome <c:out value="${name}"/></h1>
		
				
			</div>
			<div class="d-flex flex-column align-items-end">
				<a style="color:darkcyan" href = "/logout">Logout</a>
				<br>
				
			</div>
			
		</div>


		<table class="table">
					<thead>
					
				<tr>
					<th scope="col">Show</th>
					<th scope="col">Network</th>
					<th scope="col" >Average Rate</th>
				
		
				</tr>
			</thead>
		<tbody>
				<c:forEach items="${tvshows}" var="tvshow">
					<tr>	
						<td ><a style="color:darkcyan; text-decoration: none"  href="/tvshows/${tvshow.id}" ><c:out value="${tvshow.name}"/></a></td>
						<td ><c:out value="${tvshow.network}"/></td>
												<td >rate</td>
						
						
		
					</tr>
				</c:forEach>
			</tbody>
		</table>
				<a href="/new">	<input style="background-color:darkcyan" type="submit" value="Add a show" class="btn btn-dark"/>
				</a>
	</div>
    
	
</body>
</html>
