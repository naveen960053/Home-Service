<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>



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
	height: 450px;
	position: absolute;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	color: white;
	opacity: .9;
}

table, th, td {
	border: 2px solid black;
	border-collapse: collapse;
	padding-right: 20px;
	text-align: center;
}

th {
	background-color: #009879;
	color: black;
}

td {
	background-color: gray;
	color: black;
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
		<li class="active"><a href="/user/role/bookservice">Book
				Service</a></li>
		<li><a href="/vendor/role/home">Vendor</a></li>
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
		<c:choose>
			<c:when test="${not empty serviceList}">
				<table border="1">
					<tr>
						<th>Vendor Id</th>
						<th>Vendor Name</th>
						<th>Location</th>
						<th>Category</th>
						<th>Service</th>
						<th>Timings</th>
						<th>Contact Info</th>
						<th>Book</th>
					</tr>
					<c:forEach var="service" items="${serviceList}">
						<tr>
							<td>${service.vendorId}</td>
							<td>${service.name}</td>
							<td>${service.location}</td>
							<td>${service.category}</td>
							<td>${service.serviceCategory}</td>
							<td>${service.serviceTimings}</td>
							<td>${service.contactNumber}</td>
							<td><a
								href="/user/role/book/${service.vendorId}/${service.location}/${service.serviceCategory}">Book</a></td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
			Oops!! No Service Available

		</c:otherwise>
		</c:choose>
	</div>



</body>

</html>