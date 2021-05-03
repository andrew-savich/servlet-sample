<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<h2>Hello Servlet!</h2>

	<c:if test="${userNotFound != null}">User not found, try again!<br>
	</c:if>

	<form action="/servlet-sample/login" method="GET">
		Login: <input type="text" name="login"> <br /> Password: <input
			type="password" name="password" /> <input type="submit"
			value="Submit" />
	</form>


</body>
</html>
