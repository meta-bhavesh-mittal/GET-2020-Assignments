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
import javax.servlet.http.HttpSession;

import com.metaparking.EmployeeDB;

/**
 * Servlet implementation class EmployeeRegister
 */
@WebServlet("/EmployeeRegister")
public class EmployeeRegister extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EmployeeRegister() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub

		System.out.println("hi your servelet");
		PrintWriter out = response.getWriter();
		out.println("servlet called");
		boolean flag = true;

		String fullname = request.getParameter("fname");
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String contact = (request.getParameter("contact"));
		String company = (request.getParameter("company"));
		String repassword = request.getParameter("confirmpassword");

		//flag = validate(email, password, contact, repassword );
		if(flag)
		{

			try
			{
				Statement smt = EmployeeDB.getConnection("employee_database","root", "root");
				String query = String.format("insert into employee values(employeeId,'%s','%s','%s','%s','%s','%s')",fullname,gender,email,password,contact,company);
				smt.executeUpdate(query);
				ResultSet result = smt.executeQuery(String.format("SELECT * FROM employee WHERE email='%s' AND password='%s'",email,password));
				result.next();
				HttpSession session = request.getSession();
				session.setAttribute("empId",result.getString("employeeId"));
				response.sendRedirect("vehicle.jsp");
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		}
		else
		{
			response.sendRedirect("employee.html");
		}


	}

/*	public boolean validate(String email , String password , String contact , String repassword) 
	{

		if (email == null) {

			return false;
		}

		if (password == null) {

			return false;
		}

		if (contact == null) {

			return false;
		}

		
		if (password.length() < 8) {

			return false;
		}

		if (!password.matches("\\w*\\s+\\w*")) {

			return false;
		}
		
		if (!password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")) {

			return false;
		}
		
		if(password != repassword){
			
			return false;
		}

		else if(contact.length() >10) {

			return false;
		}

		return true;
	}
*/
}
