package equus.carbine.util;

import static com.google.common.base.Preconditions.checkNotNull;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.SystemUtils;

public final class ErrorMessages {

    private final List<String> messageList = new ArrayList<>();

    /**
     * Add error message.
     * 
     * @param message error message
     */
    public void add(String message) {
        checkNotNull(message, "message must not be null.");
        messageList.add(message);
    }

    /**
     * If exists error, return <code>true</code>.
     * 
     * @return If exists error, return <code>true</code>.
     */
    public boolean hasError() {

        return !messageList.isEmpty();
    }

    /**
     * Get error message.Separator is line separator.
     * 
     * @return error message
     */
    public String getMessage() {
        return getMessage(SystemUtils.LINE_SEPARATOR);
    }

    /**
     * Get error message.
     * 
     * @param separator separator
     * @return error message
     */
    public String getMessage(String separator) {
        checkNotNull(separator, "separator must not be null.");
        return StringUtils.join(messageList, separator);
    }
}
