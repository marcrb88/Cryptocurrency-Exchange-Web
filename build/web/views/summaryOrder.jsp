<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order | ${order.id}</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />"
              rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <link href="<c:url value="/resources/css/container.css" />"
              rel="stylesheet">
    </head>
    <body>
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <a class="navbar-brand" href="cryptocurrencyList.do">Marc's Exchange</a>
                </div>
                <ul class="nav navbar-nav">
                    <li class="active"><a href="cryptocurrencyList.do">Home</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                            Hola ${customer.name}
                        </a>
                        <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                            <p>Name: ${customer.name}</p>
                            <p>Email: ${customer.email}</p>
                            <c:if test="${not empty customer.phone}">
                                <p>Phone: ${customer.phone}</p>
                            </c:if>
                        </div>
                    </li>
                </ul>
            </div>
        </nav>
        <div id="login">
            <div class="container">
                <div id="login-row" class="row justify-content-center align-items-center">
                    <div id="login-column" class="col-md-offset-4 col-md-4">
                        <a href="cryptocurrencyList.do"><h2 class="text-center" style="margin-top: 120px;">Marc's Exchange</h2></a>
                        <div id="login-box" class="col-md-12">
                            <form class="form">
                                <h3 class="text-center text-info">Information of order nº${order.id}</h3>
                                <div class="form-group">
                                    <label for="username" class="text-info">Date:</label><br>
                                    ${order.datePurchase}
                                </div>
                                <div class="form-group">
                                    <label for="password" class="text-info">Amount (${order.cryptocurrency.name}):</label><br>
                                    ${order.amount}
                                </div>
                                <div class="form-group">
                                    <label for="password" class="text-info">Cost:</label><br>
                                    ${order.euros} €
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
