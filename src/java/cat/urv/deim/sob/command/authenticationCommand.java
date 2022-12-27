package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.User;
import cat.urv.deim.sob.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.ServletException;
import java.io.IOException;
import jakarta.servlet.RequestDispatcher;

public class authenticationCommand implements Command {

    @Override
    public void execute(
            HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {

      
        User userAuth = new User();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String cryptoId = request.getParameter("id");
        
        userAuth.setPassword(password);
        userAuth.setUsername(username);
     
        String view = "views/authentication.jsp";
    if (username != null || password != null) {            
        UserService us = new UserService();
        if (us.checkAuthentication(username, password) != null) {
            if (us.checkAuthentication(username, password)) {
                view = "views/authenticationSuccess.jsp";
                userAuth.setAuthenticated(true);
                request.setAttribute("userAuth", userAuth);
                request.setAttribute("message", "Authentication done!");
            }
            else 
                request.setAttribute("message", "Your credentials are wrong. Try again");
            
        
        }
        else 
            request.setAttribute("message", "It's been an error in the authentication process");
        
    }    
        request.setAttribute("cryptoId", Integer.valueOf(cryptoId));
        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
        
    }
}
