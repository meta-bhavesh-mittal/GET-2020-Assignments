package com.metaparking;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.metaparking.EmployeeDB;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Login() {
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
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		//		response.getWriter().print("<style>table, th, td {border: 1px solid black;}</style>"
		//				+ "<table style='table-layout:fixed'><col style='width:20%' span='6'/>"
		//				+ "<tr><th>EmpId</th><th>Full Name</th><th>Gender</th><th>"
		//				+ "Email Id</th><th>Contact</th><th>Company</th></tr></table>");
		try
		{
			Statement smt = EmployeeDB.getConnection("employee_database","root", "root");
			ResultSet rs = smt.executeQuery("select * from employee");

			while(rs.next())
			{
				if(rs.getString("email").equals(email) && rs.getString("password").equals(password))
				{
					int empid = Integer.parseInt(rs.getString("employeeId"));
					HttpSession session = request.getSession();
					session.setAttribute("empId",rs.getString("employeeId"));
					session.setAttribute("fname",rs.getString("fname"));
					session.setAttribute("gender",rs.getString("gender"));
					session.setAttribute("email",rs.getString("email"));
					session.setAttribute("contact",rs.getString("contact"));
					session.setAttribute("company",rs.getString("company"));


					ResultSet rs1 = smt.executeQuery("select * from vehicle");

					while(rs1.next())
					{
						
						if(empid == Integer.parseInt(rs1.getString("empId")))
						{
							
							session.setAttribute("vehiclename",rs1.getString("vehiclename"));
							session.setAttribute("type",rs1.getString("type"));
							session.setAttribute("vehiclenumber",rs1.getString("vehiclenumber"));
							session.setAttribute("identification",rs1.getString("identification"));

							response.sendRedirect("profile.jsp");
						}

					}
					rs1.close();
				}
			}
			rs.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
