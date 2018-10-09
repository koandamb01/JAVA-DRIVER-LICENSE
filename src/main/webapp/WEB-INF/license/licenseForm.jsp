<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<%@ page import = "java.io.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<style>
	form{ display: inline; }
</style>
<title>License Dept-</title>
</head>
<body>
	<div class="container">
		<h1>New License</h1>
		<br><br>
		<div class="row">
			<div class="col-md-6">
				<form:form action="/licenses/new" method="POST" modelAttribute="license">
			    <div class="form-group">
			        <form:select path="person" class="form-control">
			            <form:options items="${persons}" itemValue="id" itemLabel="firstName"/>
			        </form:select>
			    </div>
			    
			    <div class="form-group">
			        <form:label path="state">State:</form:label>
			        <form:errors path="state" class="text-danger"/>
			        <form:input path="state" class="form-control"/>
			    </div>
			    
			    <div class="form-group">
			        <form:label path="expiration_date">Expiration Date: </form:label>
			        <form:errors path="expiration_date" class="text-danger"/>
			        <form:input path="expiration_date" type="date" class="form-control"/>
			    </div>
			    
			    <input type="submit" value="Create" class="btn btn-primary"/>
			</form:form>    
			</div>
		</div>
	</div>
</body>
</html>
