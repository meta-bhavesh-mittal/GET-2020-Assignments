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

#user-image {
	width: 40px;
	height: 40px;
	border-radius: 40px;
	position: fixed;
	right: 10px;
	top: 10px;
}
</style>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="collapse navbar-collapse" id="navbarNav">
			<a class="navbar-brand" href="/display"> MetaParkingSystem </a>
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
	<img id="user-image" src="${imagePath}" alt="Profile image..." data-toggle="modal" data-target="#exampleModal">
	
	<!-- Modal -->
	<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Upload Image</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
	      <div class="modal-footer">
	        <form action="uploadImage" method="post" enctype="multipart/form-data">
	        	<div class="custom-file">
	        		<input type="file" name="image" class="custom-file-input" id="validatedCustomFile">
	        		<label class="custom-file-label" for="validatedCustomFile">Choose file...</label>
	        	</div>
	        	<br>
	        	<br>
	        	<input type="submit" value="Upload Image" class="btn btn-primary">
	        </form>
	      </div>
	    </div>
	  </div>
	</div>