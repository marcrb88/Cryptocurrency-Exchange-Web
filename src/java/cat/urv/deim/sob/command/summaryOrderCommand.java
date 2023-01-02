package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Order;
import cat.urv.deim.sob.service.OrderService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

public class summaryOrderCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String orderId = request.getParameter("id");
        
        HttpSession sesion = request.getSession(true);
        String credentials = (String) sesion.getAttribute("credentials");

        String view = "views/summaryOrder.jsp";

        OrderService cs = new OrderService();
        Order order = cs.findOrder(orderId, credentials);
        
        request.setAttribute("order", order);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
