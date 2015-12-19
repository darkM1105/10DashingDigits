package game_resources.processing;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRandomizedData {

    RandomizedData randomizedData;

    @Test
    public void testInstantiateRandomizedData() {
        randomizedData = new RandomizedData();
        assertNotNull(randomizedData);
    }

    @Test
    public void testGenerateRandomGameSession() {
        randomizedData = new RandomizedData();
        Integer[] data = randomizedData.generateRandomGameSessionData();
        assertTrue("Testing to see if the returned array has a length greater than 0", (data.length > 0));
    }

    @Test
    public void testIntegerArraySize() {
        randomizedData = new RandomizedData();
        Integer[] data = randomizedData.generateRandomGameSessionData();
        assertTrue("Testing to see if the returned array has a length of 210.", (data.length == 210));
    }

    @Test
    public void testGenerateRandomWordList() {
        randomizedData = new RandomizedData();
        String[] data = randomizedData.generateRandomWordListData();
        assertTrue("Testing to see if the returned array has a length greater than 0", (data.length > 0));
    }

    @Test
    public void testStringArraySize() {
        randomizedData = new RandomizedData();
        String[] data = randomizedData.generateRandomWordListData();
        assertTrue("Testing to see if the returned array has a length of 30.", (data.length == 30));
    }

}
