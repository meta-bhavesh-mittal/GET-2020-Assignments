<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	    <%@ page import="com.metaparking.*"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*"%>
<%
if (session.getAttribute("vtype") == null) {
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
<script>
			
		var USD_RATE = 0.014;
		var YEN_RATE = 1.53;
		var type;
		var pricedaily;
		var pricemonthly;
		var priceyearly;
		var selectedtype;
		
		
		function changeCurrency()
		{
			var currtype = document.getElementById("curr").value;
			type = "<%=(String) session.getAttribute("vtype")%>";
			if(currtype == "INR")
			{
				if(type == "CYCLE")
				{
			        document.getElementById("dailyprice").innerHTML = 5 + " INR";
			        document.getElementById("monthlyprice").innerHTML = 100 + " INR";
			        document.getElementById("yearlyprice").innerHTML = 500 + " INR";
			        
			        pricedaily = 5;
			        pricemonthly = 100;
			        priceyearly = 500;
			        selectedtype = "INR";
		
				}
				else if(type == "MOTORBIKE")
				{
			        document.getElementById("dailyprice").innerHTML = 10 + " INR";
			        document.getElementById("monthlyprice").innerHTML = 200 + " INR";
			        document.getElementById("yearlyprice").innerHTML = 1000 + " INR";
			        
			        pricedaily = 10;
			        pricemonthly = 200;
			        priceyearly = 1000;
			        selectedtype = "INR";
				}
				else
				{
					document.getElementById("dailyprice").innerHTML = 20 + " INR";
			        document.getElementById("monthlyprice").innerHTML = 500 + " INR";
			        document.getElementById("yearlyprice").innerHTML = 3500 + " INR";
			        
			        pricedaily = 20;
			        pricemonthly = 500;
			        priceyearly = 3500;
			        selectedtype = "INR";
				}
			}
		
			else if(currtype == "USD")
			{
				if(type == "CYCLE")
				{
			        document.getElementById("dailyprice").innerHTML = (5 * USD_RATE).toFixed(2) + " USD";
			        document.getElementById("monthlyprice").innerHTML = (100 * USD_RATE).toFixed(2) + " USD";
			        document.getElementById("yearlyprice").innerHTML = (500 * USD_RATE).toFixed(2) + " USD";
					
			        pricedaily = (5 * USD_RATE).toFixed(2);
			        pricemonthly = (100 * USD_RATE).toFixed(2);
			        priceyearly = (500 * USD_RATE).toFixed(2);
			        selectedtype = "USD";
			        
				}
				else if(type == "MOTORBIKE")
				{
			        document.getElementById("dailyprice").innerHTML = (10 * USD_RATE).toFixed(2) + " USD";
			        document.getElementById("monthlyprice").innerHTML = (200 * USD_RATE).toFixed(2) + " USD";
			        document.getElementById("yearlyprice").innerHTML = (1000 * USD_RATE).toFixed(2) + " USD";
					
			        pricedaily = (10 * USD_RATE).toFixed(2);
			        pricemonthly = (200 * USD_RATE).toFixed(2);
			        priceyearly = (1000 * USD_RATE).toFixed(2);
			        selectedtype = "USD";
			        
				}
				else
				{
					document.getElementById("dailyprice").innerHTML = (20 * USD_RATE).toFixed(2) + " USD";
			        document.getElementById("monthlyprice").innerHTML = (500 * USD_RATE).toFixed(2) + " USD";
			        document.getElementById("yearlyprice").innerHTML = (3500 * USD_RATE).toFixed(2) + " USD";
				
			        pricedaily = (20 * USD_RATE).toFixed(2);
			        pricemonthly = (500 * USD_RATE).toFixed(2);
			        priceyearly = (3500 * USD_RATE).toFixed(2);
			        selectedtype = "USD";
				}
			}
		
			else 
			{
				if(type == "CYCLE")
				{
			        document.getElementById("dailyprice").innerHTML = (5 * YEN_RATE).toFixed(2) + " YEN";
			        document.getElementById("monthlyprice").innerHTML = (100 * YEN_RATE).toFixed(2) + " YEN";
			        document.getElementById("yearlyprice").innerHTML = (500 * YEN_RATE).toFixed(2) + " YEN";
					
			        pricedaily = (5 * YEN_RATE).toFixed(2);
			        pricemonthly = (100 * YEN_RATE).toFixed(2);
			        priceyearly = (500 * YEN_RATE).toFixed(2);
			        selectedtype = "YEN";
				}
				else if(type == "MOTORBIKE")
				{
			        document.getElementById("dailyprice").innerHTML = (10 * YEN_RATE).toFixed(2) + " YEN";
			        document.getElementById("monthlyprice").innerHTML = (200 * YEN_RATE).toFixed(2) + " YEN";
			        document.getElementById("yearlyprice").innerHTML = (1000 * YEN_RATE).toFixed(2) + " YEN";
					
			        pricedaily = (10 * YEN_RATE).toFixed(2);
			        pricemonthly = (200 * YEN_RATE).toFixed(2);
			        priceyearly = (1000 * YEN_RATE).toFixed(2);
			        selectedtype = "YEN";
				}
				else
				{
					document.getElementById("dailyprice").innerHTML = (20 * YEN_RATE).toFixed(2) + " YEN";
			        document.getElementById("monthlyprice").innerHTML = (500 * YEN_RATE).toFixed(2) + " YEN";
			        document.getElementById("yearlyprice").innerHTML = (3500 * YEN_RATE).toFixed(2) + " YEN";
				
			        pricedaily = (20 * YEN_RATE).toFixed(2);
			        pricemonthly = (500 * YEN_RATE).toFixed(2);
			        priceyearly = (3500 * YEN_RATE).toFixed(2);
			        selectedtype = "YEN";
				}
			}
		}
		
		function makePassDaily() {

		    document.getElementById("recipt").innerHTML = "you have to pay !! " + pricedaily + " " + selectedtype + "  At Admin";
		    document.getElementById("idpass").style.display = "none";
		}


		function makePassMonthly() {
		    document.getElementById("recipt").innerHTML = "you have to pay !!  " + pricemonthly + " " + selectedtype + "  At Admin";
		    document.getElementById("idpass").style.display = "none";
		}


		function makePassYearly() {
		    document.getElementById("recipt").innerHTML = "you have to pay !!  " + priceyearly + " " + selectedtype +"  At Admin";
		    document.getElementById("idpass").style.display = "none";
		}

</script>
<title>Insert title here</title>
</head>
<body>
<div class="login">
		<h1>METACUBE PARKING SYSTEM</h1>
</div>
	<div class="pass">
	<a href="employee.html" >  <button class="btn btn-primary" style="position: absolute;left: 120%;top:10%;">Home</button> </a><br>
			<div id="idpass">
				<fieldset  id="vehicle">
					<legend><b>Select Pass </b></legend>
					 <h1 id="vehicle"><%=(String) session.getAttribute("vtype")%></h1>
	                <select id="curr" onchange="changeCurrency()">
	                    <option disabled selected>Choose Currency</option>
	                    <option value="USD">USD</option>
	                    <option value="INR">INR</option>
	                    <option value="YEN">YEN</option>
	                </select>
					
					<div class="flex-container">
						<div class="card">
							<h1>1 Day</h1>
							<p id="dailyprice">Choose Currency</p>
							<p><button class="cardButton" value="Make Pass" 
							onclick="makePassDaily()">Make Pass</button></p>
						</div>
						<div class="card">
							<h1>1 Month</h1>
							<p id="monthlyprice">Choose Currency</p>
							<p><button class="cardButton" value="Make Pass"
							onclick="makePassMonthly()">Make Pass</button></p>
						</div>
						<div class="card">
							<h1>1 Year</h1>
							<p id="yearlyprice">Choose Currency</p>
							<p><button class="cardButton" value="Make Pass"
							onclick="makePassYearly()">Make Pass</button></p>
						</div>
					</div>
				</fieldset>
			</div><br>
			
		<fieldset id="fs">
                <legend><b>Payable Amount</b></legend>
                <h1 id="recipt"> No Bill Amount</h1>
        </fieldset>
	</div>
</body>
</html>