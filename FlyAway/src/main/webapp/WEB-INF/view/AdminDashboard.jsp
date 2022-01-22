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
background-repeat:no-repeat;
min-height:750px;
background-size:cover;
}
.row:after{
display:table;
clear:both;
content:"";
}
.column{
float:left;
width:32%;
padding:10px;
height:250px;
background-color:dark grey;
}
.card {
  box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
  padding: 26px;
  text-align: center;
  background-color: #f1f1f1;
  height:210px;
}
a{
font-size:33px;
}
</style>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>
<div class="bg-img">

<div class="row">

<div class="column">
<div class="card">
<a href="FlightList">Flight List</a>
</div>
</div>

<div class="column">
<div class="card">
<a href="PlacesList">Airline List & Places List</a>
</div>
</div>

<div class="column">
<div class="card">
<a href="UserList">UserList</a>
</div>
</div>

</div>

</div>

</body>
</html>