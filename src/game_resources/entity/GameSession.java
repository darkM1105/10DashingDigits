package game_resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Matthew on 12/7/2015.
 */

@Entity
@Table(name = "game_sessions")
public class GameSession {

    @Column(name = "session_id")
    private int sessionId;

    @Column(name = "wl_list_id")
    private int listId;

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

    public GameSession() {}

    public GameSession(int sessionId, int listId, String filePath) {

        this.sessionId = sessionId;
        this.listId = listId;
        this.filePath = filePath;

    }

    public String toString() {

        return "sessionId: " + sessionId + "; listId: " + listId + "; filePath: " + filePath;

    }

}
