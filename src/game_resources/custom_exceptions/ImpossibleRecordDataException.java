package game_resources.custom_exceptions;

/**
 * Created by Matthew on 12/17/2015.
 */
public class ImpossibleRecordDataException extends Exception{

    private static final long serialVersionUID = 115L;

    public ImpossibleRecordDataException() {}

    public ImpossibleRecordDataException(String message) {
        super(message);
    }

    public ImpossibleRecordDataException(Throwable cause) {
        super(cause);
    }

    public ImpossibleRecordDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImpossibleRecordDataException(String message, Throwable cause,
                                         boolean enableSuppression, boolean writableStacktrace) {
        super(message, cause, enableSuppression, writableStacktrace);
    }

    public String getMessage() {
        return "The data making up the record is impossible. An example is an id less than zero or incorrect file path" +
                " syntax.";
    }

}
