package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/AddStudent")
public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddStudent() {
		super();
		// TODO Auto-generated constructor stub
	}




	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/*
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("hi your servelet");
		PrintWriter out = response.getWriter();
		out.println("servlet called");

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fatherName = request.getParameter("fatherName");
		String email = request.getParameter("email");
		String classs = (request.getParameter("classs"));
		String age = (request.getParameter("age"));
		//		System.out.println(firstName);
		//		System.out.println(lastName);
		//		System.out.println(fatherName);
		//		System.out.println(email);
		//		System.out.println(classs);
		//		System.out.println(age);

		try
		{
			Statement smt = StudentDB.getConnection("student_database","root", "root");
			String query = String.format("insert into student2 values('%s','%s','%s','%s','%s','%s')",firstName,lastName,fatherName,email,classs,age );
			smt.executeUpdate(query);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}

}
