package game_resources.servlets;

import game_resources.entity.PreGameInfoBean;
import game_resources.processing.Randomizer;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

@WebServlet(
        name = "pre-game",
        urlPatterns = {"/game"}
)

public class PreGameServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String url = "/game.jsp";

        Randomizer randomizer = new Randomizer();
        Gson gson = new Gson();
        PreGameInfoBean info = randomizer.generateInfoBean(request.getParameter("username"));
        Type type = new TypeToken<PreGameInfoBean>() {}.getType();
        String json = gson.toJson(info, type);
        request.setAttribute("info", json);

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);

    }

}

