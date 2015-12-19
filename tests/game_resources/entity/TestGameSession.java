package game_resources.entity;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestGameSession {

    GameSession gameSession;

    @Test
    public void testInstantiateGameSessionWithoutParameters() {
        gameSession = new GameSession();
        assertNotNull(gameSession);
    }

    @Test
    public void testInstantiateGameSessionWithParameters() {
        gameSession = new GameSession(0, 0, null);
        assertNotNull(gameSession);
    }

    @Test
    public void testGameSessionToString() {
        gameSession = new GameSession(0, 0, "");
        String actualString = gameSession.toString();
        String expectedString = "sessionId: 0; listId: 0; filePath: ";
        assertEquals("Testing the 'GameSession' toString() method.", expectedString, actualString);
    }

}
