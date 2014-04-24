package equus.carbine.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class LogUtils {

    /**
     * Get Log object.
     * 
     * @return Log object
     */
    public static Logger getLog() {
        StackTraceElement[] stackTraces = new Throwable().getStackTrace();
        System.out.println("stack size is " + stackTraces.length);
        String sourceClassName = stackTraces[1].getClassName();
        try {
            return LoggerFactory.getLogger(Class.forName(sourceClassName));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
