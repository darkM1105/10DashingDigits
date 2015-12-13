package game_resources.processing;

import game_resources.entity.GameSession;
import game_resources.entity.InfoBean;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Compressor {

    private Integer[] sessionArray = new Integer[270];
    private String[] wordListArray = new String[30];

    public int process(Integer[] sessionArray, int wordListId, String username) {

        String filePath;
        int record;

        this.sessionArray = sessionArray;
        filePath = createFile("game_session", wordListId, username);
        GameSession gameSession = new GameSession(0, wordListId, filePath);
        record = GameDAO.getPublicDAO().createGameSession(gameSession);

        return record;

    }

    public int process(String[] wordListArray) {

        String filePath;
        int record;

        this.wordListArray = wordListArray;
        filePath = createFile("word_list", 0, "");
        WordList wordList = new WordList(0, filePath);
        record = GameDAO.getPublicDAO().createWordList(wordList);
        new File("C:\\10DashingDigitsDB\\GameSessions\\List" + record).mkdir();

        return record;

    }

    private String createFile(String fileType, int wordListId, String username) {

        String finalName = "";
        String directory = "";
        String userName = username + "ts";
        String tempName;

        if (fileType.equals("game_session")) {

            directory = "GameSessions\\List" + wordListId;

        } else if (fileType.equals("word_list")) {

            directory = "WordLists";

        }

        tempName = "C:\\10DashingDigitsDB\\" + directory + "\\" + userName + createTimeStamp() + ".txt";

        try(PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(tempName)))) {

            if (fileType.equals("game_session")) {

                for (int i = 0; i < sessionArray.length; i++) {

                    printer.print(sessionArray[i] + " ");

                    if (i != (sessionArray.length - 1)) {

                        printer.println();

                    }

                }

                finalName = tempName;

            } else if (fileType.equals("word_list")) {

                int index = 0;

                for (int i = 1; i <= 3; i++) {

                    for (int j = 1; j <= 10; j++) {

                        printer.print(wordListArray[index]);
                        index++;

                    }

                    if (i != 3) {

                        printer.println();

                    }

                }

                finalName = tempName;

            }

        } catch (IOException e) {

            e.printStackTrace();

        }

        return finalName;

    }

    private String createTimeStamp() {

        String timeStampName;

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy h:mm:ss a");
        timeStampName = sdf.format(date);

        timeStampName = timeStampName.replace("/", "");
        timeStampName = timeStampName.replace(" ", "");
        timeStampName = timeStampName.replace(":", "");

        return timeStampName;

    }

}