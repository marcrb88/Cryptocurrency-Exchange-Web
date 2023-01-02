package cat.urv.deim.sob.command;

import cat.urv.deim.sob.model.Cryptocurrency;
import cat.urv.deim.sob.service.CryptocurrencyService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class cryptocurrencyListCommand implements Command {

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String order = request.getParameter("order");
        if (order == null) {
            order = "DESC";
        }

        String view = "views/listCryptocurrency.jsp";

        CryptocurrencyService cs = new CryptocurrencyService();

        List<Cryptocurrency> list = cs.findAll(order);
        request.setAttribute("cryptoList", list);

        HttpSession sesion = request.getSession(true);
        String lastPage = request.getRequestURL().toString();
        sesion.setAttribute("lastPage", lastPage);

        RequestDispatcher dispatcher = request.getRequestDispatcher(view);
        dispatcher.forward(request, response);
    }
}
