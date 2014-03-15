package equus.carbine.exception;

@SuppressWarnings("serial")
public class NoSuchMethodRuntimeException extends RuntimeException {

    public NoSuchMethodRuntimeException() {
        super();
    }

    public NoSuchMethodRuntimeException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NoSuchMethodRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoSuchMethodRuntimeException(Throwable cause) {
        super(cause);
    }

    public NoSuchMethodRuntimeException(final String message) {
        super(message);
    }

    public NoSuchMethodRuntimeException(final Exception cause) {
        super(cause);
    }
}
