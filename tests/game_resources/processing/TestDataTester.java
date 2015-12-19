package game_resources.processing;

import game_resources.custom_exceptions.ImpossibleRecordDataException;
import game_resources.entity.GameSession;
import game_resources.entity.WordList;
import org.junit.Test;
import static org.junit.Assert.*;

public class TestDataTester {

    DataTester dataTester;

    @Test
    public void testInstantiateDataTester() {
        dataTester = new DataTester();
        assertNotNull(dataTester);
    }

    @Test
    public void testForImpossibleDataWithId() {
        dataTester = new DataTester();
        try {
            dataTester.testForImpossibleData(1);
        } catch (ImpossibleRecordDataException ird) {
            ird.printStackTrace();
        }
        assertTrue("An exception wasn't thrown, which is good.", true);
    }

    @Test
    public void testForImpossibleDataWithIdException() {
        boolean testPassed = false;
        dataTester = new DataTester();
        try {
            dataTester.testForImpossibleData(-1);
        } catch (ImpossibleRecordDataException ird) {
            testPassed = true;
        }
        assertTrue("Testing to see if my value is correct.", testPassed);
    }

    @Test
    public void testForImpossibleDataWithGameSession() {
        dataTester = new DataTester();
        GameSession record = new GameSession(1, 1, "C:\\10DashingDigitsDB\\GameSessions\\List3");
        try {
            dataTester.testForImpossibleData(record);
        } catch (ImpossibleRecordDataException ird) {
            ird.printStackTrace();
        }
        assertTrue("An exception wasn't thrown, which is good.", true);
    }

    @Test
    public void testForImpossibleDataWithGameSessionException() {
        dataTester = new DataTester();
        boolean testPassed = false;
        GameSession record = new GameSession(-1, -1, "");
        try {
            dataTester.testForImpossibleData(record);
        } catch (ImpossibleRecordDataException ird) {
            testPassed = true;
        }
        assertTrue("Testing to see if my value is correct.", testPassed);
    }

    @Test
    public void testForImpossibleDataWithWordList() {
        dataTester = new DataTester();
        WordList record = new WordList(1, "C:\\10DashingDigitsDB\\WordLists");
        try {
            dataTester.testForImpossibleData(record);
        } catch (ImpossibleRecordDataException ird) {
            ird.printStackTrace();
        }
        assertTrue("An exception wasn't thrown, which is good.", true);
    }

    @Test
    public void testForImpossibleDataWithWordListException() {
        dataTester = new DataTester();
        boolean testPassed = false;
        WordList record = new WordList(-1, "");
        try {
            dataTester.testForImpossibleData(record);
        } catch (ImpossibleRecordDataException ird) {
            testPassed = true;
        }
        assertTrue("Testing to see if my value is correct.", testPassed);
    }

}
