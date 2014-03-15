package equus.carbine.extension;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

public class StringExTest {

    @SuppressWarnings("null")
    @Test(expected = NullPointerException.class)
    public void test_null() {
        new StringEx(null);
    }

    @Test
    public void test_lengthByte() {
        assertThat(new StringEx("").lengthByte(), is(0));
        assertThat(new StringEx("1").lengthByte(), is(1));
    }
}
