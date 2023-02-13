<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

<!-- Compiled and minified JavaScript -->
<head>
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
							<form method="post" action="RequesthandlerClass" id="deleteForm">
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
										<td><button type="submit" class="btn  purple accent-4" >Submit</button></td>
									</tr>
								</table>
								<h3 id="result"></h3>
								<input type="hidden" name="crudCall" value="delete">
							</form>
							<h3 id="result"></h3>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			console.log("page is here");
			$("#deleteForm").on('submit', function(event) {
				event.preventDefault();

				$.ajax({
					url : 'RequesthandlerClass',
					data : $("#deleteForm").serialize(),
					type : 'POST',
					success : function(data, textStatus, jqHXR) {
						$('#result').html(data);
					},
					error : function(jqHXR, textStatus, errorThrown) {
						$('#result').html("an error has occured!!");
					}

				});

			})
		})
	</script>
</body>
</html>