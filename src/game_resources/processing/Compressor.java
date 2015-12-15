package game_resources.processing;

import game_resources.entity.GameSession;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * A class that takes raw, newly generated date, and processes it into a new file as well as a new record in the
 * corresponding database.
 *
 * @author mrclark@madisoncollege.edu
 */
public class Compressor {

    //Default empty arrays.
    private Integer[] sessionArray = new Integer[270];
    private String[] wordListArray = new String[30];

    /**
     * Method used to process raw data into a new 'GameSession' object as well as update the database, and create a new
     * file.
     *
     * @param sessionArray  Integer array representing all of the user's times between correct keystrokes.
     * @param wordListId    An integer representing the 'WordList' object used.
     * @param username      A string representing the user's in-game username.
     * @return      An integer representing the newly created record in the 'game_sessions' table.
     */
    public int process(Integer[] sessionArray, int wordListId, String username) {

        String filePath;
        int record;

        this.sessionArray = sessionArray;
        filePath = createFile("game_session", wordListId, username);
        GameSession gameSession = new GameSession(0, wordListId, filePath);
        record = GameDAO.getPublicDAO().createGameSession(gameSession);

        return record;

    }

    /**
     * Method used to process raw data into a new 'WordList' object as well as update the database, and create a new
     * file.
     *
     * @param wordListArray  String array representing all of the newly generated strings.
     * @return      An integer representing the newly created record in the 'word_lists' table.
     */
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

    /**
     * Method that locally creates a new file with the specified raw data.
     *
     * @param fileType  String representing the type of file being created. It can only be 'game_session' or 'word_list'.
     * @param wordListId    Integer representing the listId. It is needed in the naming of files or directories.
     * @param username  A string representing the user's in-game username.
     * @return      A string representing the absolute filepath of the newly created file.
     */
    private String createFile(String fileType, int wordListId, String username) {

        String finalName = "";
        String directory = "";
        String userName = username + "ts";
        String tempName;

        //Assign values to local variables based on fileType.
        if (fileType.equals("game_session")) {

            directory = "GameSessions\\List" + wordListId;

        } else if (fileType.equals("word_list")) {

            directory = "WordLists";

        }

        //Filepath format.
        tempName = "C:\\10DashingDigitsDB\\" + directory + "\\" + userName + createTimeStamp() + ".txt";

        //Creating new file.
        try(PrintWriter printer = new PrintWriter(new BufferedWriter(new FileWriter(tempName)))) {

            if (fileType.equals("game_session")) {

                //Iterates 270 times and throws each value on it's own separate line.
                for (int i = 0; i < sessionArray.length; i++) {

                    printer.print(sessionArray[i] + " ");

                    if (i != (sessionArray.length - 1)) {

                        printer.println();

                    }

                }

                finalName = tempName;

            } else if (fileType.equals("word_list")) {

                int index = 0;

                //Ends up generating a file with 3 lines and 10 strings to a line. 270 characters in total.
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

    /**
     * Method that generates a timestamp which will be used as part of the new file's filepath.
     *
     * @return  A string specially formatted to represent the current timestamp.
     */
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