package com.faculty.controller;

import java.io.IOException;

import com.faculty.dao.FacultyDAO;
import com.faculty.model.Faculty;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EditFacultyServlet
 */
@WebServlet("/editFaculty")
public class EditFacultyServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        FacultyDAO dao = new FacultyDAO();
        Faculty f = dao.getFacultyById(id);

        req.setAttribute("faculty", f);
        RequestDispatcher rd = req.getRequestDispatcher("editFaculty.jsp");
        rd.forward(req, resp);
    }
}
