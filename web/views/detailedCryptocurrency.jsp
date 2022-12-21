<%-- 
    Document   : cryptocurrency-list
    Created on : 15 dic 2022, 16:18:33
    Author     : marcr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.2/font/bootstrap-icons.css">

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <h2> Criptomoneda detallada </h2>
         
            <c:if test = "${crypto.name == 'bitcoin'}">
                <img src='resources/img/bitcoin.jpg' width='70' height='70'>
            </c:if>
            <c:if test = "${crypto.name == 'etherium'}">
                <img src='resources/img/etherium.png' width='70' height='70'>
            </c:if>   
            
            <b>${crypto.name} </b> <br> <hr> 
            ${crypto.description}
            <p>Price history: ${crypto.lastQuote} </p><br><br>       
            
            <button class="bi bi-cart btn" > Buy </button>
    </body>
    
</html>
