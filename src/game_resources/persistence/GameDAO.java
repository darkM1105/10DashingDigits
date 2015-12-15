package game_resources.persistence;

import game_resources.entity.GameSession;
import game_resources.entity.WordList;
import org.apache.commons.io.FileUtils;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Handles database actions for the GameSession and WordList object.
 * Contains methods to create a new session or word list.
 * Contains methods to search for a session or word list.
 * Contains methods to delete a session or word list.
 *
 * Of all the CRUD functions, it can do all of them except Update.
 * Update will never be needed.
 *
 * @author  Matthew Clark
 */
public class GameDAO {

    /**
     * The self-generated shared 'GameDAO' object.
     */
    private static GameDAO publicDAO = new GameDAO();

    public static GameDAO getPublicDAO() {

        return publicDAO;

    }

    /**
     * Method that creates a new record in the 'word_lists' table with the passed-in 'WordList' object.
     *
     * @param record    A full 'WordList' object that the new record will be based off of.
     * @return      The 'list_id' of the newly generated record.
     */
    public Integer createWordList(WordList record) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer listId = null;

        try {

            tx = session.beginTransaction();
            listId = (Integer)session.save(record);
            tx.commit();

        } catch (HibernateException hex) {

            if (tx != null) {

                tx.rollback();

            }

            hex.printStackTrace();

        } finally {

            session.close();

        }

