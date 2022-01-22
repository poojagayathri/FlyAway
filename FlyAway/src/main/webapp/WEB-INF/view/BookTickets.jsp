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
max-width:50%;
margin: auto;
 padding: 10%;
left: 30%;
top:30%;
}
input {
     width:100%;
     padding: 15px;
     margin: 5px 0 22px 0;
     display: inline-block;
}
</style>
<jsp:include page="Header.jsp"></jsp:include>
<br/>
</head>
<body>


<div class="bg-img">
<form:form method="POST" modelAttribute="userDetails" action="BookTicket">

<div class="container">
${msg} <br/>
<label>Name</label>
<form:input path="userName" required="required" />
<label>Age</label>
<form:input path="age" required="required" /><br/>


<label>Phone Number</label>
<form:input type="number" maxlength="10" minlength="10" path="phNo" /><br/>

<input type="hidden" name="flightId" value="${flightId}" />

<form:button>Submit Details</form:button>
</div>
</form:form>
</div>

</body>
</html>