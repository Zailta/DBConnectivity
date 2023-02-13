<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col  m6 offset-m3">
				<div class="card">
					<div class="card-content">
						<div class="form center-align">

							<table>
								<thead>
									<tr>
										<th>Select the page you want to Visit</th>
									</tr>
								</thead>
								<tbody>
									<tr>
										<td><a href="addNewUserPage.jsp">Add New User</a></td>
									</tr>
									<td><a href="searchUserPage.jsp">Search User</a></td>
									</tr>
									<tr>
										<td><a href="deleteUserPage.jsp">Delete User</a></td>
									</tr>
									<tr>
										<td><a href="updatePage.jsp">Update User</a></td>
									</tr>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>


</body>
</html>