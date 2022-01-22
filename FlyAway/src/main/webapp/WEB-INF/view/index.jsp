<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page isELIgnored = "false" %>
<html>
<head>
<style>
.bg-img{
background-image:url('Image/airlines.jpg');
min-height: 100%;
background-repeat: no-repeat;
background-size:cover;
}
.clearfix::after {
	clear:both;
	content:"";
	display:table;
}
input,select {
     width:100%;
     padding: 15px;
     margin: 5px 0 22px 0;
     display: inline-block;
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

</style>
</head>
<body>

<jsp:include page="Header.jsp"></jsp:include>

<div class="bg-img">
<form:form method="POST" action="SearchFlight" modelAttribute="flight">
<div class="container">

<div class="clearfix">
<label>FROM</label>
<form:select path="fromPlaceId" items="${placesList}" itemValue="id" itemLabel="placeName" required="required"></form:select>

<label>TO</label>
<form:select path="toPlaceId" items="${placesList}" itemValue="id" itemLabel="placeName" required="required"></form:select><br/>
</div>

<label>DEPATURE DATE</label>
<form:input type="date" path="departureDate" required="required" /><br/>
<label>NO OF PERSON</label>
<input type="number" name="noOfPersons" required/><br/>
<form:button class="search">Search Flights </form:button>
</div>
</form:form>
</div>

</body>
</html>
