package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

public class signUpFormCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

      
        User user = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
     
        String view = "views/signup-form.jsp";
                
        UserService us = new UserService();
        if (us.checkAuthentication(username, password) != null) {
            if (us.checkAuthentication(username, password)) {
                view = "views/signup-success.jsp";
                user.setAuthenticated(true);
                request.setAttribute("message", "Authentication done!");
            }
            else 
                request.setAttribute("message", "Error in the authentication process. Try again");
            
        
        }
        else 
            request.setAttribute("message", "It's been an error in the authentication process");
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
    }
}
