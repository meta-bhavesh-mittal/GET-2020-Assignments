<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.metaparking.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*,javax.servlet.annotation.WebServlet,com.metaparking.EmployeeDB"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
	<%
		try {
			Statement smt = EmployeeDB.getConnection("employee_database","root", "root");
			ResultSet rs = smt.executeQuery("select * from student2");
			while (rs.next()) {
					
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
<title>Insert title here</title>
</head>
<body>

	<%
		try {
			Statement smt = EmployeeDB.getConnection("student_database","root", "root");
			ResultSet rs = smt.executeQuery("select * from student2");
			while (rs.next()) {

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	%>
	<div class="login">
		<h1>METACUBE PARKING SYSTEM</h1>
		<table style="width: 100%">
			<tr>
				<th>Firstname</th>
				<th>Lastname</th>
				<th>Age</th>
			</tr>
			<tr>
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
			</tr>

		</table>
	</div>
</body>
</html>