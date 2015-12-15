package game_resources.servlets;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import game_resources.entity.PostGameInfoBean;
import game_resources.processing.Compressor;

import java.io.*;
import java.lang.reflect.Type;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(
        name = "post-game",
        urlPatterns = {"/post-game"}
)

public class PostGameServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*String url = "/index.jsp";

        RequestDispatcher  dispatcher = getServletContext().getRequestDispatcher(url);
        dispatcher.forward(request, response);*/

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Compressor compressor = new Compressor();
        Gson gson = new Gson();
        Type type = new TypeToken<PostGameInfoBean>() {}.getType();
        PostGameInfoBean bean = gson.fromJson(request.getParameter("info"), type);
        compressor.process(bean.getGameSession(), bean.getListId(), bean.getUsername());

    }

}
