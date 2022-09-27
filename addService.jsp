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
	padding: 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.active {
	background-color: green;
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
		<li><a href="/vendor/role/home">Home</a></li>
		<li class="active"><a href="">Add Service</a></li>
		<li><a href="/vendor/role/addcategory">Add Category</a></li>
		<li><a href="/vendor/role/appointment">Appointments</a></li>
		<li><a href="/vendor/role/profile">Profile</a></li>
		<li class="btn"><a><form:form
					action="${pageContext.request.contextPath}/logout" method="POST">

					<input type="submit" value="Logout" />

				</form:form> </a></li>
	</ul>


	<p>Welcome ${userName} !!</p>

	<div class="id1">
		<form:form action="/vendor/role/addservice" method="post"
			modelAttribute="AddService">

			<table class="center">
				<caption class="heading">Add Service Details</caption>
				<tr>
					<td>Category:</td>
					<td><form:select path="category" items="${categoryList}" /></td>
				</tr>
				<tr>
					<td>Service:</td>
					<td><form:select path="serviceCategory"
							items="${serviceList}" /></td>
				</tr>
				<tr>
					<td>Contact Info:</td>
					<td><form:input path="contactNumber" /></td>
				</tr>
				<tr>
					<td>Service Timings:</td>
					<td><form:input path="serviceTimings" placeholder="From-To" /></td>
				</tr>
				<tr>
					<td>Location:</td>
					<td><form:select path="location" items="${locationList }" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="ADD"></td>
					<td><input type="reset" value="CLEAR"></td>
				</tr>


			</table>
		</form:form>
	</div>
</body>

</html>