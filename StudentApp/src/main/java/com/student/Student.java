package com.student;

public class Student {
	private String registeredNo;
	private String student_Name;
	private String DOB;
	private String gender;
	private String branch;
	private int year;
	private String semester;
	private String college_Name;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String registeredNo, String student_Name, String dOB, String gender, String branch, int year,
			String semester, String college_Name) {
		super();
		this.registeredNo = registeredNo;
		this.student_Name = student_Name;
		DOB = dOB;
		this.gender = gender;
		this.branch = branch;
		this.year = year;
		this.semester = semester;
		this.college_Name = college_Name;
	}
	public String getRegisteredNo() {
		return registeredNo;
	}
	public void setRegisteredNo(String registeredNo) {
		this.registeredNo = registeredNo;
	}
	public String getStudent_Name() {
		return student_Name;
	}
	public void setStudent_Name(String student_Name) {
		this.student_Name = student_Name;
	}
	public String getDOB() {
		return DOB;
	}
	public void setDOB(String dOB) {
		DOB = dOB;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getSemester() {
		return semester;
	}
	public void setSemester(String semester) {
		this.semester = semester;
	}
	public String getCollege_Name() {
		return college_Name;
	}
	public void setCollege_Name(String college_Name) {
		this.college_Name = college_Name;
	}
	@Override
	public String toString() {
		return "Student [registeredNo=" + registeredNo + ", student_Name=" + student_Name + ", DOB=" + DOB + ", gender="
				+ gender + ", branch=" + branch + ", year=" + year + ", semester=" + semester + ", college_Name="
				+ college_Name + "]";
	}
	
	
}
