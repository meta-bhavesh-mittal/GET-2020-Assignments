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

/**
 * Servlet implementation class VehicleRegister
 */
@WebServlet("/VehicleRegister")
public class VehicleRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VehicleRegister() {
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

		String vehiclename = request.getParameter("vname");
		String vehicletype = request.getParameter("vehicletype");
		String vehiclenumber = request.getParameter("vnumber");
		String empid = request.getParameter("empid");
		String identification = request.getParameter("identification");
		System.out.println(empid);
		try
		{
			Statement smt = EmployeeDB.getConnection("employee_database","root", "root");
			String query = String.format("insert into vehicle values('%s','%s','%s','%s','%s')",vehiclename,vehicletype,vehiclenumber,empid,identification);
			smt.executeUpdate(query);
			ResultSet result = smt.executeQuery(String.format("SELECT * FROM vehicle WHERE empId='%s' AND vehiclenumber='%s'",empid,vehiclenumber));
			result.next();
			HttpSession session = request.getSession();
			session.setAttribute("vtype",result.getString("type"));
			System.out.println(session.getAttribute("vtype"));
			response.sendRedirect("pass.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}
	
	

}