        return listId;

    }

    /**
     * Method that creates a new record in the 'game_sessions' table with the passed-in 'GameSession' object.
     * At the moment, there is a hard limit of 10 'game_sessions' to each 'word_list'. Therefore, a randomly selected
     * 'game_session' will be deleted if the limit has been reached.
     *
     * @param record    A full 'GameSession' object that the new record will be based off of.
     * @return      The 'session_id' of the newly generated record.
     */
    public Integer createGameSession(GameSession record) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        Integer sessionId = null;

        try {

            //First ensuring that the database isn't full with a max record limit of 10 per word list.
            List<GameSession> records = getGameSessionsForWordList(record.getListId());
            if (records.size() == 10) {

                Random random = new Random();
                deleteOlderGameSession(records.get(random.nextInt(10)).getSessionId());

            }

            //Re-validating to ensure that the changes went through.
            records = getGameSessionsForWordList(record.getListId());
            if ((records.isEmpty()) || (records.size() < 10)) {

                tx = session.beginTransaction();
                sessionId = (Integer)session.save(record);
                tx.commit();

            }

        } catch (HibernateException hex) {

            if (tx != null) {

                tx.rollback();

            }

            hex.printStackTrace();

        } finally {

            session.close();

        }

        return sessionId;

    }

    /**
     * Method that returns a full 'WordList' object that has the same passed-in listId.
     *
     * @param listId    An integer representing the 'list_id' of the record being retrieved.
     * @return      The full 'WordList' object with the matching passed-in listId.
     */
    public WordList getWordListById(int listId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        WordList record = null;

        try {

            tx = session.beginTransaction();
            Query query = session.createQuery("from WordList wl where wl.listId = :listId");
            query.setString("listId", String.valueOf(listId));
            record = (WordList)query.list().get(0);

        } catch (HibernateException hex) {

            hex.printStackTrace();

        } finally {

            session.close();

        }

        return record;

    }

    /**
     * Method that returns a full 'GameSession' object that has the same passed-in sessionId.
     *
     * @param sessionId An integer representing the 'session_id' of the record being retrieved.
     * @return      The full 'GameSession' object with the matching passed-in sessionId.
     */
    public GameSession getGameSessionById(int sessionId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        GameSession record = null;

        try {

            tx = session.beginTransaction();
            Query query = session.createQuery("from GameSession gs where gs.sessionId = :sessionId");
            query.setString("sessionId", String.valueOf(sessionId));
            record = (GameSession)query.list().get(0);

        } catch (HibernateException hex) {

            hex.printStackTrace();

        } finally {

            session.close();

        }

        return record;

    }

    /**
     * Method that returns a randomly selected full 'WordList' object.
     * Side-note: This method doesn't connect to the database, but calls other methods that do.
     *
     * @return      The full randomly selected 'WordList' object.
     */
    public WordList getRandomWordList() {

        Random random = new Random();
        List<WordList> wordLists = getAllWordLists();
        WordList wordList = wordLists.get(random.nextInt(wordLists.size()));

        return wordList;

    }

    /**
     * Method that returns a randomly selected full 'GameSession' object that has the same passed-in listId.
     * Side-note: This method doesn't connect to the database, but calls other methods that do.
     *
     * @param listId    An integer representing the 'wl_list_id' that has to match in the randomly selected
     *                  'GameSession' object.
     * @return      The string representing the 'file_path' of the randomly selected 'GameSession' object.
     */
    public String getRandomGameSession(int listId) {

        String gameSessionFilePath;

        Random random = new Random();
        List<GameSession> gameSessions = getGameSessionsForWordList(listId);
        GameSession gameSession = gameSessions.get(random.nextInt(gameSessions.size()));
        gameSessionFilePath = gameSession.getFilePath();

        return gameSessionFilePath;

    }

    /**
     * Method that returns a list representing all 'WordList' objects based off of all 'word_list' records.
     *
     * @return      A list representing all 'WordList' objects based off of all 'word_list' records.
     */
    public List<WordList> getAllWordLists() {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<WordList> records = new ArrayList<>();

        try {

            tx = session.beginTransaction();
            records = (ArrayList<WordList>)session.createQuery("from WordList").list();

        } catch (HibernateException hex) {

            hex.printStackTrace();

        } finally {

            session.close();

        }

        return records;

    }

    /**
     * Method that returns a list representing all 'GameSession' objects based off of all 'game_session' records with
     * the same passed-in listId.
     *
     * @param listId    An integer representing the 'wl_list_id' that has to match in the selected 'GameSession' objects.
     * @return      A list representing all 'GameSession' objects based off of all 'game_session' records with the same
     *              passed-in listId.
     */
    public List<GameSession> getGameSessionsForWordList(int listId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        List<GameSession> records = new ArrayList<>();

        try {

            tx = session.beginTransaction();
            Query query = session.createQuery("from GameSession gs where gs.listId = :listId");
            query.setString("listId", String.valueOf(listId));
            records = (ArrayList<GameSession>)query.list();

        } catch (HibernateException hex) {

            hex.printStackTrace();

        } finally {

            session.close();

        }

        return records;

    }

    /**
     * Method that deletes a 'word_list' record representing the 'WordList' object with the same passed-in listId. In
     * addition, it also deletes the actual file represented by the filepath in the 'WordList' object.
     *
     * @param listId    An integer representing the 'list_id' of the record being deleted.
     */
    public void deleteWordList(int listId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String filePath = getWordListById(listId).getFilePath();

        try {

            deleteGameSessionsForWordList(listId);
            tx = session.beginTransaction();
            Query query = session.createQuery("delete WordList wl where wl.listId = :listId");
            query.setString("listId", String.valueOf(listId));
            query.executeUpdate();
            tx.commit();

        } catch (HibernateException hex) {

            if (tx != null) {

                tx.rollback();

            }

            hex.printStackTrace();

        } finally {

            session.close();

        }

        try {

            File file = new File(filePath);
            file.delete();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    /**
     * Method that deletes all 'game_session' records representing the 'GameSession' objects with the same passed-in
     * wordListId. In addition, it also deletes the actual files represented by the filepaths in the 'GameSession'
     * objects.
     *
     * @param listId    An integer representing the 'wl_list_id' of the records being deleted.
     */
    public void deleteGameSessionsForWordList(int listId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;

        try {

            tx = session.beginTransaction();
            Query query = session.createQuery("delete GameSession gs where gs.listId = :listId");
            query.setString("listId", String.valueOf(listId));
            query.executeUpdate();
            tx.commit();

        } catch (HibernateException hex) {

            if (tx != null) {

                tx.rollback();

            }

            hex.printStackTrace();

        } finally {

            session.close();

        }

        try {

            FileUtils.deleteDirectory(new File("C:\\10DashingDigitsDB\\GameSessions\\List" + listId));

        } catch (IOException e) {

            e.printStackTrace();

        }

    }

    /**
     * Method that deletes the 'game_session' record representing the 'GameSession' object with the same passed-in
     * sessionId. In addition, it also deletes the actual file represented by the filepath in the 'GameSession' object.
     *
     * @param sessionId An integer representing the 'session_id' of the record being deleted.
     */
    public void deleteOlderGameSession(int sessionId) {

        Session session = SessionFactoryProvider.getSessionFactory().openSession();
        Transaction tx = null;
        String filePath = getGameSessionById(sessionId).getFilePath();

        try {

            tx = session.beginTransaction();
            Query query = session.createQuery("delete GameSession gs where gs.sessionId = :sessionId");
            query.setString("sessionId", String.valueOf(sessionId));
            query.executeUpdate();
            tx.commit();

        } catch (HibernateException hex) {

            if (tx != null) {

                tx.rollback();

            }

            hex.printStackTrace();

        } finally {

            session.close();

        }

        try {

            File file = new File(filePath);
            file.delete();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}