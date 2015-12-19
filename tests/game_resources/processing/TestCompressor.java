package game_resources.processing;

import game_resources.custom_exceptions.DataArrayBadSizeException;
import game_resources.entity.WordList;
import game_resources.persistence.GameDAO;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TestCompressor {

    Compressor compressor;
    RandomizedData randomizedData = new RandomizedData();

    @Test
    public void testInstantiateCompressor() {
        compressor = new Compressor();
        assertNotNull(compressor);
    }

    @Test
    public void testProcessWithIntegerArray() {
        compressor = new Compressor();
        GameDAO gameDAO = GameDAO.getPublicDAO();
        List<WordList> bigList = gameDAO.getAllWordLists();
        Integer[] data = randomizedData.generateRandomGameSessionData();
        int record = compressor.process(data, bigList.get(0).getListId(), "darkM");
        assertTrue("Testing to see if a number comes back after updating the database.", (record > 0));
    }

    @Test
    public void testProcessWithIntegerArrayException() {
        compressor = new Compressor();
        Integer[] data = new Integer[0];
        int record = compressor.process(data, 1, "darkM");
        assertTrue("Testing to see if a negative value is returned.", (record == -1));
    }

    @Test
    public void testProcessWithStringArray() {
        compressor = new Compressor();
        String[] data = randomizedData.generateRandomWordListData();
        int record = compressor.process(data);
        assertTrue("Testing to see if a number comes back after updating the database.", (record > 0));
    }

    @Test
    public void testProcessWithStringArrayException() {
        compressor = new Compressor();
        String[] data = new String[0];
        int record = compressor.process(data);
        assertTrue("Testing to see if a negative value is returned.", (record == -1));
    }

}
