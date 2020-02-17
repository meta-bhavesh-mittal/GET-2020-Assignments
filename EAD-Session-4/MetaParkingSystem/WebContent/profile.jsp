<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.metaparking.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Insert title here</title>
</head>
<body>

	<div class="profile">
	
		<h1 id="a1">METACUBE PARKING SYSTEM</h1>
			<center>
				<fieldset>
					<legend style="font-size:20px"><b> Profile </b></legend>
					<h1>Employee Id : <%=(String) session.getAttribute("empId")%></h1>
					<h1>Employee Name : <%=(String) session.getAttribute("fname")%></h1>
					<h1>Employee Gender : <%=(String) session.getAttribute("gender")%></h1>
					<h1>Employee Email : <%=(String) session.getAttribute("email")%></h1>
					<h1>Employee Contact : <%=(String) session.getAttribute("contact")%></h1>
					<h1>Employee Company : <%=(String) session.getAttribute("company")%></h1>
					<h1>Vehicle Name : <%=(String) session.getAttribute("vehiclename")%></h1>
					<h1>Vehicle Type : <%=(String) session.getAttribute("type")%></h1>
					<h1>Vehicle Number : <%=(String) session.getAttribute("vehiclenumber")%></h1>
					<h1>Identification : <%=(String) session.getAttribute("identification")%></h1>
<a href="update.jsp" >  <button class="btn btn-primary" style="position: absolute;left: 110%;top:10%;">Update</button> </a>
<a href="employee.html" >  <button class="btn btn-primary" style="position: absolute;left: 120%;top:10%;">Logout</button> </a><br>
<br>
				</fieldset>	
			</center>
	</div>
	
</body>
</html>