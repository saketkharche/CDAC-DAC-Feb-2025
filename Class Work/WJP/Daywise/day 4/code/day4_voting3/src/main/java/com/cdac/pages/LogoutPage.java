package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

import com.cdac.dao.CandidateDaoImpl;
import com.cdac.dao.UserDaoImpl;
import com.cdac.pojos.User;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/logout")
public class LogoutPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("<h5>in logout page.</h5>");
			// 1. get HttpSession from WC
			HttpSession session = request.getSession();
			System.out.println("from logout page - session id " + session.getId());// same
			System.out.println("from logout page - session is new " + session.isNew());// f
			// 2. invalidate Http Session
			session.invalidate();
			pw.print("<h5>You have logged out....</h5>");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. set cont type
		response.setContentType("text/html");
		// 2. get writer(PW)
		try (PrintWriter pw = response.getWriter()) {
			// 3. get Http Session from WC
			HttpSession session = request.getSession();
			// 4. get daos n user details
			UserDaoImpl userDao = (UserDaoImpl) session.getAttribute("user_dao");
			CandidateDaoImpl candidateDao = (CandidateDaoImpl) session.getAttribute("candidate_dao");
			User user = (User) session.getAttribute("user_info");
			// 5 . render hello user name
			pw.print("<h5>Hello , " + user.getFirstName() + " " + user.getLastName() + "</h5>");
			// 6. update voting status
			pw.print("<h5> " + userDao.updateVotingStatus(user.getUserId()) + "</h5>");
			int candidateId = Integer.parseInt
					(request.getParameter("candidateId"));
			// 7 . increment votes
			pw.print("<h5> " 
			+ candidateDao
			.incrementCandidateVotes(candidateId)+"</h5>");
			session.invalidate();
			pw.print("<h6> You have logged out ....</h6>");
		} catch (Exception e) {
			// re throw the exc
			throw new ServletException("err in doPost", e);
		}
	}
}
