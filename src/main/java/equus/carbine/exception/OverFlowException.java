package equus.carbine.exception;

@SuppressWarnings("serial")
public final class OverFlowException extends RuntimeException {

    public OverFlowException() {
        super();
    }

    public OverFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public OverFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public OverFlowException(String message) {
        super(message);
    }

    public OverFlowException(Throwable cause) {
        super(cause);
    }

}
