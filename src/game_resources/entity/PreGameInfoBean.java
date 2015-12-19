package game_resources.entity;


//import org.apache.log4j.Logger;

/**
 * A simple bean that gets passed to the 'game.jsp' page in JSON format. It contains all necessary data needed for the
 * game to function as well as some data needed to update the database after the game is completed.
 *
 * @author mrclark@madisoncollege.edu
 */
public class PreGameInfoBean {
    //private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * An array of pre-generated strings, read from a file, that represents the text that must be typed during the game.
     */
    private String[] wordListArray;

    /**
     * An array of pre-generated numbers, read from a file, that represents the the opponents actions during the game.
     */
    private Integer[] gameSessionArray;

    /**
     * The user's username. It is either randomly generated or manually submitted by the user.
     * This value is later used during the creation of a 'PostGameInfoBean' instance.
     */
    private String username;

    /**
     * The opponent's username. It is pulled from the unique file path name where gameSessionArray was generated from.
     */
    private String opponentUsername;

    /**
     * The unique id representing the record that contains the file path name where wordListArray was generated from.
     * This value is later used during the creation of a 'PostGameInfoBean' instance.
     */
    private int listId;

    public String[] getWordListArray() {

        return wordListArray;

    }

    public void setWordListArray(String[] wordListArray) {

        this.wordListArray = wordListArray;

    }

    public Integer[] getGameSessionArray() {

        return gameSessionArray;

    }

    public void setGameSessionArray(Integer[] gameSessionArray) {

        this.gameSessionArray = gameSessionArray;

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;

    }

    public String getOpponentUsername() {

        return opponentUsername;

    }

    public void setOpponentUsername(String opponentUsername) {

        this.opponentUsername = opponentUsername;

    }

    public int getListId() {

        return listId;

    }

    public void setListId(int listId) {

        this.listId = listId;

    }

    /**
     * A simple no-argument constructor.
     */
    public PreGameInfoBean() {}

    /**
     * A simple constructor that can generate a full object.
     *
     * @param wordListArray An array of pre-generated strings, read from a file, that represents the text that must be
     *                      typed during the game.
     * @param gameSessionArray  An array of pre-generated numbers, read from a file, that represents the the opponents
     *                      actions during the game.
     * @param username      The user's username. It is either randomly generated or manually submitted by the user.
     * @param opponentUsername  The unique id representing the record that contains the file path name where
     *                      wordListArray was generated from.
     * @param listId        The unique id representing the record that contains the file path name where wordListArray
     *                      was generated from.
     */
    public PreGameInfoBean(String[] wordListArray, Integer[] gameSessionArray, String username, String opponentUsername, int listId) {

        this.wordListArray = wordListArray;
        this.gameSessionArray = gameSessionArray;
        this.username = username;
        this.opponentUsername = opponentUsername;
        this.listId = listId;

    }

    /**
     * A simple toString() method that returns all values.
     *
     * @return A String that contains all variable names and their values.
     */
    public String toString() {

        return "wordListArray size: " + wordListArray.length + "; gameSessionArray size: " + gameSessionArray.length
                + "; username: " + username + "; opponentUsername: " + opponentUsername + "; listId: " + listId;

    }

}
