/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Cryptocurrency;
import cat.urv.deim.sob.model.Order;
import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.CryptocurrencyService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author marcr
 */
public class detailedCryptocurrencyCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String cryptoId = request.getParameter("id");
        
        String view = "views/detailedCryptocurrency.jsp";
        
        CryptocurrencyService cs = new CryptocurrencyService();
 
        Order order = cs.getOrder(cryptoId); 
        
        if (order == null) {
            Cryptocurrency crypto = cs.getCryptocurrency(cryptoId);
            request.setAttribute("crypto", crypto);
        } else {
            request.setAttribute("order", order);
        }
        
        request.setAttribute("cryptoId", cryptoId);
        User user = new User();
        request.setAttribute("user", user);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
        
    }
    
    
}
