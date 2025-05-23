package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(value="/hello")
public class HelloWordServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("in do-get");
		/*
		 * objective - test servlet life cycle + render dynamic rep
		 */
		// 1. set response content type
		resp.setContentType("text/html");
		// 2. To send resp from server -> clnt - text resp (PrintWriter)
		/*
		 * java.io.PrintWriter - buffered writer Get Writer from HttpServletResp public
		 * PrintWriter getWriter() throws IOException
		 */
		try (PrintWriter pw = resp.getWriter()) {
			//send the resp
			pw.print("<h4> Welcome 2 Servlets @ "
			+LocalDateTime.now()+"</h4>");
		} //JVM - pw.close() -> pw.flush() -> buffer contents -> sent resp buffer -> clnt
	}

	@Override
	public void destroy() {
		System.out.println("in destroy ");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("in init ");
	}

}
