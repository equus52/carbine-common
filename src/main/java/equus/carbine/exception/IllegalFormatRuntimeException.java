package equus.carbine.exception;

@SuppressWarnings("serial")
public class IllegalFormatRuntimeException extends RuntimeException {

    public IllegalFormatRuntimeException() {
        super();
    }

    public IllegalFormatRuntimeException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public IllegalFormatRuntimeException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public IllegalFormatRuntimeException(final String message) {
        super(message);
    }

    public IllegalFormatRuntimeException(final Throwable cause) {
        super(cause);
    }

}
