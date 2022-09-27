<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>



<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url("/images/bg2.jpeg");
	/*background-repeat: no-repeat;*/
	background-size: cover;
	opacity: .8;
}

ul {
	list-style-type: none;
	margin: 0px;
	padding: 0px;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	height: 49px;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 15px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.active {
	background-color: red;
}

.btn {
	float: right;
	background-color: black;
	cursor: pointer;
}

.id1 {
	width: 500px;
	height: 360px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	background-color: black;
	margin: auto;
	color: white;
	opacity: .9;
}

table, th, td {
	border-collapse: collapse;
}

th, td {
	padding: 20px;
	background-color: green;
	color: white;
}

table.center {
	margin-left: auto;
	margin-right: auto;
}

.heading {
	padding: 20px;
	font-size: 20px;
}

select {
	padding: 5px;
	width: 170px;
}

input[type=text] {
	padding: 5px;
}
</style>
</head>
<body>

	<ul>
		<li><a href="/">Home</a></li>
		<li class="active"><a>Book Service</a></li>
		<li><a href="/user/role/mybooking">My Bookings</a></li>
		<li><a href="/user/role/review">Feedback</a></li>
		<li><a href="#">Profile</a></li>
		<li class="btn"><a><form:form
					action="${pageContext.request.contextPath}/logout" method="POST">

					<input type="submit" value="Logout" />

				</form:form> </a></li>
	</ul>


	<h1>Home</h1>
	<p>Welcome ${userName} !!</p>
	<div class="id1">
		<form:form action="/user/role/bookservice" method="post"
			modelAttribute="bookService">

			<table class="center">
				<caption class="heading">Enter Details</caption>
				<tr>
					<td>Category:</td>
					<td><form:select path="category" items="${ categoryList}" /></td>
				</tr>


				<tr>
					<td>Service:</td>
					<td><form:select path="serviceName" items="${ serviceList}" /></td>
				</tr>

				<tr>
					<td>Location:</td>
					<td><form:select path="location" items="${locationList }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Search" /></td>
					<td><input type="reset" value="Clear" /></td>
				</tr>
			</table>
		</form:form>
	</div>



</body>

</html>