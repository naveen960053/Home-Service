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
</style>
</head>
<body>

	<ul>
		<li class="active"><a href="/">Home</a></li>
		<li><a href="/admin/viewreview">View Reviews</a></li>
		<li><a href="/admin/report">Report</a></li>
		<li class="btn"><a><form:form
					action="${pageContext.request.contextPath}/logout" method="POST">

					<input type="submit" value="Logout" />

				</form:form> </a></li>
	</ul>


	<h1>Home</h1>
	<p>Welcome ${userName} !!</p>



</body>

</html>