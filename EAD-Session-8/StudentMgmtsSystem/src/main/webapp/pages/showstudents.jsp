<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../includes/header.jsp"%>

<div class="container">
	<table class="table table-dark">
		<thead>
			<tr>
				<th scope="col">Id</th>
				<th scope="col">First Name</th>
				<th scope="col">Last Name</th>
				<th scope="col">Father's Name</th>
				<th scope="col">Email</th>
				<th scope="col">Class</th>
				<th scope="col">Age</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
				<tr>
					<th scope="row">${student.id}</th>
					<th>${student.first_name}</th>
					<th>${student.last_name}</th>
					<th>${student.father_name}</th>
					<th>${student.email}</th>
					<th>${student.std}</th>
					<th>${student.age}</th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@ include file="../includes/footer.jsp"%>
