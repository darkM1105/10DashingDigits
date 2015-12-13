package game_resources.entity;

public class InfoBean {

    private String[] wordListArray;
    private Integer[] gameSessionArray;
    private String username;
    private String opponentUsername;

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

    public InfoBean() {}

    public InfoBean(String[] wordListArray, Integer[] gameSessionArray, String username, String opponentUsername) {

        this.wordListArray = wordListArray;
        this.gameSessionArray = gameSessionArray;
        this.username = username;
        this.opponentUsername = opponentUsername;

    }

    public String toString() {

        return "wordListArray size: " + wordListArray.length + "; gameSessionArray size: " + gameSessionArray.length
                + "; username: " + username + "opponentUsername: " + opponentUsername;

    }

}
