<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ include file="../includes/headerAfterLogin.jsp"%>
<script src="../includes/passhandling.js"></script>
<div class="container">
	<div class="jumbotron text-center text-primary">Pass Details</div>
</div>
<div class="container form-container">
	<form:form modelAttribute="pass" action="editPass">
		<div class="form-group">
			<form:hidden path="vehicleId" value="${pass.passId}" />
		</div>
		<div class="form-group">
			<form:select id="passType" path="passType" class="custom-select"
				onchange="updatePassPrice('${vehicleType}')">
				<form:option value="daily">Daily</form:option>
				<form:option value="monthly">Monthly</form:option>
				<form:option value="yearly">Yearly</form:option>
			</form:select>
		</div>
		<div class="form-group">
			<form:hidden id="passPrice" path="passPrice" value="" />
		</div>

		<select class="custom-select" id="currencyType"
			onchange="updatePassPrice('${vehicleType}')">
			<option value="INR">INR</option>
			<option value="USD" selected>USD</option>
			<option value="YEN">YEN</option>
		</select>
		<div class="alert alert-primary text-center">
			Pass Price : <span id="showPassPrice">${pass.passPrice}</span>
		</div>

		<form:button type="submit" class="btn btn-primary">Edit</form:button>
	</form:form>
	<div id = "pass-div"></div>
</div>

<%@ include file="../includes/footer.jsp"%>
