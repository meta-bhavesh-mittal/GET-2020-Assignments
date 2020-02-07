package com.metaparking;

	import java.sql.*;

	public class EmployeeDB
	{	
		static Statement getConnection(String db_name,String user,String pass)
		{
			Statement stmt = null;
			try
			{
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/"+db_name,user,pass);   
				stmt=con.createStatement();  

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}


			return stmt;

		}



	}




