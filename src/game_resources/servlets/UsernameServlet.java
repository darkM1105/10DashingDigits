package game_resources.servlets;

import game_resources.entity.simple_info.Username;
import game_resources.processing.RandomizedName;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "username",
        urlPatterns = {"/game"}
)

public class UsernameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/username.jsp";
        RandomizedName randomizedName = new RandomizedName();
        String randomName = randomizedName.generateRandomName();

        request.setAttribute("info", randomName);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/game.jsp";

        Username.setUsername(request.getParameter("username"));

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}
