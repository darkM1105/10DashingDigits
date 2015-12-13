package game_resources.processing;

import game_resources.entity.InfoBean;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;

public class Randomizer {

    private InfoBean bean = new InfoBean();
    private GameDAO dao = GameDAO.getPublicDAO();
    private Decompressor decompressor = new Decompressor();

    public InfoBean generateInfoBean(String username) {

        WordList wordList = dao.getRandomWordList();
        String usedWordList = wordList.getFilePath();
        String usedGameSession = dao.getRandomGameSession(wordList.getListId());

        String[] wordListArray = decompressor.processWordList(usedWordList);
        Integer[] gameSessionArray = decompressor.processGameSession(usedGameSession);
        String opponentUsername = getUsername(usedGameSession);

        bean.setWordListArray(wordListArray);
        bean.setGameSessionArray(gameSessionArray);
        bean.setUsername(username);
        bean.setOpponentUsername(opponentUsername);

        return bean;

    }

    private String getUsername(String opponentUsername) {

        opponentUsername = opponentUsername.substring((opponentUsername.lastIndexOf("\\") + 1), opponentUsername.lastIndexOf("ts"));

        return opponentUsername;

    }

}