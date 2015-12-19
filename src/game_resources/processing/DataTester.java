package game_resources.processing;

import game_resources.custom_exceptions.ImpossibleRecordDataException;
import game_resources.entity.GameSession;
import game_resources.entity.WordList;
//import org.apache.log4j.Logger;

/**
 * Class full of overloaded methods that all test to see if an 'ImpossibleRecordDataException' should be thrown.
 *
 * @author mrclark@madisoncollege.edu
 */
public class DataTester {
    //private final Logger logger = Logger.getLogger(this.getClass());

    public void testForImpossibleData(int id) throws ImpossibleRecordDataException {

        if (id < 0) {

            //logger.info("Throwing new ImpossibleDataException");
            throw new ImpossibleRecordDataException();

        }

    }

    public void testForImpossibleData(GameSession record) throws ImpossibleRecordDataException {

        if ((record.getListId() < 0) || (record.getSessionId() < 0) ||
                (!(record.getFilePath().contains("C:\\10DashingDigitsDB\\GameSessions\\List")))) {

            //logger.info("Throwing new ImpossibleDataException");
            throw new ImpossibleRecordDataException();

        }

    }

    public void testForImpossibleData(WordList record) throws ImpossibleRecordDataException {

        if ((record.getListId() < 0) || (!(record.getFilePath().contains("C:\\10DashingDigitsDB\\WordLists")))) {

            //logger.info("Throwing new ImpossibleDataException");
            throw new ImpossibleRecordDataException();

        }

    }

}
