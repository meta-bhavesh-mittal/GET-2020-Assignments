<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
	integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh"
	crossorigin="anonymous">
<style>
#showPassPrice {
	display: hidden;
}

form {
	width: 400px;
	margin: auto;
}

.form-container {
	padding: 30px;
}

.friend-card {
	margin: 20px auto;
	width: 400px;
}

.card-header {
	opacity: 0.7;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNav">
			<a class="navbar-brand" href="display"> MetaParkingSystem </a>
			<ul class="navbar-nav">
				<li class="nav-item"><a class="nav-link"
					href="/getEmployeeDetails">Personal Details<span
						class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="/getVehicleDetails">Vehicle Details</a></li>
				<li class="nav-item"><a class="nav-link" href="/getPassDetails">Pass
						Details</a></li>
				<li class="nav-item"><a class="nav-link" href="/getFriends">Friends</a>
				</li>
				<li class="nav-item"><a class="nav-link" href="/logout">Logout</a>
				</li>
			</ul>
		</div>
	</nav>
