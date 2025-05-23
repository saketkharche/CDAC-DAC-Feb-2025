package com.cdac.pages;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import com.cdac.dao.CandidateDaoImpl;
import com.cdac.pojos.Candidate;
import com.cdac.pojos.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminPage
 */
@WebServlet("/candidate_list")
public class CandidateListPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			pw.print("in candidate list page.<br/>");
			// 1. Get HttpSession from WC
			HttpSession hs = request.getSession();
			System.out.println("session id from list page " + hs.getId());// same
			System.out.println("is new " + hs.isNew());// false
			// 2. Get data from HttpSession
			User userDetails = (User) hs.getAttribute("user_info");
			if (userDetails != null) {
				// existing session
				// get candodate dao from session
				CandidateDaoImpl dao = (CandidateDaoImpl) hs.getAttribute("candidate_dao");
				pw.print("<h5> Hello , " + userDetails.getFirstName() + " " + userDetails.getLastName() + "</h5>");
				// invoke dao's methos
				List<Candidate> allCandidates = dao.getAllCandidates();
				// pw.print(allCandidates);
				// dynamic form generation n rendering
				pw.print("<form method='post' action='logout'>");
				for (Candidate c : allCandidates) {
					pw.print("<h5><input type='radio' "
							+ "name='candidateId' value='" 
							+ c.getCandidateId() + "' />"
							+ c.getName() + "</h5>");
				}
				// <input type submit- to vote
				pw.print("<h5><input type='submit' value='Vote'/></h5>");
				pw.print("</form>");

			} else // => no cookies !
				pw.print("<h5>No Cookies ,a new HttpSession , clnt info is lost .... session tracking failed , "
						+ "Can't Continue !!!!!</h5>");// null | not null(email)

		} catch (Exception e) {
			// re throw the excepetion to caller - WC
			throw new ServletException("err in doPost", e);
		}
	}

}
