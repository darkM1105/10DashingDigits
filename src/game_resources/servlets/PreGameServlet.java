package game_resources.servlets;

import game_resources.entity.PreGameInfoBean;
import game_resources.entity.Username;
import game_resources.processing.RandomizedName;
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

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Randomizer randomizer = new Randomizer();
        Gson gson = new Gson();
        PreGameInfoBean info = randomizer.generateInfoBean();
        Type type = new TypeToken<PreGameInfoBean>() {}.getType();
        String json = gson.toJson(info, type);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

}

