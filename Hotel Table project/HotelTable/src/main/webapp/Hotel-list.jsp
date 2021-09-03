<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>User Management Application</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>

<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand"> Hotel table recieptent app </a>
			</div>

			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Hotels</a></li>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Hotels</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Add
					New hotel</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>No</th>
						<th>Name</th>
						<th>Number</th>
						<th>Designation</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--  received the list form UserServlet
					
					 for (Hotel hotel:listhotel) {  -->
					<!-- 
					     System.out.print(u.name+""+u.number+""+u.designation)
					 -->
					
					<c:forEach var="hotel" items="${listHotel}">

						<tr>
							<td><c:out value="${hotel.no}" /></td>
							<td><c:out value="${hotel.name}" /></td>
							<td><c:out value="${hotel.number}" /></td>
							<td><c:out value="${hotel.designation}" /></td>
							<td><a href="edit?no=<c:out value='${hotel.no}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="delete?no=<c:out value='${hotel.no}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>

</html>