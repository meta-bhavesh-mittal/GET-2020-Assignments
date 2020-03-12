<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ include file="../includes/header.jsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<form action="/login" method="post">
		<div class="form-group">
		<div class="alert alert-primary text-center" role="alert">
			${SPRING_SECURITY_LAST_EXCEPTION.message}
		</div>
		<label for="exampleInputEmail1">Email address</label> <input
				type="text" class="form-control" name="username" id="exampleInputEmail1"
				aria-describedby="emailHelp" placeholder="Enter email"> <small
				id="emailHelp" class="form-text text-muted">We'll never
				share your email with anyone else.</small>
		</div>
		<div class="form-group">
			<label for="exampleInputPassword1">Password</label> <input
				type="password" class="form-control" name="password" id="exampleInputPassword1"
				placeholder="Password">
		</div>
		<input name="_csrf" type="hidden" value="d20b7a2c-2054-4ccf-8f7c-8b9941036fdb" />
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>

<%@ include file="../includes/footer.jsp"%>
