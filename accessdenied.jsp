<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body {
	background-image: url("/images/notauthorized.png");
	background-repeat: no-repeat;
	background-size: cover;
	opacity: .8;
}

div {
	position: absolute; 
	margin: auto;
	top: 0;
	bottom: 0;
	left: 0;
	right: 0;
	height:20px;
	width:115px;
}
a{
text-decoration: none;
background-color: red;
color: white;
padding:10px;
border-radius:5px;
opacity: .8;
}
a:hover{
background: black;
}
</style>
</head>
<body>

	<div>
		<a href="${pageContext.request.contextPath}/">Back to Home</a>
	</div>
</body>
</html>