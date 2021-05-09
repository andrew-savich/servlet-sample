<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
</head>

<body>
	<h2>Welcom ${sessionScope.user.firstName}!</h2>
	<table class="table">
		<thead>
			<tr>
				<th scope="col">#</th>
				<th scope="col">Login</th>
				<th scope="col">Name</th>
				<th scope="col">Role</th>
				<th scope="col">Actions</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<th scope="row">${user.id}</th>
					<td>${user.login}</td>
					<td>${user.firstName}</td>
					<td>${user.role}</td>
					<td>
						<form action="/servlet-sample/admin/userdelete" method="GET">
							<input type="text" hidden="true" name="id" value="${user.id}">
							<input class="btn btn-primary" type="submit" value="Delete" />
						</form>
					</td>
				</tr>
			</c:forEach>

		</tbody>
	</table>


</body>
</html>
