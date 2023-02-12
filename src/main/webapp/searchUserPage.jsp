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
	<form method="post" action="RequesthandlerClass" id = "searchForm">
		<table>
			<tr>
				<td>Enter the User Id of the User want to search:</td>
				<td><input type="text" name="UserID"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
		<input type="hidden" name="crudCall" value="search">
	</form>
	 <br/>
	  <br/>
	 <h3 id="result"></h3>

	<script>
       $(document).ready(function(){
    	   console.log("page is here");
    	   $("#searchForm").on('submit', function(event){
    		   event.preventDefault();
    		  
    		   $.ajax({
    			     url:'RequesthandlerClass',
    			     data: $("#searchForm").serialize(),
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