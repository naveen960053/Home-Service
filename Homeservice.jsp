<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
}

.center {
	width: 300px;
	height: 250px;
	position: absolute;
	top: 0;
	padding-right: 30px;
	padding-top: 30px; bottom : 0;
	left: 0;
	right: 0;
	margin: auto;
	color: white;
	opacity: .9;
	background-color: black;
	bottom: 0;
	border-radius:5px;
	box-shadow: 10px 10px 5px white;
}

a {
	text-decoration: none;
	color: white;
}

ul {
	left: 0;
}

ul li {
	padding: 10px;
	background-color: gray;
	color: white;
	list-style-type: none;
}

li:hover {
	background-color: red;
	color: white;
}

.msg {
	border-radius: 10px;
	background: gray;
	opacity: .7;
	padding: 10px;
	margin-left: 40px;
}

.heading {
	width: 300px;
	
	top: 0;
	padding:15px;
	bottom: 0;
	left: 0;
	right: 0;
	margin: auto;
	text-align: center;
	color: black;
	font-size: 25px;
	background-color: white;
	opacity: .8;
	border-radius: 15px;
	box-shadow: 10px 10px 5px black;
}
</style>

</head>
<body>

	<div class="heading">Home Service Application</div>

	<div class="center">
		<c:if test="${param.error != null}">

			<div class="msg">Invalid Credentials</div>

		</c:if>
		<c:if test="${param.logout != null}">

			<div class="msg">You have been logged out</div>

		</c:if>
		<ul>
			<li><a href="/user/login">USER</a></li>
			<br>
			<li><a href="/admin/login">ADMIN</a></li>
			<br>
			<li><a href="/vendor/login">VENDOR</a></li>
		</ul>
	</div>


</body>
</html>