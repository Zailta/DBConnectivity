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
				<td>Enter the User Id of the User want to search:</td>
				<td><input type="text" name="UserName"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			</table>
			<input type = "hidden" name="crudCall" value ="search">
			</form>
</body>
</html>