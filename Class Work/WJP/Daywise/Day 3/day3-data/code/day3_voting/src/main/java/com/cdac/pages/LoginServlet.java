package com.cdac.pages;

import static com.cdac.utils.DBUtils.closeConnection;
import static com.cdac.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/login", loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;

	/**
	 * @see Servlet#init()
	 */
	/*
	 * overriding form of the method can't throw any new checked exceptions
	 */
	@Override
	public void init() throws ServletException {
		System.out.println("in init");
		try {
			// open cn
			openConnection();
			// create dao instance
			userDao = new UserDaoImpl();
		} catch (Exception e) {
			System.out.println(e);
			/*
			 * Centralized exc handling in Servlets -init How to tell WC that init() has
			 * failed ? - by throwing the exception Create ServletException(String mesg,
			 * Throwable rootCause)
			 */
			throw new ServletException("err in init", e);
		}
	}

	/**
	 * @see Servlet#destroy()
	 */
	@Override
	public void destroy() {
		System.out.println("in destroy");
		try {
			// dao - clean up , close cn
			userDao.cleanUp();
			closeConnection();
		} catch (Exception e) {
			System.out.println("in destroy " + e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// set cont type , get writer , read request data, invoke dao's method - signin
		// 1 set cont type
		response.setContentType("text/html");
		// 2. Get Write(PW) to send text resp
		try (PrintWriter pw = response.getWriter()) {
			// 3. read request parameters - em , pwd
			String email = request.getParameter("em");
			String password = request.getParameter("pass");
			// 4. LoginServlet -> user dao's method
			User user = userDao.signIn(email, password);
			// 5. null checking
			if (user == null) {
				// => invalid login -> send error mesg + retry link
				pw.print("<h5> Invalid Login , " + "Please <a href='login.html'>Retry</a></h5>");
			} else {
				// => valid login 
				//6. Create a Cookie using encoded Cookie value
				String encodedString = URLEncoder.encode(user.toString(), "utf-8");
				Cookie c1=new Cookie("user_details",encodedString);
				//7. Add the cookie to the resp header
				response.addCookie(c1);
				//- > continue to role based authorization
				// pw.print("<h5> Login Successful , Your Details"+user+"</h5>");
				if (user.getUserRole().equals("admin")) // admin user
					response.sendRedirect("admin_dashboard");
				else {
					// voter login
					if (user.isStatus()) // =>voter - already voted
						response.sendRedirect("logout");
					else // voter - not yet voted
						response.sendRedirect("candidate_list");
				}

			}

		} catch (Exception e) {
			// inform WC about the error
			throw new ServletException("err in do-post", e);

		}
	}

}
