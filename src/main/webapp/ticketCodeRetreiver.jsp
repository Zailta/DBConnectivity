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
							<form method="post" action="UIHandler" id="searchForm">
								<table>
									<tr>
										<td>Enter the Ticket Id of the User want to search:</td>
										<td><input type="text" name="ticketCode"></td>
									</tr>

									<tr>
										<td></td>
										<td><button type="submit" class="btn  purple accent-4" >Submit</button></td>
									</tr>
								</table>
								<h3 id="result"></h3>
								<input type="hidden" name="crudCall" value="search">
							</form>
							<br /> <br />

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script>
		$(document).ready(function() {
			console.log("page is here");
			$("#searchForm").on('submit', function(event) {
				event.preventDefault();

				$.ajax({
					url : 'UIHandler',
					data : $("#searchForm").serialize(),
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