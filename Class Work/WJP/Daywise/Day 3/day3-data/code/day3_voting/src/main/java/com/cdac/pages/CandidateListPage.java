package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

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
			//1. get Cookie from the request header.
			Cookie[] cookies=request.getCookies();
			if(cookies != null)
			{
				//=> getting a cookie/s from req header
				Cookie c1=cookies[0];
				String decodedString = URLDecoder.decode(c1.getValue(), "utf-8");
				pw.print("<h5> User Details from the cookie"
				+decodedString+"</h5>");
			} else //=> no cookies !
			    pw.print("<h5>No Cookies , session tracking failed , "
			    		+ "Can't Continue !!!!!</h5>");//null | not null(email)
		}
	}

}
