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
	width: 100%;
	height: 480px;
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

.generate a {
	text-decoration: none;
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
		<li><a href="/admin/viewreview">View Reviews</a></li>
		<li  class="active"><a href="">Report</a></li>
		<li class="btn"><a><form:form
					action="${pageContext.request.contextPath}/logout" method="POST">

					<input type="submit" value="Logout" />

				</form:form> </a></li>
	</ul>
	<br>	
	<div class="id1">
		<table border="1">
	
			<tr>
				<th>Appointment Id</th>
				<th>Vendor Id</th>
				<th>Vendor Name</th>
				<th>Vendor Contact Info</th>
				<th>Customer Id</th>
				<th>Customer Name</th>
				<th>Customer Contact Info</th>
				<th>Service</th>
				<th>Status</th>
			</tr>
			<c:forEach var="report" items="${report}">
				<tr>
					<td>${report.appointmentId}</td>
					<td>${report.vendorId}</td>
					<td>${report.vendorName}</td>
					<td>${report.vendorContactNumber}</td>
					<td>${report.customerId}</td>
					<td>${report.customerName}</td>
					<td>${report.customerContactNumber}</td>
					<td>${report.serviceType}</td>
					<td>${report.status}</td>
				</tr>
			</c:forEach>
			<tr class="generate">
				<td colspan="9"><a href="/admin/generateReport">Generate
						Excel</a></td>
			</tr>
		</table>

	</div>

</body>

</html>