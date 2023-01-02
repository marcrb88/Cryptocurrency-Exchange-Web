package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Cryptocurrency;
import cat.urv.deim.sob.model.Order;
import cat.urv.deim.sob.service.CryptocurrencyService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class detailedCryptocurrencyCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String cryptoId = request.getParameter("id");
        
        String view = "views/detailedCryptocurrency.jsp";
        
        CryptocurrencyService cs = new CryptocurrencyService();
 
        Cryptocurrency crypto = cs.findCryptocurrency(cryptoId);
        request.setAttribute("crypto", crypto);

        List<Order> orders = cs.findOrders(cryptoId);
        request.setAttribute("orders", orders);
        
        HttpSession sesion = request.getSession(true);
        String lastPage = request.getRequestURL().toString() + "?" + request.getQueryString();
        sesion.setAttribute("lastPage", lastPage);
                
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
