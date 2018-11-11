<html>
<head><title>Student Confirmation Table</title></head>
<body>
	The student is confirmed: ${param.firstName} ${param.lastName}
	<br/>
	The favorite languages of student
	<!-- 	display list of favorite language -->
	<%
		String [] parameterList = request.getParameterValues("favoriteLanguage");
		for(String template : parameterList){
			out.println("<li>"+template+"</li>");
		}
	%>
</body>
</html>