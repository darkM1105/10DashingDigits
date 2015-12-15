package game_resources.processing;

import game_resources.entity.PreGameInfoBean;
import game_resources.entity.Username;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;

/**
 * A class that generates a 'PreGameInfoBean' object based off of some randomly chosen necessary objects.
 *
 * @author mrclark@madisoncollege.edu
 */
public class Randomizer {

    private PreGameInfoBean bean = new PreGameInfoBean();
    private GameDAO dao = GameDAO.getPublicDAO();
    private Decompressor decompressor = new Decompressor();

    /**
     * Method that generates a 'PreGameInfoBean' object.
     *
     * @return  The randomly generated 'PreGameInfoBean' object.
     */
    public PreGameInfoBean generateInfoBean() {

        WordList wordList = dao.getRandomWordList();
        String usedWordList = wordList.getFilePath();
        String usedGameSession = dao.getRandomGameSession(wordList.getListId());

        String[] wordListArray = decompressor.processWordList(usedWordList);
        Integer[] gameSessionArray = decompressor.processGameSession(usedGameSession);
        String opponentUsername = getUsername(usedGameSession);

        bean.setWordListArray(wordListArray);
        bean.setGameSessionArray(gameSessionArray);
        bean.setUsername(Username.getUsername());
        bean.setOpponentUsername(opponentUsername);
        bean.setListId(wordList.getListId());

        return bean;

    }

    /**
     * Special method that retrieves a substring representing an embedded username.
     *
     * @param opponentUsername  A string filepath containing the embedded username.
     * @return      A substring representing the username.
     */
    private String getUsername(String opponentUsername) {

        opponentUsername = opponentUsername.substring((opponentUsername.lastIndexOf("\\") + 1), opponentUsername.lastIndexOf("ts"));

        return opponentUsername;

    }

}
