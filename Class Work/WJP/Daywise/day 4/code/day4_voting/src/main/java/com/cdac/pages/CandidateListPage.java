package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import com.cdac.pojos.User;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		try(PrintWriter pw=response.getWriter())
		{
			pw.print("in candidate list page.<br/>");
			//1. Get HttpSession from WC
			HttpSession hs=request.getSession();
			System.out.println("session id from list page "+hs.getId());//same 
			System.out.println("is new "+hs.isNew());//false
			//2. Get data from HttpSession
			User userDetails=(User)hs.getAttribute("user_info");
			if(userDetails != null)
			{
				pw.print("<h5> User Details from HttpSession "
			+userDetails+"</h5>");
				//adding a link here - ONLY for testing
				pw.print("<h5><a href='logout'>Log Me Out</a></h5>");
				
			} else //=> no cookies !
			    pw.print("<h5>No Cookies ,a new HttpSession , clnt info is lost .... session tracking failed , "
			    		+ "Can't Continue !!!!!</h5>");//null | not null(email)
		}
	}

}
