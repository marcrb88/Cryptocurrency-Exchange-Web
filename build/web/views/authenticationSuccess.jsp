<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up Success - SOB</title>
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
</head>
<body>
	<div class="container">
		<div class="col-md-offset-2 col-md-7">
                        <h1> Benvingut ${userAuth.username}</h1> 
                        <p id ="username" ></p>
                        <p id ="password" ></p>
                        <p id ="auth" ></p>
                        
			<hr />
                        <a class="btn" href="<c:url value="/detailedCryptocurrency.do?id=2&userAuth=${userAuth.authenticated}" />">Go Back</a>
		</div>
	</div>
</body>

    <script>
        $( "h1" ).click(function() {
            
           $("p#username").text("Username: ${userAuth.username}");
           $("p#password").text("Password: ${userAuth.password}");
           $("p#auth").text("Authenticated: ${userAuth.authenticated}");
            
        });
        
    </script>


</html>