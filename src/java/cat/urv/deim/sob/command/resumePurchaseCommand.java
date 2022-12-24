/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Order;
import cat.urv.deim.sob.service.CryptocurrencyService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;
import java.io.IOException;


/**
 *
 * @author marcr
 */
public class resumePurchaseCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cryptoId = request.getParameter("id");
        Integer id = 0;
        
        String view = "views/resumePurchase.jsp";
        
        CryptocurrencyService cs = new CryptocurrencyService();
        Response responseCrypto = cs.postCrypto(Integer.valueOf(cryptoId), Float.valueOf(request.getParameter("amount")), id++);
        responseCrypto.readEntity(String.class);
       
        Order order = cs.getOrder(cryptoId);
        request.setAttribute("order", order);
       
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);  
    
    }
}
