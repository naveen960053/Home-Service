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
	padding: 16px;
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
	width: 600px;
	height: 480px;
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
	border-collapse: collapse;
	text-align: center;
}

th {
	padding: 15px;
	background-color: #263238;
	color: white;
}

td {
	padding: 10px;
	background-color: black;
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

.pending {
	background-color: red;
	opacity: .8;
}

.completed {
	background-color: green;
	opacity: .8;
}
</style>
</head>
<body>

	<ul>
		<li><a href="/">Home</a></li>
		<li><a href="/user/role/bookservice">Book Service</a></li>
		<li class="active"><a href="/user/role/mybooking">My Bookings</a></li>
		<li><a href="/user/role/review">Feedback</a></li>
		<li><a href="#">Profile</a></li>
		<li class="btn"><a><form:form
					action="${pageContext.request.contextPath}/logout" method="POST">

					<input type="submit" value="Logout" />

				</form:form> </a></li>
	</ul>




	<div class="id1">

		<c:choose>
			<c:when test="${not empty booking}">
				<table border="1">
					<tr>
						<th>Appointment Id</th>
						<th>Vendor Id</th>
						<th>Vendor Name</th>
						<th>Contact Info</th>
						<th>Service</th>
						<th>Work Status</th>
					</tr>
					<c:forEach var="booking" items="${booking}">
						<tr>
							<td>${booking.appointmentId}</td>
							<td>${booking.vendorId}</td>
							<td>${booking.vendorName}</td>
							<td>${booking.customerContactNumber}</td>
							<td>${booking.serviceType}</td>
							<c:if test="${booking.status =='Pending'}">
								<td class="pending">${booking.status}</td>
							</c:if>
							<c:if test="${booking.status =='Completed'}">
								<td class="completed">${booking.status}</td>
							</c:if>


						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<br>
			 No Bookings Available

		</c:otherwise>
		</c:choose>
	</div>

</body>

</html>