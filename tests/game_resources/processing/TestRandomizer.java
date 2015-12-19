package game_resources.processing;

import game_resources.entity.PreGameInfoBean;
import game_resources.entity.simple_info.Username;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestRandomizer {

    Randomizer randomizer;

    @Test
    public void testInstantiateRandomizer() {
        randomizer = new Randomizer();
        assertNotNull(randomizer);
    }

    @Test
    public void testGenerateInfoBean() {
        randomizer = new Randomizer();
        Username.setUsername("Dante1105");
        PreGameInfoBean infoBean = randomizer.generateInfoBean();
        assertNotNull(infoBean);
    }

    @Test
    public void testBeanWordListArraySize() {
        randomizer = new Randomizer();
        Username.setUsername("Dante1105");
        PreGameInfoBean testBean = randomizer.generateInfoBean();
        assertTrue("Testing the generated bean's word list array size.", (testBean.getWordListArray().length == 30));
    }

    @Test
    public void testBeanGameSessionArraySize() {
        randomizer = new Randomizer();
        Username.setUsername("Dante1105");
        PreGameInfoBean testBean = randomizer.generateInfoBean();
        assertTrue("Testing the generated bean's game session array size.", (testBean.getGameSessionArray().length == 210));
    }

    @Test
    public void testBeanUsername() {
        randomizer = new Randomizer();
        Username.setUsername("Dante1105");
        PreGameInfoBean testBean = randomizer.generateInfoBean();
        assertTrue("Testing the generated bean's username.", (testBean.getUsername().equals("Dante1105")));
    }

    @Test
    public void testBeanOpponentUsername() {
        randomizer = new Randomizer();
        Username.setUsername("Dante1105");
        PreGameInfoBean testBean = randomizer.generateInfoBean();
        assertTrue("Testing the generated bean's opponent username.", (testBean.getOpponentUsername() != null));
    }

    @Test
    public void testBeanListId() {
        randomizer = new Randomizer();
        Username.setUsername("Dante1105");
        PreGameInfoBean testBean = randomizer.generateInfoBean();
        assertTrue("Testing the generated bean's word list id.", (testBean.getListId() > 0));
    }

}
