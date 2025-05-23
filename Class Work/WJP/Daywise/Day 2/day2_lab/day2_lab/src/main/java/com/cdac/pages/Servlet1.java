package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
/*
 * @WebServlet - class level , run time annotation(=WC) This annotation will be
 * read by WC , only once at the web app deployment time Meaning - To tell WC ,
 * to create a mapping between incoming url-pattern with the servlet URL ->
 * http://host:port/day2_lab/test1 
 * url pattern : /test1 WC creates a map key -
 * /test1 value -fully qualified servlet class name (eg -
 * com.cdac.pages.Servlet1)
 * 
 */
//@WebServlet("/test1") - reflection
public class Servlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see Servlet#init()
	 */
	public void init() throws ServletException {
		System.out.println("in init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("in destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("in doGet");
		//dev steps 1. set response  content type - text/html
		response.setContentType("text/html");
		//2. To send dynamic response - of text type
		/*
		 * API of ServletResponse i/f (super i/f of HttpServletResponse)
		 * public PrintWriter getWriter() throws IOException
		 */
		try (PrintWriter pw=response.getWriter()) {
			//3. send the resp - simply use print | write method of PrintWriter
			pw.print("<h4>Hello from Servlet1 at "+LocalDateTime.now()+"</h4>");
		}
	}

}
