package game_resources.entity;

//import org.apache.log4j.Logger;

/**
 * A simple bean that gets passed to the 'post-game' servlet in JSON format. It contains all of the necessary data to
 * create a new 'GameSession' object and therefore a new record in the 'game_sessions' table.
 *
 * @author mrclark@madisoncollege.edu
 */
public class PostGameInfoBean {

    //private final Logger logger = Logger.getLogger(this.getClass());

    /**
     * An array of integers representing the number of milliseconds between correct keystrokes made by the user during
     * the game.
     */
    private Integer[] gameSession;

    /**
     * The username that was generated or manually submitted by the user before the creation of the corresponding
     * 'PreGameInfoBean' object.
     */
    private String username;

    /**
     * The unique id representing the 'WordList' object that was used during the game.
     */
    private int listId;

    public Integer[] getGameSession() {

        return gameSession;

    }

    public void setGameSession(Integer[] gameSession) {

        this.gameSession = gameSession;

    }

    public String getUsername() {

        return username;

    }

    public void setUsername(String username) {

        this.username = username;

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
    public PostGameInfoBean() {}

    /**
     * A simple constructor that can generate a full object.
     *
     * @param gameSession   An array of integers representing the number of milliseconds between correct keystrokes made
     *                      by the user during the game.
     * @param username  The username that was generated or manually submitted by the user before the creation of the
     *                      corresponding 'PreGameInfoBean' object.
     * @param listId    The unique id representing the 'WordList' object that was used during the game.
     */
    public PostGameInfoBean(Integer[] gameSession, String username, int listId) {

        this.gameSession = gameSession;
        this.username = username;
        this.listId = listId;

    }

    /**
     * A simple toString() method that returns all values.
     *
     * @return A String that contains all variable names and their values.
     */
    public String toString() {

        return "gameSessionArray size: " + gameSession.length + "; username: " + username + "; listId: " + listId;

    }

}
