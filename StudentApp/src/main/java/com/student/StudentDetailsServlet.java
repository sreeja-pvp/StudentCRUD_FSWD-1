package com.student;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentDetailsServlet
 */
@WebServlet("/StudentDetailsServlet")
public class StudentDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 private static final Logger logger = Logger.getLogger(StudentDetailsServlet.class.getName()); 


	DB_Operations op = new DB_Operations();

	public StudentDetailsServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String submitAction = request.getParameter("submit");

		if (submitAction != null) {
			String registeredNo = request.getParameter("regNo");
			String student_Name = request.getParameter("name");

			String date = request.getParameter("dob");

			String gender = request.getParameter("gender");
			String branch = request.getParameter("branch");
			int year = Integer.parseInt(request.getParameter("year").trim());
			
			String semester = request.getParameter("semester");
			String college_Name = request.getParameter("collegeName");

			Student s = new Student(registeredNo, student_Name, date, gender, branch, year, semester, college_Name);
			try {
				op.insertStudentDetails(s);
				logger.log(Level.INFO,"Student with RegNo : " +s.getRegisteredNo() +" Details have been successflly saved!!! ");
				getStudentDetails(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				//response.sendRedirect("ErrorServlet?message=" + e.getMessage());
				  logger.log(Level.SEVERE, "Error displaying student details", e); // Log the exception with details
				  
			}

		}

		if (request.getParameter("deleteRegNo") != null) {
			String deleteRegNo = request.getParameter("deleteRegNo");
			try {
				deleteStudentDetails(deleteRegNo, request, response);
				getStudentDetails(request, response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.sendRedirect("ErrorServlet?message= Student with regNO : " + deleteRegNo + " not deleted...");
				 logger.log(Level.SEVERE, "Student with regNO : " + deleteRegNo + " not deleted...", e); // Log the exception with details
				  
			}
		}

		if (request.getParameter("updateRegNo") != null) {
			String updateRegNo = request.getParameter("updateRegNo");

			try {
				findByID(updateRegNo, request, response);
				 logger.log(Level.SEVERE, "Student with regNO : " + updateRegNo + " found..."); // Log the exception with details
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				response.sendRedirect("ErrorServlet?message=" + e.getMessage());
			}

		}
		
		if(request.getParameter("edit") != null) {
			try {
				updateStudent(request,response);
				getStudentDetails(request, response);
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String registeredNo = request.getParameter("regNo");
		String student_Name = request.getParameter("name");

		String date = request.getParameter("dob");

		String gender = request.getParameter("gender");
		String branch = request.getParameter("branch");
		int year = Integer.parseInt(request.getParameter("year"));
		String semester = request.getParameter("semester");
		String college_Name = request.getParameter("collegeName");

		Student s = new Student(registeredNo, student_Name, date, gender, branch, year, semester, college_Name);
		op.updateStudent( s);
		
	}

	

	private void findByID(String updateRegNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		Student s = op.findById(updateRegNo);
		if (s != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("EditStudentDetails.jsp");
			request.setAttribute("student", s);
			dispatcher.forward(request, response);
			
		}
	}

	public void deleteStudentDetails(String deleteRegNo, HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		op.deleteStudent(deleteRegNo);
	}
	

	public void getStudentDetails(HttpServletRequest request, HttpServletResponse response) {
		List<Student> studentDetails = null;
		try {
			studentDetails = op.getStudentDetails();
			RequestDispatcher dispatcher = request.getRequestDispatcher("StudentInfoDetails.jsp");
			request.setAttribute("studentDetails", studentDetails);
			dispatcher.forward(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

