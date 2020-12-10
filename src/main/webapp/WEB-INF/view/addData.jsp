<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
	<title>ItsFRZ</title>
		
		 <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-giJF6kkoqNQ00vy+HMDP7azOuL0xtbfIcaT9wjKHr8RbDVddVHyTfAAsrekwKmP1" crossorigin="anonymous">
		
</head>
<body>
	
	<div class="container">
			<form action="upload" method="POST" enctype="multipart/form-data">
				
				<input type="text" name="id" class="form-control mb-4 col-4" placeholder="Id">
				<!-- <input type="text" name="name" class="form-control mb-4 col-4"> -->
				<input type="file" name="data" class="form-control mb-4 col-4">
				
				
				<button type="submit" class="btn btn-success btn-lg">Save</button>
				<a href="download" class="btn btn-success btn-lg">Download</a>
			</form>
		</div>

</body>
</html>