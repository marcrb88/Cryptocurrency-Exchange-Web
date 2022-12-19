<%-- 
    Document   : cryptocurrency-list
    Created on : 15 dic 2022, 16:18:33
    Author     : marcr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h2> Llista de criptomonedes </h2>
        
        <c:forEach var="listValue" items="${cryptoList}">
            <b>${listValue.name}</b> <br> <hr>
            ${listValue.description}
            <p>Price history: ${listValue.lastQuote} </p><br><br>
         
        </c:forEach>
      
    </body>
</html>
