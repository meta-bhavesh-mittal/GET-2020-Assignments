<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.metaparking.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%
if (session.getAttribute("empId") == null) {
String site = new String("index.jsp");
response.setStatus(response.SC_MOVED_TEMPORARILY);
response.setHeader("Location", site);
}
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">

<title>Insert title here</title>
</head>
<body>

<div class="login">
	<h1>METACUBE PARKING SYSTEM</h1>
	<form action="vehicleRegister" method="post">
	
		<fieldset>
			<legend><b> Vehicle Registration Form </b></legend>
			<input type="text" name="vname" placeholder="Vehicle Name" required="required" />
			<select name="vehicletype">
  					<option value="CYCLE">CYCLE</option>
  					<option value="MOTORBIKE">MOTORBIKE</option>
  					<option value="FOUR-WHEELER">FOUR WHEELER</option>
			</select>
			<input type="text" name="vnumber" placeholder="Vehicle Number" required="required" />
	    	<input type="text" name="empid" value="<%=(String) session.getAttribute("empId")%>" placeholder="Employee ID" readonly/>
	    	<textarea rows="5" cols="20" name="identification" placeholder="Identification"></textarea>
	        <button type="submit" class="btn btn-primary btn-block btn-large">Submit</button>            
		</fieldset>
	</form>
	</div>
</body>
</html>