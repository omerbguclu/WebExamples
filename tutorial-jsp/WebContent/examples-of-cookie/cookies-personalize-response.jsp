<html>
<body>
	<%
		//read form data
		String favLang = request.getParameter("favLanguage");
		
		//create the cookie
		Cookie theCook = new Cookie("firstCookie",favLang);
		
		//set the life span
		theCook.setMaxAge(60*60*24*365);
		
		//send the cookie to browser
		response.addCookie(theCook);
	%>
	Thanks! We set your favorite language to: ${param.favLanguage}
	<br/>
	<a href="cookies-homepage.jsp">Return to homepage.</a>
</body>
</html>