package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Cryptocurrency;
import cat.urv.deim.sob.model.Customer;
import cat.urv.deim.sob.model.Order;
import cat.urv.deim.sob.service.CryptocurrencyService;
import cat.urv.deim.sob.service.OrderService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class buyCryptocurrencyCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String view;

        String cryptoId = request.getParameter("id");

        String amount = request.getParameter("amount");

        HttpSession sesion = request.getSession(true);
        Customer customer = (Customer) sesion.getAttribute("customer");

        if (customer != null) {
            if (amount != null) {
                String credentials = (String) sesion.getAttribute("credentials");

                OrderService cs = new OrderService();
                Order order = cs.createOrder(cryptoId, amount, credentials);
                
                int orderId = order.getId();
                response.sendRedirect("summaryOrder.do?id="+orderId);
            } else {
                view = "views/buyCryptocurrency.jsp";

                CryptocurrencyService cs = new CryptocurrencyService();
                Cryptocurrency crypto = cs.findCryptocurrency(cryptoId);
                request.setAttribute("crypto", crypto);

                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            }
        } else {
            String lastPage = request.getRequestURL().toString() + "?" + request.getQueryString();
            sesion.setAttribute("lastPage", lastPage);
            response.sendRedirect("authentication.do");
        }
    }
}