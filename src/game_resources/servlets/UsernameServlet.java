package game_resources.servlets;

import game_resources.processing.RandomizedName;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "username",
        urlPatterns = {"/username"}
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

}
