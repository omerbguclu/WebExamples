<html>
<body>
	<% 
		//the default
		String favLang = "Java";
		
		//get the cookies from the browser request
		Cookie [] cookies = request.getCookies();
		
		//find our favorite language cookie
		if(cookies !=null){
			for(Cookie temp:cookies){
				if("firstCookie".equals(temp.getName())){
					favLang = temp.getValue();
					break;
				}
			}
		}
	%>
	
	<h1>Training Portal</h1>
	<h3>New Books for <%= favLang %></h3>
		Enter some text here
	<h3>Latest new reports for <%= favLang %></h3>
		Enter some text here
	<h3>Hot jobs for <%= favLang %></h3>
		Enter some text here
	<br></br>	
	<a href="cookies-personalize-form.jsp">Personalize this page</a>
	
</body>
</html>