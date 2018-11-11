<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Student Registration Form</title>
	</head>
<body>
	<form:form action="processForm" modelAttribute="student">
	First name: <form:input path="firstName"/>
	<br/>
	Last name: <form:input path="lastName"/>
	<br/>
	
	Country: 
	<form:select path="country">
		<form:options items="${theCountryOptions}"/>
	</form:select>
	
	<br/>
	Favorite Language: 
	<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}"  />
	<br/>
	Operating Systems:
	Linux <form:checkbox path="operatingSystems" value="Linux"/>
	Mac OS <form:checkbox path="operatingSystems" value="Mac Os"/>
	Windows<form:checkbox path="operatingSystems" value="Windows"/>
	<br/>
	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>