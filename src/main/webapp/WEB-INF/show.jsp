<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page import = "java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

<title>Books MVC</title>
</head>
<body>
	<div class="container">
		<h1>Book Detail</h1>
		<div class="row">
			<div class="col-md-6">
				<ul class="list-group">
				  <li class="list-group-item d-flex justify-content-between align-items-center active">${person.firstName} ${person.lastName}</li>
				  <li class="list-group-item d-flex justify-content-between align-items-center">
				  	License Number: <span class="badge badge-pill">${person.getLicense().getNumber()}</span>
				  	</li>
				  <li class="list-group-item d-flex justify-content-between align-items-center">
				    State: <span class="badge badge-pill">${person.getLicense().getState()}</span>
				  </li>
				  <li class="list-group-item d-flex justify-content-between align-items-center">
				    Expiration Date:<span class="badge badge-pill">${person.getLicense().getExpiration_date()}</span>
				  </li>
				</ul>
			</div>
		</div>
		<br>
		<a href="/persons/new" class="btn btn-sm btn-primary">Go Back</a>
	</div>
</body>
</html>
