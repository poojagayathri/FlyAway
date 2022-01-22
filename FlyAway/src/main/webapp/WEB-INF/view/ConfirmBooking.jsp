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
min-height: 100%;
background-repeat: no-repeat;
background-size:cover;
}
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}
.container{
padding: 14px 20px;
font-size:20px;
}
table,th,td{
border: 1px solid black;
}
</style>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<br/>
<form method="post" action="BookTicket">
<div class="bg-img">
<div class="container">

<table>
<tr>
<td>Flight No</td>
<td>64AE2O${flight.id}</td>
</tr>

<tr>
<td>Timings</td>
<td>${flight.departureTime} - ${flight.arrivalTime} </td>
</tr>

<tr>
<td>No Of Person</td>
<td>${noOfSeats}</td>
</tr>

</table>


<button type="submit">Confirm Booking</button>
<input type="hidden" name="flightId" value="${flightId}" />
</div>
</div>
</form>
</body>
</html>