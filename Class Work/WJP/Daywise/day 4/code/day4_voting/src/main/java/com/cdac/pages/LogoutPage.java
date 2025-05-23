package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/logout")
public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("<h5>in logout page.</h5>");
			//1. get HttpSession from WC
			HttpSession session=request.getSession();
			System.out.println("from logout page - session id "+session.getId());//same 
			System.out.println("from logout page - session is new "+session.isNew());//f
			//2. invalidate Http Session
			session.invalidate();
			pw.print("<h5>You have logged out....</h5>");
		}
	}

}
