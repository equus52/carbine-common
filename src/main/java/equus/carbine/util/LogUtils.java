package equus.carbine.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogConfigurationException;
import org.apache.commons.logging.LogFactory;

public final class LogUtils {

    /**
     * Get Log object.
     * 
     * @return Log object
     */
    public static Log getLog() {
        StackTraceElement[] stackTraces = new Throwable().getStackTrace();
        System.out.println("stack size is " + stackTraces.length);
        String sourceClassName = stackTraces[1].getClassName();
        try {
            return LogFactory.getLog(Class.forName(sourceClassName));
        } catch (LogConfigurationException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
