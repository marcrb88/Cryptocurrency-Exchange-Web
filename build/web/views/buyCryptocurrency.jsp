<%-- 
    Document   : buyCryptocurrency
    Created on : 21 dic 2022, 19:44:25
    Author     : marcr
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cryptocurrency shop</title>
    </head>
    <body>
        <h1>Compra de la criptomoneda</h1>
    <form action="resumePurchase.do?id=${cryptoId}"  class="form-horizontal" method="post"> 
        <div class="form-group">
            <label class="col-md-3 control-label">
                Quantitat a adquirir
            </label>
            <div class="col-md-9">
                <input type="text" name="amount" value="${order.amount}" class="form-control" />
            </div>
            <p> Last quote: ${crypto.lastQuote} </p>
        </div>
        <div class="form-group">
            <div class="col-md-offset-3 col-md-9">
                <input type="submit" value="Submit" />
            </div>
        </div>
    </form>
    </body>
</html>
