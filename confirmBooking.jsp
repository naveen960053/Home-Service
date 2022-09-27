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
	height: 480px;
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
	padding: 15px;
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

.generate a {
	text-decoration: none;
	background-color: gray;
	padding:10px;
	border-radius: 10px;
}

.generate {
	text-align: center;
	background-color: skyblue;
	text-decoration: none;
}
</style>
</head>
<body>

	<ul>
		<li><a href="/">Home</a></li>
		<li class="active"><a>Book Service</a></li>
		<li><a href="">Payment</a></li>
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

		<table class="center">
			<caption class="heading">Booking Details</caption>

			<tr>
				<td>Customer Id</td>
				<td>:</td>
				<td>${booking.customerId}</td>
			</tr>
			<tr>
				<td>Customer Name</td>
				<td>:</td>
				<td>${booking.customerName}</td>
			</tr>
			<tr>
				<td>Customer Contact Info</td>
				<td>:</td>
				<td>${booking.customerContactNumber}</td>
			</tr>
			<tr>
				<td>Vendor Id</td>
				<td>:</td>
				<td>${booking.vendorId}</td>
			</tr>
			<tr>
				<td>Vendor Name</td>
				<td>:</td>
				<td>${booking.vendorName}</td>
			</tr>
			<tr>
				<td>Vendor Contact Info</td>
				<td>:</td>
				<td>${booking.vendorContactNumber}</td>
			</tr>
			<tr>
				<td>Status</td>
				<td>:</td>
				<td>Booked</td>
			</tr>
			<tr class="generate">
				<td colspan="3"><a href="/user/role/payment/${booking.serviceType}/${booking.appointmentId}">Proceed to Payment</a></td>
			</tr>
		</table>
	</div>



</body>

</html>