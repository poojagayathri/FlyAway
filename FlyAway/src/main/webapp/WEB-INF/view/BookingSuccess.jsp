<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored = "false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
.bg-img{
background-image:url('Image/airlines.jpg');
min-height: 750px;
background-repeat: no-repeat;
background-size:cover;
}
.center{
font-size:50px;
padding: 18% 33%;
color:green;
}
</style>
</head>
<body>
<jsp:include page="Header.jsp"></jsp:include>
<div class="bg-img">
<div class="center">Booking Success !!!!</div>

</div>
</body>
</html>