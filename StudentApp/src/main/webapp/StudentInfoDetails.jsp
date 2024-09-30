<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List,com.student.Student"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"
	integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.min.js"
	integrity="sha384-w1Q4orYjBQndcko6MimVbzY0tgp4pWB4lZ7lr30WKz0vr/aWKhXdBNmNb5D92v7s"
	crossorigin="anonymous"></script>
<meta charset="UTF-8">
<title>Student Details</title>
</head>
<body>
	<table class="table">
		<tr>
			<td><a class=" btn btn-info" href="Home.jsp"
				style="margin: 10px;">Home</a></td>
				<td><a class="btn btn-info" href="HomeServlet?add=AddstudentDetails" class="btn">Add New
				Student Details</a></td>
			<td><h1 class="text-center">Student Details</h1></td>
		</tr>
		<tr class="table table-primary">
			<th>Registered No</th>
			<th>Student Name</th>
			<th>DOB(YYYY/MM/DD)</th>
			<th>Gender</th>
			<th>Branch</th>
			<th>Year</th>
			<th>Semester</th>
			<th>College Name</th>
			<th>Action</th>
		</tr>

		<c:forEach var="student" items="${studentDetails}">
			<tr>
				<td>${student.registeredNo}</td>
				<td>${student.student_Name}</td>
				<td>${student.DOB}</td>
				<td>${student.gender}</td>
				<td>${student.branch}</td>
				<td>${student.year}</td>
				<td>${student.semester}</td>
				<td>${student.college_Name}</td>
				<td><a
					href="StudentDetailsServlet?updateRegNo=${student.registeredNo}"><button
							class="btn btn-danger">Update</button></a> <a
					href="StudentDetailsServlet?deleteRegNo=${student.registeredNo}"><button
							class="btn btn-danger">Delete</button></a></td>
			</tr>
		</c:forEach>

	</table>

</body>
</html>