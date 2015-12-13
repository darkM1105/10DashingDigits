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

    private static GameDAO publicDAO = new GameDAO();

    public static GameDAO getPublicDAO() {

        return publicDAO;

    }

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

    public WordList getRandomWordList() {

        Random random = new Random();
        List<WordList> wordLists = getAllWordLists();
        WordList wordList = wordLists.get(random.nextInt(wordLists.size()));

        return wordList;

    }

    public String getRandomGameSession(int listId) {

        String gameSessionFilePath;

        Random random = new Random();
        List<GameSession> gameSessions = getGameSessionsForWordList(listId);
        GameSession gameSession = gameSessions.get(random.nextInt(gameSessions.size()));
        gameSessionFilePath = gameSession.getFilePath();

        return gameSessionFilePath;

    }

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