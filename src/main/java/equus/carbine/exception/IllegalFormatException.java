package equus.carbine.exception;

@SuppressWarnings("serial")
public class IllegalFormatException extends Exception {

    public IllegalFormatException() {
        super();
    }

    public IllegalFormatException(String message) {
        super(message);
    }

    public IllegalFormatException(Throwable cause) {
        super(cause);
    }

    public IllegalFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IllegalFormatException(String message, Throwable cause) {
        super(message, cause);
    }
}
