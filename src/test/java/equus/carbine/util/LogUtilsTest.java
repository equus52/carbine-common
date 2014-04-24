package equus.carbine.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogUtilsTest {

    private static Logger LOGGER = LoggerFactory.getLogger(LogUtilsTest.class);

    private static Logger LOGGER2 = LogUtils.getLog();

    @Test
    public void test_getLog() throws Exception {
        Logger log = LogUtils.getLog();
        assertEquals(log, LOGGER);
        assertEquals(LOGGER2, LOGGER);
        LOGGER.info("test");
    }

    int stack = 0;

    @Test
    public void test_getLog_performance_1() throws Exception {
        {
            double time = TestUtils.getMilliTime(new Runnable() {

                @Override
                public void run() {
                    LogUtilsTest.class.getName();
                }
            });
            System.out.println(time);
        }
        {
            double time = TestUtils.getMilliTime(new Runnable() {

                @Override
                public void run() {
                    LoggerFactory.getLogger(LogUtilsTest.class);
                }
            });
            System.out.println(time);
        }
    }

    private void getLog() {
        double time = TestUtils.getMilliTime(new Runnable() {

            @Override
            public void run() {
                LogUtils.getLog();
            }
        });
        System.out.println(time);
    }

    @Test
    public void test_getLog_performance_2() throws Exception {
        LogUtilsTest.class.getName();
        getLog();
    }

    @Test
    public void test_getLog_performance_3() throws Exception {
        LogUtilsTest.class.getName();
        stackGetLog();
    }

    private void stackGetLog() {
        stack++;
        if (stack > 1000) {
            getLog();
            return;
        }
        stackGetLog();
    }

}
