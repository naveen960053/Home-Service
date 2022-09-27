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
	background-image: url("/images/bg3.jpg");
	/*background-repeat: no-repeat;*/
	background-size: cover;
	opacity: .8;
}

ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

li a:hover {
	background-color: #111;
}

.active {
	background-color: green;
}
</style>
</head>
<body>

	<ul>
		<li><a class="active" href="users/home">Home</a></li>
		<li><a href="#">Medicines</a></li>
		<li><a href="#">FirstAid Kit</a></li>
		<li><a href="#">Medical Equipments</a></li>
		<li><a href="#">Health Items</a></li>
		<li><a href="#">Your Cart</a></li>
	</ul>


	<h1>Home</h1>
	<p>Welcome ${userName} !!</p>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">

		<input type="submit" value="Logout" />

	</form:form>

	<a href="${pageContext.request.contextPath}/admin/hello">Only for Admin</a>



</body>

</html>