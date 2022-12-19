/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Cryptocurrency;
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
public class cryptocurrencyListCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String view = "views/cryptocurrency-list.jsp";
        
        CryptocurrencyService cs = new CryptocurrencyService();
 
        List <Cryptocurrency> list = cs.findAll("DESC");
            //request.setAttribute("message", "No s'han trobat cryptos"); 
        
        request.setAttribute("cryptoList", list);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
        
    }
    
    
}
