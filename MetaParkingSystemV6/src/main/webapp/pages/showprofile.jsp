<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ include file="../includes/headerAfterLogin.jsp"%>

<div class="container">
	<div class="jumbotron text-center text-primary">
		${friend.fullName}</div>
	<ul class="list-group">
		<li class="list-group-item active">Name : ${friend.fullName}</li>
		<li class="list-group-item">Gender : ${friend.gender}</li>
		<li class="list-group-item">Email Id : ${friend.emailId}</li>
		<li class="list-group-item">Contact Number :
			${friend.contactNumber}</li>
		<li class="list-group-item">Org. Name : ${friend.orgName}</li>
	</ul>
</div>

<%@ include file="../includes/footer.jsp"%>
