<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>Customer Confirmation</title>
</head>
<body>
	Customer confirmed!
	<br> Customer first name is ${customer.firstName}
	<br> Customer last name is ${customer.lastName}
	<br> Customer free passes is ${customer.freePasses}
	<br> Customer postal code is ${customer.postalCode}
	<br> Customer course code is ${customer.courseCode}
</body>
</html>