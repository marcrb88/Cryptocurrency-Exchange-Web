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
import java.io.IOException;


/**
 *
 * @author marcr
 */
public class resumePurchaseCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        String view = "views/resumePurchase.jsp";
        Order order = new Order();
        order.setAmount(Float.valueOf(request.getParameter("amount")));
        
        CryptocurrencyService cs = new CryptocurrencyService();
 
        Order order2 = cs.getOrder("2"); 
       
        request.setAttribute("order", order2);
       
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);  
    
    }
}
