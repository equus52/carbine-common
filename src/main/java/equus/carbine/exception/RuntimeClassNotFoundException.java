package equus.carbine.exception;

@SuppressWarnings("serial")
public final class RuntimeClassNotFoundException extends RuntimeException {

    public RuntimeClassNotFoundException() {
        super();
    }

    public RuntimeClassNotFoundException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RuntimeClassNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeClassNotFoundException(String message) {
        super(message);
    }

    public RuntimeClassNotFoundException(Throwable cause) {
        super(cause);
    }

}
