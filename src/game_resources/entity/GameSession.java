package game_resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
//import org.apache.log4j.Logger;

/**
 * A simple bean that represents a record in the 'game_sessions' table.
 *
 * @author mrclark@madisoncollege.edu
 */

@Entity
@Table(name = "game_sessions")
public class GameSession {

    /**
     * A unique auto-incremented value representing this specific object.
     */
    @Column(name = "session_id")
    private int sessionId;

    /**
     * A value that represents a unique record in the 'word_lists' table.
     */
    @Column(name = "wl_list_id")
    private int listId;

    /**
     * The absolute file path that points to the file represented by this object.
     */
    @Column(name = "file_path")
    private String filePath;

    public int getSessionId() {

        return sessionId;

    }

    public void setSessionId(int sessionId) {

        this.sessionId = sessionId;

    }

    public int getListId() {

        return listId;

    }

    public void setListId(int listId) {

        this.listId = listId;

    }

    public String getFilePath() {

        return filePath;

    }

    public void setFilePath(String filePath) {

        this.filePath = filePath;

    }

    /**
     * A simple no-argument constructor.
     */
    public GameSession() {}

    /**
     * A simple, currently unused, constructor that can generate a full object.
     *
     * @param sessionId A unique auto-incremented value representing this specific object.
     * @param listId    A value that represents a unique record in the 'word_lists' table.
     * @param filePath  The absolute file path that points to the file represented by this object.
     */
    public GameSession(int sessionId, int listId, String filePath) {

        this.sessionId = sessionId;
        this.listId = listId;
        this.filePath = filePath;

    }

    /**
     * A simple toString() method that returns all values.
     *
     * @return A String that contains all variable names and their values.
     */
    public String toString() {

        return "sessionId: " + sessionId + "; listId: " + listId + "; filePath: " + filePath;

    }

}
