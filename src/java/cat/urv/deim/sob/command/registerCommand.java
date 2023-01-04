package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Customer;
import cat.urv.deim.sob.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

public class registerCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String phone = request.getParameter("phone");

        String view = "views/register.jsp";

        if (name != null & username != null && password != null) {
            CustomerService cs = new CustomerService();
            Customer customer = cs.register(username, password, name, phone);
            if (customer != null) {
                response.sendRedirect("authentication.do");
            } else {
                request.setAttribute("message", "Customer already exists");
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}
