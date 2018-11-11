<html>
<head>
<title>Welcome JSP Examples</title>
</head>
<body  background="https://upload.wikimedia.org/wikipedia/commons/thumb/0/0c/PinkArgyle.svg/1200px-PinkArgyle.svg.png">
<h1>Some Examples Here</h1>
<h2>Jsp Expressions</h2>
Converting a string to uppercase <%= new String("Hey I am newbie here").toUpperCase() %>
<br></br>
25 multiplied by 4 equals: <%= 25*4 %>
<br></br>
Is 75 lest than 69? <%= 75<69 %>

<br/>
<h2>Jsp Scriptlets</h2>
<%	for(int i=0;i<5;i++){
	out.println("<br/>Here some nums"+i);
}%>
<h2>Jsp Declarations</h2>
<%! String makeItLower(String a){
		return a.toLowerCase();
	}	
%>
Converting a string to lowercase: <% out.println(makeItLower("Hey I am newbie here")); %>
<br/>
Converting a string to lowercase with different style: <%= makeItLower("Hey I am newbie here") %>
</body>
</html>