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
		            dataType: "json",
					success : function(data, textStatus, jqHXR) {
						$('#airportName').append(data.retreiverBean.airportName);
						$('#flightId').append(data.retreiverBean.flightId);
						$('#gateId').append(data.retreiverBean.gateNumber);
						$('#ticketId').append(data.retreiverBean.ticketId);
						$('#ticketOwner').append(data.retreiverBean.ticketOwnerName);
						$('#ticketType').append(data.retreiverBean.ticketType);
						$('#latestDepartureDate').append(data.retreiverBean.latestDepartureDate);
						$('#latestReturnDate').append(data.retreiverBean.latestReturnDate);
						
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

<div class="container" id = "result">
		<div class="row">
			<div class="col  m12 offset-m0">
				<div class="card">
					<div class="card-content">
						<div class="form center-align">
						<h6 id = "ticketinfo">Ticket Information will be displayed Here!</h6>
						<div class = "ticket" ></div>
						<form id = "ticketForm">
								<table>
								<tr>
										<td>Airport Name:</td>
										<td id = "airportName" ></td>
										<td>Flight ID:</td>
										<td id = "flightId"></td>
										<td>Gate No.:</td>
										<td id = "gateId"></td>
									</tr>
									<tr>
										<td>Ticket ID:</td>
										<td id  = "ticketId"></td>
										<td>Ticket Name:</td>
										<td id = "ticketOwner"></td>
									</tr>

									<tr>
										<td>Ticket Type:</td>
										<td id= "ticketType"></td>
										<td>Latest Departure Date:</td>
										<td id = "latestDepartureDate"></td>
										<td>Latest Return Date:</td>
										<td id = "latestReturnDate"></td>
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