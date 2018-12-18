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
	
	<!-- Add a logout button -->
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" />
	</form:form>
</body>
</html>