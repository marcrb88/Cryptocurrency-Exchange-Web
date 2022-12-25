<%-- 
    Document   : cryptocurrency-list
    Created on : 15 dic 2022, 16:18:33
    Author     : marcr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script src="<c:url value="/resources/js/jquery-1.11.1.min.js" />"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      
        <h2> Llista de criptomonedes </h2>
         
        
        <button id = "button">Canviar l'ordre de les criptomonedes</button> <br> <br>
        
        
        
        <c:forEach var="listValue" items="${cryptoList}">
            <c:if test = "${listValue.name == 'bitcoin'}">
                <a href="http://localhost:8080/SOBASE/detailedCryptocurrency.do?id=2" target="_blank">
                   <img src='resources/img/bitcoin.jpg' width='70' height='70'/> </a>
            </c:if>
            <c:if test = "${listValue.name == 'etherium'}">
                <a href="http://localhost:8080/SOBASE/detailedCryptocurrency.do?id=1" target="_blank" >
                    <img id = "etherium" src='resources/img/etherium.png' width='70' height='70' /> </a>
            </c:if>   
            
            <b>${listValue.name} </b> <br> <hr> 
            ${listValue.description}
            <p>Price history: ${listValue.lastQuote} </p><br><br>
         
        </c:forEach>         
      
    </body>
    
    <script>
        $( "#button" ).click(function() {
            window.location.replace("http://localhost:8080/SOBASE/cryptocurrency.do?order=ASC");
        });
        
    </script>
</html>
