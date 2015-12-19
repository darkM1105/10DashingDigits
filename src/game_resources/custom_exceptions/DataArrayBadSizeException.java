package game_resources.custom_exceptions;

/**
 * Custom exception that will be thrown when the data arrays being tested are too large or too small.
 * For example, the passed in Integer arrays should have a size of 210 elements and String arrays
 * should have a size of 30 elements.
 *
 * @author mrclark@madisoncollege.edu
 */
public class DataArrayBadSizeException extends Exception{

    private static final long serialVersionUID = 1105L;

    public DataArrayBadSizeException() {}

    public DataArrayBadSizeException(String message) {
        super(message);
    }

    public DataArrayBadSizeException(Throwable cause) {
        super(cause);
    }

    public DataArrayBadSizeException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataArrayBadSizeException(String message, Throwable cause,
                                     boolean enableSuppression, boolean writableStacktrace) {
        super(message, cause, enableSuppression, writableStacktrace);
    }

    public String getMessage() {
        return "The data arrays that were passed in weren't the correct size. GameSession arrays should have a size " +
                "of 210 while WordList arrays should have a size of 30.";
    }

}
