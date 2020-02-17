<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.metaparking.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="login">
	<a href="employee.html" >  <button class="btn btn-primary" style="position: absolute;left: 190%;top:10%;">Logout</button> </a><br>

	<h1>METACUBE PARKING SYSTEM</h1>
	<form action="update" method="post">
	
		<fieldset>
			<legend><b> Update Registration Form </b></legend>
			<input type="text" value="<%=(String) session.getAttribute("fname")%>" name="fname" placeholder="Full Name" required="required" />
	    	<input type="email" name="email" value="<%=(String) session.getAttribute("email")%>" placeholder="Email Id" required="required" />
	    	<input type="text" name="contact" value="<%=(String) session.getAttribute("contact")%>" placeholder="Contact" required="required" />
	    	<select name="company">
  					<option value="<%=(String) session.getAttribute("company")%>" selected><%=(String) session.getAttribute("company")%></option>  			
  					<option value="ATCS">ATCS</option>
  					<option value="METACUBE">METACUBE</option>
  					<option value="INTIMETECH">INTIMETECH</option>
 					<option value="INFOSYS">INFOSYS</option>
			</select><br>
			<input type="text" name="vname" placeholder="Vehicle Name" value="<%=(String) session.getAttribute("vehiclename")%>" required="required" />
			<select name="vehicletype" >
			  		<option value="<%=(String) session.getAttribute("type")%>" selected><%=(String) session.getAttribute("type")%></option>
  					<option value="CYCLE">CYCLE</option>
  					<option value="MOTORBIKE">MOTORBIKE</option>
  					<option value="FOUR-WHEELER">FOUR WHEELER</option>
			</select>
			<input type="text" name="vnumber" placeholder="Vehicle Number" value="<%=(String) session.getAttribute("vehiclenumber")%>" required="required" />
	    	<input type="text" name="empid" value="<%=(String) session.getAttribute("empId")%>" placeholder="Employee ID" readonly/>
	    	<textarea rows="5" cols="20" name="identification" placeholder="Identification"><%=(String) session.getAttribute("identification")%></textarea>
	        <button type="submit" class="btn btn-primary btn-block btn-large">Update</button>            
		</fieldset>
	</form>
	</div>
</body>
</html>