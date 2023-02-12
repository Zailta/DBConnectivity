<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
	<form method = "post" action = "RequesthandlerClass" id  = "loginForm">
	<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="UserName"></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			</table>
			<input type = "hidden" name="crudCall" value ="login">
			</form>
</body>
</html>