package game_resources.processing;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestRandomizedName {

    RandomizedName randomizedName;

    @Test
    public void testInstantiateRandomizedName() {
        randomizedName = new RandomizedName();
        assertNotNull(randomizedName);
    }

    @Test
    public void testGenerateRandomName() {
        randomizedName = new RandomizedName();
        String name = randomizedName.generateRandomName();
        assertTrue("Testing to see if the returned string has a minimally expected value.", (name.length() > 8));
    }

}
