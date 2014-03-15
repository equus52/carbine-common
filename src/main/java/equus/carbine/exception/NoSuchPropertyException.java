package equus.carbine.exception;

import javax.annotation.Nullable;

/**
 * Exception thrown when public field or setter is not found.
 */
@SuppressWarnings("serial")
public final class NoSuchPropertyException extends RuntimeException {

    public NoSuchPropertyException(final String property, @Nullable final Throwable cause) {
        super("Not Found property. name: " + property, cause);
    }

    public NoSuchPropertyException(final String property) {
        this(property, null);
    }

    public NoSuchPropertyException(final Throwable cause) {
        super(cause);
    }

}
