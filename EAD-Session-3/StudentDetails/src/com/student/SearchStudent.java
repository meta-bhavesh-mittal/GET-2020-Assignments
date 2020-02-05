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
 * Servlet implementation class SearchStudent
 */
@WebServlet("/SearchStudent")
public class SearchStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchStudent() {
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
		boolean bln = false;
		if(!bln)
		{
			PrintWriter out = response.getWriter();
			bln=true;
			out.println("<form action='search' method='post'>Enter first Name: <input type='text' name='firstName'><br>"
					+ "<input type='submit' value='search'></form>");
			
		}
		if(bln)
		{

			String firstName = request.getParameter("firstName");
			try
			{
				Statement smt = StudentDB.getConnection("student_database","root", "root");
				ResultSet rs = smt.executeQuery("select * from student2");
				boolean flag = false;
				while(rs.next())
				{

					if(rs.getString(1).equals(firstName))
					{
						response.getWriter().print(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "
								+ " "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+"  "+"<br>");
						flag = true;
						
					}
				}
				if(!flag)
				{
					response.getWriter().print("NO RESULT FOUND TILL NOW");
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
			}

		}
	}

}
