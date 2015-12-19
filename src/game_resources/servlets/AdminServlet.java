package game_resources.servlets;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;
import game_resources.entity.WordList;
import game_resources.entity.simple_info.TrueCount;
import game_resources.persistence.GameDAO;
import game_resources.processing.Compressor;
import game_resources.processing.RandomizedData;
import game_resources.processing.RandomizedName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Random;

@WebServlet(
        name = "admin",
        urlPatterns = {"/admin"}
)

public class AdminServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int trueCount = GameDAO.getPublicDAO().getAllWordLists().size();
        Gson gson = new Gson();
        TrueCount count = new TrueCount(trueCount);
        Type type = new TypeToken<TrueCount>() {}.getType();
        String json = gson.toJson(count, type);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String adminAction = request.getParameter("adminAction");
        RandomizedData randomizedData = new RandomizedData();
        RandomizedName randomizedName = new RandomizedName();
        Compressor compressor = new Compressor();
        Random random = new Random();

        switch (adminAction) {
            case "justCreate": {

                int count = Integer.valueOf(request.getParameter("count"));
                count = (count <= 0) ? 1 : count;

                for (int i = 0; i < count; i++) {

                    String[] data = randomizedData.generateRandomWordListData();
                    int record = compressor.process(data);
                    Integer[] moreData = randomizedData.generateRandomGameSessionData();
                    compressor.process(moreData, record, randomizedName.generateRandomName());

                }

                break;
            }
            case "createAndPopulate": {

                int count = Integer.valueOf(request.getParameter("count"));
                int countPer = Integer.valueOf(request.getParameter("countPer"));
                count = (count <= 0) ? 1 : count;
                countPer = (countPer <= 0) ? 1 : countPer;

                for (int i = 0; i < count; i++) {

                    String[] data = randomizedData.generateRandomWordListData();
                    int list = compressor.process(data);

                    for (int j = 0; j < countPer; j++) {

                        Integer[] moreData = randomizedData.generateRandomGameSessionData();
                        compressor.process(moreData, list, randomizedName.generateRandomName());

                    }

                }

                break;
            }
            case "justDelete": {

                int count = Integer.valueOf(request.getParameter("count"));
                List<WordList> list = GameDAO.getPublicDAO().getAllWordLists();
                count = (count <= 0) ? 1 : count;
                count = (count > list.size()) ? list.size() : count;
                int fauxCount = count;

                for (int i = 0; i < count; i++) {

                    GameDAO.getPublicDAO().deleteWordList(list.get(random.nextInt(fauxCount)).getListId());
                    fauxCount--;

                }

                break;
            }
            case "deleteAll": {

                List<WordList> list = GameDAO.getPublicDAO().getAllWordLists();

                for (WordList aList : list) {

                    GameDAO.getPublicDAO().deleteWordList(aList.getListId());

                }

                break;
            }
        }

        int trueCount = GameDAO.getPublicDAO().getAllWordLists().size();
        Gson gson = new Gson();
        TrueCount count = new TrueCount(trueCount);
        Type type = new TypeToken<TrueCount>() {}.getType();
        String json = gson.toJson(count, type);

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);

    }

}
