package equus.carbine.util;

import org.junit.Test;

public class GenericsUtilsTest {

    @Test
    public void testPrivateConstractor() {
        TestUtils.privateConstractor(GenericsUtils.class).newInstance();
    }

    @SuppressWarnings("unused")
    @Test
    public void testCast() {
        Object obj = "";
        String str = GenericsUtils.cast(obj);
    }
}
