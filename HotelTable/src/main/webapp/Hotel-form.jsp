<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

<head>
<title>Hotel table recipient Application</title>
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
				<a href="#" class="navbar-brand"> Table Recipient App </a>
			</div>

			<ul class="navbar-nav">	
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Hotels</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${hotel != null}">
					<form action="update" method="post">
				</c:if>
				<c:if test="${hotel == null}">
					<form action="insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${hotel != null}">
                                    Edit User
                                </c:if>
						<c:if test="${hotel == null}">
                                    Add New User
                                </c:if>
					</h2>
				</caption>

				<c:if test="${hotel != null}">
					<input type="hidden" name="no" value="<c:out value='${hotel.no}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Hotel Name</label> <input type="text"
						value="<c:out value='${hotel.name}' />" class="form-control"
						name="name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Hotel number</label> <input type="text"
						value="<c:out value='${hotel.number}' />" class="form-control"
						name="number">
				</fieldset>

				<fieldset class="form-group">
					<label>User designation</label> <input type="text"
						value="<c:out value='${hotel.designation}' />" class="form-control"
						name="designation">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>

</html>