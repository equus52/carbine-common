package equus.carbine.exception;

@SuppressWarnings("serial")
public final class RuntimeInstantiationException extends RuntimeException {

    public RuntimeInstantiationException() {
        super();
    }

    public RuntimeInstantiationException(String message, Throwable cause, boolean enableSuppression,
                    boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public RuntimeInstantiationException(String message, Throwable cause) {
        super(message, cause);
    }

    public RuntimeInstantiationException(String message) {
        super(message);
    }

    public RuntimeInstantiationException(Throwable cause) {
        super(cause);
    }

}
