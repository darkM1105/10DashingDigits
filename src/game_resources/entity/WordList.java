package game_resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * A simple bean that represents a record in the 'word_lists' table.
 *
 * @author mrclark@madisoncollege.edu
 */

@Entity
@Table(name = "word_lists")
public class WordList {

    /**
     * A unique auto-incremented value representing this specific object.
     */
    @Column(name = "list_id")
    private int listId;

    /**
     * The absolute file path that points to the file represented by this object.
     */
    @Column(name = "file_path")
    private String filePath;

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
    public WordList() {}

    /**
     * A simple, currently unused, constructor that can generate a full object.
     *
     * @param listId    A unique auto-incremented value representing this specific object.
     * @param filePath  The absolute file path that points to the file represented by this object.
     */
    public WordList(int listId, String filePath) {

        this.listId = listId;
        this.filePath = filePath;

    }

    /**
     * A simple toString() method that returns all values.
     *
     * @return A String that contains all variable names and their values.
     */
    public String toString() {

        return "listId: " + listId + "; filePath: " + filePath;

    }

}
