package game_resources.servlets;

import game_resources.entity.InfoBean;
import game_resources.processing.Randomizer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "game",
        urlPatterns = {"/game"}
)

public class GameServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/game.jsp";

        /*Randomizer randomizer = new Randomizer();
        InfoBean info = randomizer.generateInfoBean(request.getParameter("username"));

        request.setAttribute("info", info);*/

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}

