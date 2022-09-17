<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<html>
	<head>
		<title>Welcome</title>
	</head>
	<body>
		<c:choose>
		    <c:when test="${sessionScope.user_id != null}">
		        <h1>Welcome  <c:out value="${user_name}"></c:out> </h1>
		    </c:when>
		    <c:otherwise>
		    	<h1>Not logged in</h1>
		    </c:otherwise>
		</c:choose>
		
		
		<a href="/logout">logout</a>
	</body>
</html>