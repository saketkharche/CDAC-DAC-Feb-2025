package com.faculty.controller;

import java.io.IOException;

import com.faculty.dao.FacultyDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteFacultyServlet
 */
@WebServlet("/deleteFaculty")
public class DeleteFacultyServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        FacultyDAO dao = new FacultyDAO();
        dao.deleteFaculty(id);

        resp.sendRedirect("listFaculty.jsp");
    }
}
