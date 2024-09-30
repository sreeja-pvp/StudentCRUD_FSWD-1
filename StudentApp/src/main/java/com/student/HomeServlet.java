package com.student;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	DB_Operations op = new DB_Operations();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("details")!= null){
			
			List<Student> studentDetails = null;
			try {
				 studentDetails = op.getStudentDetails();
				RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfoDetails.jsp");
				request.setAttribute("studentDetails", studentDetails);
				dispatcher.forward(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.sendRedirect("ErrorServlet?message=Object is null");			}
		}
		
		if(request.getParameter("add")!= null) {
			response.sendRedirect("StudentForm.html");
		}
			
	}

	

}
