package game_resources.processing;

import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDecompressor {

    Decompressor decompressor;

    @Test
    public void testInstantiateDecompressor() {
        decompressor = new Decompressor();
        assertNotNull(decompressor);
    }

    @Test
    public void testProcessWordList() {
        decompressor = new Decompressor();
        WordList randomWordList = GameDAO.getPublicDAO().getRandomWordList();
        String[] list = decompressor.processWordList(randomWordList.getFilePath());
        assertTrue("Testing to see if the returned array is a certain size.", (list.length == 30));
    }

    @Test
    public void testProcessGameSession() {
        decompressor = new Decompressor();
        WordList randomWordList = GameDAO.getPublicDAO().getRandomWordList();
        String randomGameSession = GameDAO.getPublicDAO().getRandomGameSession(randomWordList.getListId());
        Integer[] list = decompressor.processGameSession(randomGameSession);
        assertTrue("Testing to see if the returned array is a certain size.", (list.length == 210));
    }

    @Test
    public void testGetUsername() {
        decompressor = new Decompressor();
        WordList randomWordList = GameDAO.getPublicDAO().getRandomWordList();
        String randomGameSession = GameDAO.getPublicDAO().getRandomGameSession(randomWordList.getListId());
        decompressor.processGameSession(randomGameSession);
        assertNotNull(decompressor.getUsername());
    }

}
