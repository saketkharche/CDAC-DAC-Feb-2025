package com.cdac.pages;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cdac.pojos.Student;

/**
 * Servlet implementation class AdmissionResultPage
 */
@WebServlet("/admission_result")
public class AdmissionResultPage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		// get student details from - request scope
		Student student = (Student) request.getAttribute("student_details");
		// last page in chian of RequestDispatcher - it generate resp
		pw.print("<h5> Hello " + student.getFirstName() + " " + student.getLastName() + "</h5>");
		if (student.isAdmitted()) {
			pw.print("<h5> Congratulations ! , " + "You are admitted in the Course " + student.getSelectedCourse()
					+ "</h5>");
		} else {
			pw.print("<h5> Sorry ! , " + "You are not admitted in the Course " + student.getSelectedCourse() + "</h5>");
		}
		
	}

}
