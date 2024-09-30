<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<style>
body {
	background-color: cream;
}

h1 {
	text-align: center;
	color: green;
}

div {
margin-top: 10%;	
	
}
</style>
</head>
<body>

	<h1>Welcome to Student Portal</h1>
	<div  class="text-center">		
			<a class="btn btn-info" href="HomeServlet?details=studentDetails">StudentDetails</a>		
			<a class="btn btn-info" href="HomeServlet?add=AddstudentDetails" class="btn">Add New
				Student Details</a>
	</div>	
	
</body>
</html>