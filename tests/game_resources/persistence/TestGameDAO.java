package game_resources.persistence;

import game_resources.entity.GameSession;
import game_resources.entity.WordList;
import org.junit.Ignore;
import org.junit.Test;
import java.util.List;

import static org.junit.Assert.*;

public class TestGameDAO {

    GameDAO gameDAO;
    WordList customWordList;
    GameSession customGameSession;
    int createdWordList;
    int createdGameSession;

    @Test
    public void testInstantiateGameDAO() {
        gameDAO = new GameDAO();
        assertNotNull(gameDAO);
    }

    @Test
    public void testGetPublicGameDAO() {
        gameDAO = GameDAO.getPublicDAO();
        assertNotNull(gameDAO);
    }

    @Test
    public void testCreateWordList() {
        gameDAO = GameDAO.getPublicDAO();
        customWordList = new WordList(0, "C:\\10DashingDigitsDB\\WordLists\\whatever.txt");
        createdWordList = gameDAO.createWordList(customWordList);
        assertTrue("Testing to see if a value greater than zero is returned.", (createdWordList > 0));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateWordListException() {
        gameDAO = GameDAO.getPublicDAO();
        WordList wordList = new WordList((-1), "");
        createdWordList = gameDAO.createWordList(wordList);
        fail("Expected a NullPointerException");
    }

    @Test
    public void testCreateGameSession() {
        gameDAO = GameDAO.getPublicDAO();
        List<WordList> bigList = gameDAO.getAllWordLists();
        customGameSession = new GameSession(0, bigList.get(0).getListId(), "C:\\10DashingDigitsDB\\GameSessions\\List3\\darkM.txt");
        createdGameSession = gameDAO.createGameSession(customGameSession);
        assertTrue("Testing to see if a value greater than zero is returned.", (createdGameSession > 0));
    }

    @Test(expected = NullPointerException.class)
    public void testCreateGameSessionException() {
        gameDAO = GameDAO.getPublicDAO();
        GameSession gameSession = new GameSession((-1), (-1), "");
        createdGameSession = gameDAO.createGameSession(gameSession);
        fail("Expected a NullPointerException");
    }

    @Test
    public void testGetWordListById() {
        gameDAO = GameDAO.getPublicDAO();
        WordList wordList = new WordList(0, "C:\\10DashingDigitsDB\\WordLists\\whatever.txt");
        int createdList = gameDAO.createWordList(wordList);
        WordList receivedWordList = gameDAO.getWordListById(createdList);
        assertNotNull(receivedWordList);
    }

    @Test
    public void testGetWordListByIdException() {
        gameDAO = GameDAO.getPublicDAO();
        WordList wordList = gameDAO.getWordListById(-1);
        assertTrue("Excpecting a null WordList.", (wordList == null));
    }

    @Test
    public void testGetGameSessionById() {
        gameDAO = GameDAO.getPublicDAO();
        List<WordList> bigList = gameDAO.getAllWordLists();
        GameSession gameSession = new GameSession(0, bigList.get(0).getListId(), "C:\\10DashingDigitsDB\\GameSessions\\List3\\darkM.txt");
        int createdSession = gameDAO.createGameSession(gameSession);
        GameSession receivedGameSession = gameDAO.getGameSessionById(createdSession);
        assertNotNull(receivedGameSession);
    }

    @Test
    public void testGetGameSessionByIdException() {
        gameDAO = GameDAO.getPublicDAO();
        GameSession gameSession = gameDAO.getGameSessionById(-1);
        assertTrue("Expecting a null GameSession", (gameSession == null));
    }

    @Test
    public void testGetRandomWordList() {
        gameDAO = GameDAO.getPublicDAO();
        WordList wordList = gameDAO.getRandomWordList();
        assertNotNull(wordList);
    }

    @Test
    public void testGetRandomGameSession() {
        gameDAO = GameDAO.getPublicDAO();
        List<WordList> bigList = gameDAO.getAllWordLists();
        String gameSession = gameDAO.getRandomGameSession(bigList.get(0).getListId());
        assertNotNull(gameSession);
    }

    @Test
    public void testGetRandomGameSessionException() {
        gameDAO = GameDAO.getPublicDAO();
        String gameSession = gameDAO.getRandomGameSession(-1);
        assertNull(gameSession);
    }

    @Test
    public void testGetAllWordLists() {
        gameDAO = GameDAO.getPublicDAO();
        List<WordList> list = gameDAO.getAllWordLists();
        assertTrue("Testing to see if the returned list has a size greater than zero.", (list.size() > 0));
    }

    @Test
    public void testGetGameSessionsForWordList() {
        gameDAO = GameDAO.getPublicDAO();
        List<WordList> bigList = gameDAO.getAllWordLists();
        List<GameSession> list = gameDAO.getGameSessionsForWordList(bigList.get(0).getListId());
        assertTrue("Testing to see if the returned list has a size greater than zero.", (list.size() > 0));
    }

    @Test
    public void testGetGameSessionsForWordListException() {
        gameDAO = GameDAO.getPublicDAO();
        List<GameSession> list = gameDAO.getGameSessionsForWordList(-1);
        assertTrue("Testing for an empty array.", list.isEmpty());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testDeleteWordList() {
        gameDAO = GameDAO.getPublicDAO();
        WordList wordList = new WordList(0, "C:\\10DashingDigitsDB\\WordLists\\whatever2.txt");
        int wordListId = gameDAO.createWordList(wordList);
        gameDAO.deleteWordList(wordListId);
        gameDAO.getWordListById(wordListId);
        fail("Expected IndexOutOfBoundsException.");
    }

    @Test
    public void testDeleteGameSessionsForWordList() {
        gameDAO = GameDAO.getPublicDAO();
        int countBefore = 0;
        int countAfter = 0;
        WordList wordList = new WordList(0, "C:\\10DashingDigitsDB\\WordLists\\whatever.txt");
        int listId = gameDAO.createWordList(wordList);
        GameSession gameSession = new GameSession(0, listId, "C:\\10DashingDigitsDB\\GameSessions\\List3\\darkM.txt");
        int sessionId = gameDAO.createGameSession(gameSession);
        List<WordList> listBefore = gameDAO.getAllWordLists();
        for (int i = 0; i < listBefore.size(); i++) {
            List<GameSession> sublist = gameDAO.getGameSessionsForWordList(listBefore.get(i).getListId());
            countBefore += sublist.size();
        }
        gameDAO.deleteGameSessionsForWordList(-1);
        List<WordList> listAfter = gameDAO.getAllWordLists();
        for (int i = 0; i < listAfter.size(); i++) {
            List<GameSession> sublist = gameDAO.getGameSessionsForWordList(listAfter.get(i).getListId());
            countAfter += sublist.size();
        }
        assertTrue("Testing to see if there is the same number of WordLists in the database.", (countBefore == countAfter));
    }

}