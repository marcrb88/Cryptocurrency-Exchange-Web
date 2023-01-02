<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cryptocurrency List</title>
        <link href="<c:url value="/resources/css/bootstrap.min.css" />"
              rel="stylesheet">
        <script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
        <script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>
        <script>
            window.onload = function () {
                let searchParams = new URLSearchParams(window.location.search);
                if (searchParams.get('order') === "ASC") {
                    document.getElementById("arrow").src = "<c:url value="/resources/img/up.png"/>";
                } else {
                    document.getElementById("arrow").src = "<c:url value="/resources/img/down.png"/>";
                }
            };
        </script>
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
        <h2 style="text-align: center;"><b>List of Cryptocurrencies</b></h2>
        <table id="cryptoList" class="table">
            <thead>
                <tr>
                    <th>Name</th>
                    <th>Description</th>
                    <th><span style="padding-right:15px;">Price</span><button id="priceOrder"><img id="arrow" style="width: 16px; height: 16px;"></button></th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="cryptocurrency" items="${cryptoList}">
                    <tr>
                        <td style="vertical-align: middle;">
                            <a target="_blank" href="detailedCryptocurrency.do?id=${cryptocurrency.id}">
                                <img src="<c:url value="/resources/img/${cryptocurrency.id}.png"/>" style="width: 32px; height: 32px;">
                                ${cryptocurrency.name}
                            </a>
                        </td>
                        <td style="vertical-align: middle;">${cryptocurrency.description}</td>
                        <td style="vertical-align: middle;">${cryptocurrency.lastQuote} <span style="font-size: 12px; vertical-align: middle;">${cryptocurrency.lastQuoteTime}</span></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>      
    </body>
    <script>
        $("#priceOrder").click(function () {
            let searchParams = new URLSearchParams(window.location.search);
            if (searchParams.get('order') === "ASC") {
                window.location.replace("http://localhost:8080/SOBASE/cryptocurrencyList.do?order=DESC");
            } else {
                window.location.replace("http://localhost:8080/SOBASE/cryptocurrencyList.do?order=ASC");
            }
        });

        $(document).ready(function () {
            $('#cryptoList').dataTable({
                "bScrollInfinite": true,
                "bScrollCollapse": true,
                "sScrollY": "200px"
            });
        });

        function LogOut() {
            alert("Logged Out");
        }
    </script>
</html>