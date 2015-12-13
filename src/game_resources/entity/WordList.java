package game_resources.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by Matthew on 12/7/2015.
 */

@Entity
@Table(name = "word_lists")
public class WordList {

    @Column(name = "list_id")
    private int listId;

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

    public WordList() {}

    public WordList(int listId, String filePath) {

        this.listId = listId;
        this.filePath = filePath;

    }

    public String toString() {

        return "listId: " + listId + "; filePath: " + filePath;

    }

}
