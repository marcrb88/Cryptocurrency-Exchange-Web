<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crypto | ${crypto.name}</title>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">
        <link href="<c:url value="/resources/css/bootstrap.min.css" />"
              rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <style>
            * {
                box-sizing: border-box;
            }

            .row {
                display: flex;
            }

            /* Create two equal columns that sits next to each other */
            .column {
                flex: 50%;
                padding-left: 15px;
            }
        </style>
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
                    <c:choose>
                        <c:when test="${not empty customer}">
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
                        </c:when>
                        <c:otherwise>
                            <li><a href="#">Sign Up</a></li>
                            <li><a href="authentication.do">Login</a></li>
                            </c:otherwise>
                        </c:choose>
                </ul>
            </div>
        </nav>
        <div style="width: 50%; padding-left: 10px; font-size: 18px;">
            <div>
                <img src='resources/img/${param.id}.png' width='64' height='64'><b><span style="font-size: 24px; padding-left:15px;">${crypto.name}</span></b>
            </div><br>
            <p>${crypto.description}</p>
            <hr>
            <h3><b>Price History</b></h3>
            <div class="row">
                <div class="column">
                    <p>${crypto.lastQuote} <span style="font-size: 12px; vertical-align: middle;">${crypto.lastQuoteTime}</span></p>
                </div>
                <div class="column">
                    <button id="button" class="bi bi-cart btn"> Buy</button>
                </div>
            </div>

            <c:if test="${not empty orders}">
                <hr>
                <h3><b>Last transactions</b></h3>
                <table id="cryptoList" class="table">
                    <thead>
                        <tr>
                            <th>Time</th>
                            <th>Amount (${crypto.name})</th>
                            <th>Amount (euros)</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="order" items="${orders}">
                            <tr>
                                <td style="vertical-align: middle;">${order.datePurchase}</td>
                                <td style="vertical-align: middle;">${order.amount}</td>
                                <td style="vertical-align: middle;">${order.euros}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </div>
    </body>
    <script>
        $("#button").click(function () {
            window.open("http://localhost:8080/SOBASE/buyCryptocurrency.do?id=${param.id}");
        });
    </script>
</html>
