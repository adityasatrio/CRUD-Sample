<!DOCTYPE html>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="req" value="${pageContext.request}" />
<c:set var="url">${req.requestURL}</c:set>
<c:set var="uri" value="${req.requestURI}" />
<c:set var="urlContext"
	value="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

<html lang="en">
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="test">
<meta name="author" content="asn">

<title>Elevenia Test Crud</title>

<!-- Bootstrap core CSS -->
<link href="<c:url value="/resources/css/bootstrap.css"/>"
	rel="stylesheet">

<!-- Custom styles for this template -->
<link href="<c:url value="/resources/css/jumbotron-narrow.css"/>"
	rel="stylesheet">

<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<div class="container">
		<div class="header">
			<nav>
				<ul class="nav nav-pills pull-right">
					<li role="presentation" class="active"><a href="#">Home</a></li>
					<li role="presentation"><a href="#">About</a></li>
					<li role="presentation"><a href="#">Contact</a></li>
				</ul>
			</nav>
			<h3 class="text-muted">Elevenia Test Crud</h3>
		</div>
		<br />

		<div class="jumbotron">
			<h2>Update</h2>
			<br />
			<form:form method="post" action="update" modelAttribute="dataForm"
				onsubmit="return validateUpdate();">
				<div class="form-group">
					<form:input hidden="true" type="text" id="id" path="id" />

					<label for="userName">User Name</label>
					<form:input type="text" class="form-control" id="userName"
						placeholder="Enter user name" path="userName" />
				</div>
				<div class="form-group">
					<label for="email">Email address</label>
					<form:input type="email" class="form-control" id="email"
						placeholder="Enter email" path="email" />
				</div>
				<div class="form-group">
					<label for="phoneNumber">Phone Number</label>
					<form:input type="tel" class="form-control" id="phoneNumber"
						placeholder="Enter Phone Number" path="phoneNumber" />
				</div>

				<button type="submit" value="add" class="btn btn-lg btn-success">Update</button>
			</form:form>



		</div>
		<input hidden="true" id="urlContext" value="${urlContext}" type="text">

		<footer class="footer">
			<p>© asn</p>
		</footer>


		<script
			src="http://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"
			type="text/javascript"></script>

		<script src="<c:url value="/resources/js/bootstrap.js" />"
			type="text/javascript"></script>

		<script src="<c:url value="/resources/js/submit.js" />"
			type="text/javascript"></script>


	</div>
	<!-- /container -->

	<script type="text/javascript">
		$(function() {
			"use strict";
			console.log("ready ajax1");

		});
	</script>

</body>
</html>