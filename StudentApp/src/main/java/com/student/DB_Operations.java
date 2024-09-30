package com.student;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DB_Operations {
	private Connection getConnection() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db_pvp", "root",
				"sreej@02");
		if (connect == null)
			throw new Exception("Database Connection didn't establish...");
		return connect;
	}

	public void insertStudentDetails(Student s) throws Exception {
		Connection connect = getConnection();

		PreparedStatement p = connect.prepareStatement("insert into student_details values(?,?,?,?,?,?,?,?)");
		p.setString(1, s.getRegisteredNo());
		p.setString(2, s.getStudent_Name());
		p.setDate(3, dateConversion(s.getDOB()));
		p.setString(4, s.getGender());
		p.setString(5, s.getBranch());
		p.setInt(6, s.getYear());
		p.setString(7, s.getSemester());
		p.setString(8, s.getCollege_Name());
		p.executeUpdate();

	}

	public java.sql.Date dateConversion(String dob) throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date = sdf.parse(dob);
		return new java.sql.Date(date.getTime());
	}

	public List<Student> getStudentDetails() throws Exception {
		List<Student> studentList = new ArrayList<Student>();

		Connection connect = getConnection();
		Statement stmt = connect.createStatement();

		ResultSet r = stmt.executeQuery("select * from student_details");
		while (r.next()) {
			String registeredNo = r.getString(1);
			String student_Name = r.getString(2);
			String DOB = r.getString(3);
			String gender = r.getString(4);
			String branch = r.getString(5);
			int year = r.getInt(6);
			String semester = r.getString(7);
			String college_Name = r.getString(8);

			Student s = new Student(registeredNo, student_Name, DOB, gender, branch, year, semester, college_Name);
			studentList.add(s);

		}

		return studentList;

	}

	public void deleteStudent(String deleteRegNo) throws Exception {
		Connection connect = getConnection();
		String query = "delete from student_details where RegisteredNo = ?";
		PreparedStatement p = connect.prepareStatement(query);
		p.setString(1, deleteRegNo);
		System.out.println(p.executeUpdate());
	}

	public void updateStudent(Student s) throws Exception {

		Connection connect = getConnection();
		String updateQuery = "update student_details set   Student_Name = ?,DOB = ?,branch =?,gender=?,year=?,semester=?,College_Name=? where RegisteredNo = ?";
		PreparedStatement p = connect.prepareStatement(updateQuery);
		p.setString(8, s.getRegisteredNo());
		p.setString(1, s.getStudent_Name());
		p.setDate(2, dateConversion(s.getDOB()));
		p.setString(4, s.getGender());
		p.setString(3, s.getBranch());
		p.setInt(5, s.getYear());
		p.setString(6, s.getSemester());
		p.setString(7, s.getCollege_Name());
		
		p.executeUpdate();
	}

	public Student findById(String updateRegNo) throws Exception {
		Connection connect = getConnection();
		Statement stmt = connect.createStatement();

		Student s = null;
		ResultSet r = stmt.executeQuery("select * from student_details");
		while (r.next()) {
			if (r.getString(1).equals(updateRegNo)) {
				String registeredNo = r.getString(1);
				String student_Name = r.getString(2);
				String DOB = r.getString(3);
				String gender = r.getString(4);
				String branch = r.getString(5);
				int year = r.getInt(6);
				String semester = r.getString(7);
				String college_Name = r.getString(8);

				s = new Student(registeredNo, student_Name, DOB, gender, branch, year, semester, college_Name);
			}
		}
		return s;
	}
}
