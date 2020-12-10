<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ItsFRZ</title>
<title>Add Data</title>
		
		 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		
</head>
<body>
	
	<div class="container">
		<table class="table">
		  <thead>
		    <tr>
		 
		      <th scope="col">Id</th>
		      <th scope="col">Name</th>
		      <th scope="col">Download</th>
		    </tr>
		  </thead>
		  <tbody>
		   <c:forEach items="${allData }" var="temp">
		   	 <tr>
		      <td>${temp.id}</td>
		      <td>${temp.name}</td>
		      <td><a href="downloadFile?id=${temp.id}" class="class="btn btn-success btn-sm"">Download</a></td>
		      
		    </tr>
		   </c:forEach>
		  </tbody>
		</table>
	</div>

</body>
</html>