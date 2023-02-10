<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "RequesthandlerClass">
	<table>
			<tr>
				<td>Enter the ID you want to update:</td>
				<td><input type="text" name="userId"></td>
			</tr>

			<tr>
				<td>Enter the value you want to change:</td>
				<td><input type="password" name="firstName"></td>
			</tr>
			
			<tr>
				<td>User ID:</td>
				<td><input type="password" name="firstName"></td>
			</tr>
			<tr>
				<td>UserName:</td>
				<td><input type="password" name="firstName"></td>
			</tr>
			
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			
			</table>
			<input type = "hidden" name="crudCall" value ="update">
			</form>
</body>
</html>