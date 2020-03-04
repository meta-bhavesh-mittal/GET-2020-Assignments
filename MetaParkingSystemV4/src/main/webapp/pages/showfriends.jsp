<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/headerAfterLogin.jsp"%>

<div class="container">
	<div class="jumbotron text-center text-primary">Your Friends</div>

	<c:forEach var="friend" items="${friends}">
		<div class="card friend-card text-center">
			<div class="card-header bg-primary text-light">Name :
				${friend.fullName}</div>
			<div class="card-body text-left">
				<p class="card-text">Gender : ${friend.gender}</p>
				<p class="card-text">Email Id : ${friend.emailId}</p>
				<p class="card-text">Contact Number : ${friend.contactNumber}</p>
				<p class="card-text">Org. Name : ${friend.orgName}</p>
				<a href="getFriend/${friend.empId}" class="btn btn-primary">Go
					to Profile</a>
			</div>
		</div>
	</c:forEach>
</div>
<%@ include file="../includes/footer.jsp"%>
