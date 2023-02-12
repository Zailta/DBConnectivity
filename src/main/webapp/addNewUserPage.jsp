<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="RequesthandlerClass" method="POST" id = "addnewuserForm">
		<table>
			<tr>
				<td>UserName:</td>
				<td><input type="text" name="UserName"></td>
			</tr>

			<tr>
				<td>First Name:</td>
				<td><input type="text" name="firstName"></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><input type="text" name="lastName" /></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><input type="password" name="password" /></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type="email" name="email" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="crudCall" value="newuser">
	</form>
		 <br/>
	  <br/>
	 <h3 id="result"></h3>

	<script>
       $(document).ready(function(){
    	   console.log("page is here");
    	   $("#addnewuserForm").on('submit', function(event){
    		   event.preventDefault();
    		  
    		   $.ajax({
    			     url:'RequesthandlerClass',
    			     data: $("#addnewuserForm").serialize(),
    			     type: 'POST',
    			     success: function (data, textStatus, jqHXR) {
    			            $('#result').html(data);
    			    },
    			    error: function (jqHXR, textStatus, errorThrown ) {
			            $('#result').html("an error has occured!!");
			    }
    			    
    			});
    		   
    	   })
       })
      </script>

</body>
</html>