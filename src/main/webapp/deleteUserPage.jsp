<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>

<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method = "post" action = "RequesthandlerClass" id = "deleteForm">
	<table>
			<tr>
				<td>Enter the User Id of the User you want to delete:</td>
				<td><input type="text" name="userId"></td>
			</tr>
			
			<tr>
				<td>Enter the User Name of the User you want to delete:</td>
				<td><input type="text" name="userName"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
			</table>
			<input type = "hidden" name="crudCall" value ="delete">
			</form>
			 <h3 id="result"></h3>

	<script>
       $(document).ready(function(){
    	   console.log("page is here");
    	   $("#deleteForm").on('submit', function(event){
    		   event.preventDefault();
    		  
    		   $.ajax({
    			     url:'RequesthandlerClass',
    			     data: $("#deleteForm").serialize(),
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