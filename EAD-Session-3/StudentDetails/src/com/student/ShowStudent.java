package com.student;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowStudent
 */
@WebServlet("/ShowStudent")
public class ShowStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
		Statement smt = StudentDB.getConnection("student_database","root", "root");
		ResultSet rs = smt.executeQuery("select * from student2");
		while(rs.next())
		{
			//response.getWriter().print("<h1 name=\"emailId\" value=\""+rs.getString(4)+"\" disabled >"+"</h1>");
			//request.setAttribute("emailId", rs.getString(4));
			response.getWriter().print(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "
					+ " "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getString(6)+" "
							+ " "+"<form action='update?emailId="+rs.getString(4)+"&firstname="
					+rs.getString(1)+"&lastname="+rs.getString(2)+"&fathername="+rs.getString(3)+
					"&class="+rs.getString(5)+"&age="+rs.getString(6)+"' method='post'>"
							+ "<input type = 'submit' value = 'update item'></form>"+"<br>");
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	
	}

}
