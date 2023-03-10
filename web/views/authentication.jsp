<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />"
              rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <link href="<c:url value="/resources/css/formExchange.css" />"
              rel="stylesheet">
    </head>
    <body>
        <c:if test="${not empty message}">
            <div class="alert alert-danger col-md-offset-4 col-md-4" role="alert">
                ${message}
            </div>
        </c:if>
        <div id="login">
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-offset-4 col-md-4">
                        <a href="cryptocurrencyList.do"><h2 class="text-center" style="margin-top: 120px;">Marc's Exchange</h2></a>
                        <div id="login-box" class="col-md-12">
                            <form id="login-form" class="form" action="authentication.do" method="post">
                                <h3 class="text-center text-info">Login to continue</h3>
                                <div class="form-group">
                                    <label for="username" class="text-info">Username:</label><br>
                                    <input type="text" name="username" value="${param.username}" id="username" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="text-info">Password:</label><br>
                                    <input type="password" name="password" value="${param.password}" id="password" class="form-control" required>
                                </div>
                                <div class="text-right">
                                    Don't have an account?
                                    <a href="register.do" class="text-info">Register here</a>
                                </div>
                                <div class="form-group" style="margin-top: 10px">
                                    <button type="submit" class="btn btn-primary btn-block">Log in</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>