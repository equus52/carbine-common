package equus.carbine.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestUtilsTest {

    @Test
    public void testGetMilliTime() {
        Runnable runnable = new Runnable() {

            @Override
            public void run() {
                @SuppressWarnings("unused")
                int value = 1 + 1;
            }
        };
        double time1 = TestUtils.getMilliTime(runnable);
        double time2 = TestUtils.getMilliTime(runnable, 100);
        System.out.println(time1);
        System.out.println(time2);
    }

    @Test
    public void testGetUsedMemory() {
        long used1 = TestUtils.getUsedMemory();
        long used2 = TestUtils.getUsedMemory();
        long actual = used2 - used1;
        System.out.println(used1);
        System.out.println(used2);
        assertEquals(0, actual);
    }
}
