package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Customer;
import cat.urv.deim.sob.service.CustomerService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpSession;
import java.util.Base64;

public class authenticationCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String view = "views/authentication.jsp";

        HttpSession sesion = request.getSession(true);

        if (username != null && password != null) {
            CustomerService cs = new CustomerService();
            Customer customer = cs.login(username, password);
            if (customer != null) {
                sesion.setAttribute("customer", customer);

                String originalInput = username + ":" + password;
                String credentials = Base64.getEncoder().encodeToString(originalInput.getBytes());
                sesion.setAttribute("credentials", credentials);

                response.sendRedirect((String)sesion.getAttribute("lastPage"));
            } else {
                request.setAttribute("message", "Your credentials are wrong. Try again");
                RequestDispatcher dispatcher = request.getRequestDispatcher(view);
                dispatcher.forward(request, response);
            }
        } else {
            RequestDispatcher dispatcher = request.getRequestDispatcher(view);
            dispatcher.forward(request, response);
        }
    }
}
