package com.cdac.pages;

import static com.cdac.utils.DBUtils.closeConnection;
import static com.cdac.utils.DBUtils.openConnection;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(value = "/", loadOnStartup = 1)
public class FrontController extends HttpServlet {
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
		ServletContext ctx = getServletContext();
		try {
			// get ctx params from ServletContext
			String url = ctx.getInitParameter("db_url");
			String userName = ctx.getInitParameter("user_name");
			String pwd = ctx.getInitParameter("password");

			// open cn
			openConnection(url, userName, pwd);
			// create dao instances
			userDao = new UserDaoImpl();

		} catch (Exception e) {
			System.out.println(e);
			throw new ServletException("err in init", e);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			/*
			 * Navigation logic URL 1. http://host:port/ctx_path/ 2.
			 * http://localhost:7070/ctx_path/delete?id=3
			 * http://localhost:7070/ctx_path/update_form?id=1
			 * http://localhost:7070/ctx_path/update , method=POST , payload - user id n
			 * password
			 */
			// 1. get servlet path - excludes query string

			String path = request.getServletPath();
			System.out.println(path);
			String prefix = "/WEB-INF/views/";
			String suffix = ".jsp";
			String viewName = null;
			switch (path) {
			case "/":
				listAllUsers(request);
				viewName = prefix + "list" + suffix;// view name - /WEB-INF/views/list.jsp
				break;
			case "/delete":
				deleteUser(request);
				// instead of forward , use redirect -> /
				response.sendRedirect("./");
				return;
			case "/update_form":
				showUpdateForm(request);
				viewName = prefix + "update_form" + suffix;
				break;
			case "/update":
				processUpdateForm(request);
				// instead of forward , use redirect -> /
				response.sendRedirect("./");
				break;
			}
			// 2. forward
			if (viewName != null) {
				RequestDispatcher rd = request.getRequestDispatcher(viewName);
				rd.forward(request, response);
			}
		} catch (Exception e) {
			throw new ServletException("err in do-get", e);
		}
	}

	private void processUpdateForm(HttpServletRequest request) throws SQLException {
		// get request parameters - id , password
		// parse user id from the req parameter
		int userId = Integer.parseInt(request.getParameter("id"));
		String password = request.getParameter("pass");
		// invoke dao's method to update user details
		userDao.updateUserDetails(userId, password);
	}

	private void showUpdateForm(HttpServletRequest request) throws SQLException {
		// parse user id from the req parameter
		int userId = Integer.parseInt(request.getParameter("id"));
		// invoke dao's method -get user details
		User userDetails = userDao.getUserDetails(userId);
		request.setAttribute("user_details", userDetails);
	}

	private void deleteUser(HttpServletRequest request) throws SQLException {
		// parse user id from the req parameter
		int userId = Integer.parseInt(request.getParameter("id"));
		// 1. invoke User Dao's method
		userDao.deleteUser(userId);

	}

	private void listAllUsers(HttpServletRequest request) throws SQLException {
		// invoke dao's method
		List<User> users = userDao.listUsers();
		// add the results under request scope , as an attribute
		// since RD's forward will be used for the navigation
		request.setAttribute("user_list", users);
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

}
