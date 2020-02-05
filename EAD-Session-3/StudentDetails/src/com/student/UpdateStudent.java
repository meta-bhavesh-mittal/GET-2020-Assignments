package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateStudent
 */
@WebServlet("/UpdateStudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateStudent() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		out.println("<form id='abc' action='update' method='post' onsubmit='fun()'>"
				+ "First_NAME <input type='text' name='firstName' value=\""+request.getParameter("firstname")+"\" ><br>"
				+ "Last_NAME <input type='text' name='lastName' value=\""+request.getParameter("lastname")+"\" ><br>"
				+ "Father_NAME <input type='text' name='fatherName' value=\""+request.getParameter("fathername")+"\" ><br>"
				+ "Email <input type='email' name='email'value=\""+request.getParameter("emailId")+"\" readonly><br>"
				+ "Class <input type='text' name='classs' value=\""+request.getParameter("class")+"\" ><br>"
				+ "Age <input type='text' name='age' value=\""+request.getParameter("age")+"\" > <br>"
				+ "<input type='submit'></form>");
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classs = (request.getParameter("classs"));
		String age = (request.getParameter("age"));

		try
		{
			Statement smt = StudentDB.getConnection("student_database","root", "root");
			ResultSet rs = smt.executeQuery("select * from student2");
			boolean flag = false;
			while(rs.next())
			{
				if(rs.getString(4).equals(email))
				{
					String query = String.format("UPDATE student2 SET fname = '%s', lname = '%s', father = '%s' , classs = '%s' , age = '%s' WHERE email = '%s'",firstName,lastName,fatherName,classs,age,email);				
					smt.executeUpdate(query);
					response.sendRedirect("addStudent.html");
					//out.println("VALUE IS UPDATED");
					
					flag = true;
					break;
				}
			}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}




	}

}
