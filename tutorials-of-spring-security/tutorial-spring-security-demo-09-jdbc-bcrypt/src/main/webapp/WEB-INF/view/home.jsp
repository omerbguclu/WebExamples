<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<title>Omerbguclu Company Home Page</title>
</head>
<body>
	<h2>Omerbguclu Company Home Page</h2>
	<hr>
	<p>
	Welcome to the omerbguclu company home page!
	</p>
	<hr>
	<!-- display user name and role -->
	<p>
	 User: <security:authentication property="principal.username"/>
	 <br><br>
	 Role(s): <security:authentication property="principal.authorities"/>
	</p>
	
	<!-- Add a link to point to /systems ... this is for the admin's -->
	<security:authorize access="hasRole('ADMIN')">
		<p>
			<a href="${pageContext.request.contextPath}/systems">IT Systems Meeting</a>
			(Only for manager peoples)
		</p>
	</security:authorize>
	
	<!-- Add a link to pint to l/leaders ... this is for the managers -->
	
	<security:authorize access="hasRole('MANAGER')">
	<p>
		<a href="${pageContext.request.contextPath}/leaders">LeaderShip Meeting</a>
		(Only for manager peoples)
	</p>
	</security:authorize>
	<hr>
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
	</form:form>
</body>
</html>