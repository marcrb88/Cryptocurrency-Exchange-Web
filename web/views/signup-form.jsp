<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up Example - SOB</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
			<h2 class="text-center">Authentication Form</h2>
			<div class="panel panel-info">
			
				<div class="panel-body">
					<form action="signUpForm.do" class="form-horizontal"
						method="post">

						<div class="form-group">
							<label for="firstname" class="col-md-3 control-label">Username
                                                        </label>
							<div class="col-md-9">
								<input type="text" name="username" value="${user.username}" class="form-control" />
							</div>
						</div>
						<div class="form-group">
							<label for="lastname" class="col-md-3 control-label">Password
                                                        </label>
							<div class="col-md-9">
								<input type="text" name="password" value="${user.password}" class="form-control" />
							</div>
						</div>
						
						<div class="form-group">
							<!-- Button -->
							<div class="col-md-offset-3 col-md-9">
								<input type="submit" value="Submit" />
							</div>
						</div>
					<form>
                                        <c:if test="${not empty message}">
                                            <div class="alert alert-danger" role="alert">
                                                ${message}  
                                     
                                            </div>
                                        </c:if>
                                </div>
			</div>
		</div>
	</div>
</body>
</html>