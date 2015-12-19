package game_resources.processing;

import game_resources.entity.PreGameInfoBean;
import game_resources.entity.simple_info.Username;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;
//import org.apache.log4j.Logger;

/**
 * A class that generates a 'PreGameInfoBean' object based off of some randomly chosen necessary objects.
 *
 * @author mrclark@madisoncollege.edu
 */
public class Randomizer {
    //private final Logger logger = Logger.getLogger(this.getClass());

    private PreGameInfoBean bean = new PreGameInfoBean();
    private GameDAO dao = GameDAO.getPublicDAO();
    private Decompressor decompressor = new Decompressor();

    /**
     * Method that generates a 'PreGameInfoBean' object.
     *
     * @return  The randomly generated 'PreGameInfoBean' object.
     */
    public PreGameInfoBean generateInfoBean() {

        //logger.info("Generating InfoBean.");

        WordList wordList = dao.getRandomWordList();
        String usedWordList = wordList.getFilePath();
        String usedGameSession = dao.getRandomGameSession(wordList.getListId());

        String[] wordListArray = decompressor.processWordList(usedWordList);
        Integer[] gameSessionArray = decompressor.processGameSession(usedGameSession);

        bean.setWordListArray(wordListArray);
        bean.setGameSessionArray(gameSessionArray);
        bean.setUsername(Username.getUsername());
        bean.setOpponentUsername(decompressor.getUsername());
        bean.setListId(wordList.getListId());

        //logger.info(bean.toString());

        return bean;

    }

}
