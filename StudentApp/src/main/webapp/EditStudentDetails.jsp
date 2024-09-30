<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<title>Student Update Form</title>
<style>
body {
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
	background-color: #f5f5f5; /* Light grey background for the webpage */
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
}

.card {
	background: #af84b3;
	border-radius: 8px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	width: 500px;
	padding: 20px;
	box-sizing: border-box;
}

.card h2 {
	margin-top: 0;
	margin-bottom: 20px;
	color: white;
	text-align: center;
}

.form-group {
	display: flex;
	margin-bottom: 15px;
	align-items: center;
}

.form-group label {
	flex: 1;
	margin-right: 10px;
	color: white;
	text-align: left;
}

.form-group input, .form-group select {
	flex: 2;
	padding: 8px;
	border: 1px solid #ddd;
	border-radius: 4px;
	box-sizing: border-box;
}

.form-group input[type="submit"], .form-group input[type="reset"] {
	background: #009688;
	color: white;
	border: none;
	cursor: pointer;
	text-align: center;
	margin-right: 10px;
	width: 48%;
}

.form-group input[type="submit"]:hover, .form-group input[type="reset"]:hover
	{
	background: #00796b;
}

.form-group .reset-button {
	background: #f44336; /* Red background for reset button */
}

.form-group .reset-button:hover {
	background: #c62828; /* Darker red for hover effect */
}

.two-columns {
	display: flex;
	justify-content: space-between;
}

.two-columns>div {
	flex: 1;
	margin-right: 10px;
}

.two-columns>div:last-child {
	margin-right: 0;
}
</style>
</head>
<body>


	<div class="card">
		<h2>Student Update Form</h2>
		<form action="StudentDetailsServlet" method="get">
			<div class="form-group">
				<label for="regNo">Registered No:</label> <input type="text"
					id="regNo" name="regNo" value="${student.registeredNo}" required>
			</div>
			<div class="form-group">
				<label for="name">Student Name:</label> <input type="text" id="name"
					name="name" value="${student.student_Name}" required>
			</div>
			<div class="form-group">
				<label for="dob">DOB:</label> <input type="date" id="dob" name="dob"
					value="${student.DOB}" required>
			</div>
			<div class="form-group">
				<label for="gender">Gender:</label> <select id="gender"
					name="gender" required>

					<c:if test="${empty student.gender}">
						<option value="" disabled selected>Select your gender</option>
					</c:if>

					<c:if test="${not empty student.gender}">
						<option value="${student.gender}" >${student.gender}</option>
					</c:if>



					<option value="male">Male</option>
					<option value="female">Female</option>
					<option value="other">Other</option>
				</select>
			</div>
			<div class="form-group">
				<label for="branch">Branch:</label> <input type="text" id="branch"
					name="branch" value="${student.branch}" required>
			</div>
			<div class="form-group two-columns">
				<div>
					<label for="year">Year:</label> <select id="year" name="year"
						required>
						
						
				<c:if test="${empty student.year}">
						<option value="" disabled selected>Select year</option>
					</c:if>

					<c:if test="${not empty student.gender}">
						<option value="${student.year}" >${student.year}</option>
					</c:if>
						
						<option value="1">1</option>
						<option value="2">2</option>
						<option value="3">3</option>
						<option value="4">4</option>
					</select>
				</div>
				<div>
					<label for="semester">Semester:</label> <select id="semester"
						name="semester" required>
						
						<c:if test="${empty student.semester}">
						<option value="" disabled selected>Select Semester</option>
					</c:if>

					<c:if test="${not empty student.gender}">
						<option value="${student.semester}" >${student.semester}</option>
					</c:if>
						
						
						
						<option value="I">I</option>
						<option value="II">II</option>
					</select>
				</div>
			</div>
			<div class="form-group">
				<label for="collegeName">College Name:</label> <input type="text"
					id="collegeName" name="collegeName" value="${student.college_Name}"
					required>
			</div>
			<div class="form-group">
				<input type="submit" value="edit" name="edit"> <input
					type="reset" value="Reset" class="reset-button">
			</div>
		</form>
		<div class="text-center">
			<a class=" btn btn-info" href="Home.jsp" style="margin: 10px;">Go
				To Home</a>
		</div>
	</div>

</body>
</html>
