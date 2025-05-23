package com.cdac.pages;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.cdac.pojos.Course;
import com.cdac.pojos.Student;

/**
 * Servlet implementation class ProcessAdmissionFormServlet
 */
@WebServlet("/process_admission")
public class ProcessAdmissionFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		try (PrintWriter pw = response.getWriter()) {
			// 1. get request parameters - student info
			String fName = request.getParameter("fn");
			String lName = request.getParameter("ln");
			int score = Integer.parseInt(request.getParameter("score"));
			Course myCourse = 
					Course.valueOf(request.getParameter("course").toUpperCase());
			//2. create Student class instance 
			Student newStudent=new Student
					(fName, lName, score, myCourse);
		
			//3. B.L (business logic)
			if(score >= myCourse.getMinScore())
				newStudent.setAdmitted(true);
			pw.print("student details from 1st page - "+newStudent);
			pw.flush();//renders resp
			//3.5 add students details under request scope
			//(such attribute will be marked for GC - after the resp is rendered)
			request.setAttribute("student_details", newStudent);
			//4. Get RequestDispatcher from WC (chain of resources)
			RequestDispatcher rd=
					request.getRequestDispatcher("admission_result");
			//5. forward the clnt to the NEXT page in the SAME request
			rd.forward(request, response);//WC throws - IllegalStateException
			/*
			 * WC - 
			 * 1. Clear (discard) response buffer
			 * 2. suspends exec of this method
			 * 3. invokes next page's doPost
			 * 4. next page can add dyn resp - retained
			 * 5. control comes back n continues....
			 */
			System.out.println("exec control came back....");
		}

	}

}
