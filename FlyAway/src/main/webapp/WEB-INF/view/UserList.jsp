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
td {
  text-align: center;
}
a {
  text-decoration:none;
}
button{
  
  background-color: #04AA6D;
  color: white;
}
</style>
</head>
<body>
<script src="https://cdn.datatables.net/1.11.3/css/jquery.dataTables.min.css"></script>
<script type="text/javascript" src="https://cdn.datatables.net/1.11.3/js/jquery.dataTables.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <!--Data Table-->
    <script type="text/javascript"  src=" https://cdn.datatables.net/1.10.13/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"  src=" https://cdn.datatables.net/buttons/1.2.4/js/dataTables.buttons.min.js"></script>
   
<!--Export table button CSS-->
<link rel="stylesheet" href="https://cdn.datatables.net/1.10.13/css/jquery.dataTables.min.css">
<link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.2.4/css/buttons.dataTables.min.css">
<jsp:include page="Header.jsp"></jsp:include>



<table id="example" class="display" cellspacing="0" width="100%">
        <thead>
            <tr>
                <th>User Id</th>
                <th>User Name</th>  
                <th>Ph No</th>     
                <th>Age</th>         
            </tr>
        </thead>
          
        <tbody>
        <c:forEach var="User" items="${User}">
            <tr>
                <td>${User.id}</td>
                <td>${User.userName}</td>
                 <td>${User.phNo}</td>
                  <td>${User.age}</td>
            </tr>
          </c:forEach>
        </tbody>
    </table>

</body>
<script type="text/javascript">
$(document).ready(function() {
    $('#example').DataTable();
} );
</script>
</html>