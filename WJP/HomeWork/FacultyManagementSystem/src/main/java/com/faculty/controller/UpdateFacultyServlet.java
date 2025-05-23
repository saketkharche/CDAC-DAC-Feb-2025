package com.faculty.controller;

import java.io.IOException;

import com.faculty.dao.FacultyDAO;
import com.faculty.model.Faculty;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateFacultyServlet
 */
@WebServlet("/updateFaculty")
public class UpdateFacultyServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Faculty f = new Faculty();
        f.setId(Integer.parseInt(req.getParameter("id")));
        f.setName(req.getParameter("name"));
        f.setDepartment(req.getParameter("department"));
        f.setEmail(req.getParameter("email"));
        f.setQualification(req.getParameter("qualification"));

        FacultyDAO dao = new FacultyDAO();
        dao.updateFaculty(f);

        resp.sendRedirect("listFaculty.jsp");
    }
}
