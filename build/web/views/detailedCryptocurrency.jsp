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
         
        
        
        <c:choose>
        <c:when test="${not empty order}">
            <c:if test = "${order.cryptocurrency.name == 'bitcoin'}">
                <img src='resources/img/bitcoin.jpg' width='70' height='70'>
            </c:if>
            <c:if test = "${order.cryptocurrency.name == 'etherium'}">
                <img src='resources/img/etherium.png' width='70' height='70'>
            </c:if>   
            
            <b>${order.cryptocurrency.name} </b> <br> <hr> 
            ${order.cryptocurrency.description}
            <p>Price history: ${order.cryptocurrency.lastQuote} </p><br><br>
            <p>Last transaction: </p>
            ${order.amount} <br>
            ${order.euros} <br>
        </c:when>    
        <c:otherwise>
            <c:if test = "${crypto.name == 'bitcoin'}">
                <img src='resources/img/bitcoin.jpg' width='70' height='70'>
            </c:if>
            <c:if test = "${crypto.name == 'etherium'}">
                <img src='resources/img/etherium.png' width='70' height='70'>
            </c:if>   
            
            <b>${crypto.name} </b> <br> <hr> 
            ${crypto.description} <br>
        </c:otherwise>
        </c:choose>
        
            
             <a href="http://localhost:8080/SOBASE/buyCryptocurrency.do" target="_blank" >
                 <button class="bi bi-cart btn" > Buy </button> </a>
    </body>
    
    <script>
        $( "#button" ).click(function() {
            window.location.replace("http://localhost:8080/SOBASE/buyCryptocurrency.do");
        });
        
    </script>
    
</html>
