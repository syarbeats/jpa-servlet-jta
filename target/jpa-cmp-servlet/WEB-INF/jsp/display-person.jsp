<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Display Person</title>
<link rel="stylesheet" href="./css/JSP-Styles.css">
<link rel="stylesheet" href="./css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="row" style="margin-top: 30px">
			<div class="col-md-6 offset-4">
				<nav class="navbar navbar-light bd-faded">
				<h2>
					<label class="alert-primary text-sm-center">JPA IN SERVLET</label>
				</h2>
				</nav>
			</div>
		</div>

	<div class="row" style="margin-top: 30px">
			<div class="col-md-6 offset-4">
				<nav class="navbar navbar-light bd-faded">
				<h3>
					<label class="alert-primary text-sm-center">Person List</label>
				</h3>
				</nav>
			</div>
		</div>

		<div class="row" style="margin-top: 30px">
			<div class="col-md-8 offset-3">
				<table BORDER=1 ALIGN="CENTER" class="table">
					<thead class="thead-dark">
					<tr>
					    <th CLASS="TITLE">ID</th>
						<th CLASS="TITLE">FIRSTNAME</th>
						<th CLASS="TITLE">LASTNAME</th>
						<th CLASS="TITLE">FAV_PROG_LANG</th>
						
					</tr>
                    </thead>
                    <tbody>	
                    	<c:forEach items="${geekList}" var="geek">		
						<tr>
							<td>${geek.id}</td>
							<td>${geek.firstName}</td>
							<td>${geek.lastName}</td>
							<td>${geek.favouriteProgrammingLanguage}</td>
						</tr>
						</c:forEach>			
                  </tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>