<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Buy | ${crypto.name}</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />"
              rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <link href="<c:url value="/resources/css/formExchange.css" />"
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
                            <form id="login-form" class="form" action="buyCryptocurrency.do?id=${crypto.id}" method="post">
                                <h3 class="text-center text-info">Buy ${crypto.name}</h3>
                                <div class="form-group">
                                    <label for="username" class="text-info">Amount (${crypto.name}) to be purchased:</label><br>
                                    <input type="number" step="any" min=0 name="amount" id="amount" class="form-control" required>
                                </div>
                                <div class="form-group">
                                    <label for="password" class="text-info">Last quote:</label><br>
                                    ${crypto.lastQuote} €
                                </div>
                                <div class="form-group" style="margin-top: 30px">
                                    <button type="submit" class="btn btn-primary btn-block">Buy</button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
