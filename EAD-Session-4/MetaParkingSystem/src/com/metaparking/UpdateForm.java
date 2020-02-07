package com.metaparking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.metaparking.EmployeeDB;

/**
 * Servlet implementation class UpdateForm
 */
@WebServlet("/UpdateForm")
public class UpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		System.out.println("hi your servelet");
		PrintWriter out = response.getWriter();
		out.println("servlet called");

		String fullname = request.getParameter("fname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String company = request.getParameter("company");
		String vname = (request.getParameter("vname"));
		String vtype = (request.getParameter("vehicletype"));
		String vnumber = (request.getParameter("vnumber"));
		String identification = (request.getParameter("identification"));
		int empid = Integer.parseInt(request.getParameter("empid"));
		
		
		try
		{
			Statement smt = EmployeeDB.getConnection("employee_database","root", "root");
			ResultSet rs = smt.executeQuery("select * from employee");
			while(rs.next())
			{
				int id = Integer.parseInt(rs.getString("employeeId"));
				if(id == empid)
				{
					String query = String.format("UPDATE employee SET fname = '%s', email = '%s', contact = '%s' , company = '%s'  WHERE employeeId = '%s'",fullname,email,contact,company,empid);				
					smt.executeUpdate(query);
					
					ResultSet rs1 = smt.executeQuery("select * from vehicle");
					while(rs1.next())
					{
						int id1 = Integer.parseInt(rs1.getString("empId"));
						if(id1 == empid)
						{
							String query1 = String.format("UPDATE vehicle SET vehiclename = '%s', type = '%s', vehiclenumber = '%s' , identification = '%s'  WHERE empId = '%s'",vname,vtype,vnumber,identification,empid);				
							smt.executeUpdate(query1);
							response.sendRedirect("employee.html");
						}
					}
					rs1.close();
				
				
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
