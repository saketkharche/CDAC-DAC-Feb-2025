package com.cdac.pages;

import static com.cdac.utils.DBUtils.closeConnection;
import static com.cdac.utils.DBUtils.openConnection;

import java.io.IOException;
import java.io.PrintWriter;

import com.cdac.dao.CandidateDaoImpl;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet(value = "/login", loadOnStartup = 1,initParams = {})
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDaoImpl userDao;
	private CandidateDaoImpl candidateDao;	
	
	public LoginServlet() {
		System.out.println("in def ctor - "+getServletConfig());//null
	}

	/**
	 * @see Servlet#init()
	 */
	/*
	 * overriding form of the method can't throw any new checked exceptions
	 */
	@Override
	public void init() throws ServletException {
		ServletContext ctx=getServletContext();
		System.out.println("in init - "+ctx);//not null - F.Q name of imple class - catalina
		try {
			//get ctx params from ServletContext
			String url=ctx.getInitParameter("db_url");
			String userName=ctx.getInitParameter("user_name");
			String pwd=ctx.getInitParameter("password");
			
			// open cn
			openConnection(url,userName,pwd);
			// create dao instances
			userDao = new UserDaoImpl();
			candidateDao=new CandidateDaoImpl();
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
			candidateDao.cleanUp();
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
				//6. get HttpSession from WC
				HttpSession session =request.getSession();
				System.out.println("session id - "+session.getId());
				System.out.println("session is new "+session.isNew());//t
				//7. add user info under session scope
				session.setAttribute("user_info", user);
				//7.5 store dao instances under session scope
				session.setAttribute("user_dao", userDao);
				session.setAttribute("candidate_dao", candidateDao);
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
