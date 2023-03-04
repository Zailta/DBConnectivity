<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
.aeroplane {
  background-image: url("https://i.ibb.co/3CWc0Vh/ticket.png");
  background-size: contain;
  width: 50px;
  height: 50px;

}
.ticket {
  background-image: url("https://i.ibb.co/pWxb0Qy/travelling.png");
  background-size: contain;
  width: 50px;
  height: 50px;
 float: right;

}
</style>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js"></script>
<!-- Compiled and minified CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">
<head>
<meta charset="ISO-8859-1">
<title>Ticket Information retrieval Page</title>
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
			$("#ticketForm").hide();
			$("#ticketinfo").show();
			$("#searchForm").on('submit', function(event) {
				event.preventDefault();
				
				$.ajax({
					url : 'UIHandler',
					data : $("#searchForm").serialize(),
					type : 'POST',
					success : function(data, textStatus, jqHXR) {
						$('#result').html("");
						$("#result").append("<b>Ticket Owner:</b> " + data.ticket.ticketHashCodeGenerator + "");
						$("#ticketinfo").hide();
						$("#ticketForm").show();
					},
					error : function(jqHXR, textStatus, errorThrown) {
						$('#result').html("an error has occured!!");
					}

				});

			})
		})
	</script>
</body>
<br>
<br>
<div class="container">
		<div class="row">
			<div class="col  m12 offset-m0">
				<div class="card">
					<div class="card-content">
						<div class="form center-align">
						<h6 id = "ticketinfo">Ticket Information will be displayed Here!</h6>
						<div class = "ticket"></div>
						<form method="post" action="UIHandler" id="ticketForm">
								<table>
								<tr>
										<td>Airport Name:</td>
										<td>Srinagar International Airport</td>
										<td>Flight ID:</td>
										<td>RFD7688</td>
										<td>Gate No.:</td>
										<td>6H</td>
									</tr>
									<tr>
										<td>Ticket ID:</td>
										<td>26-QTOVCDV</td>
										<td>Ticket Name:</td>
										<td>Mohammad Manaan Bhat</td>
									</tr>

									<tr>
										<td>Ticket Type:</td>
										<td>OneWay Ticket</td>
										<td>Latest Departure Date:</td>
										<td>2023-03-08</td>
										<td>Latest Return Date:</td>
										<td>N/A</td>
									</tr>
								</table>
							</form>
							<div class = "aeroplane"></div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</html>