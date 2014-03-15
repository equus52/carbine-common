package equus.carbine.util;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class DateSupportTest {

    @Test
    public void testPrivateConstractor() {
        TestUtils.privateConstractor(DateSupport.class).newInstance();
    }

    @Test
    public void testGetCurrentDate() {
        String actual = new DateSupport().getCurrentDate();
        String expected = new SimpleDateFormat("yyyyMMdd").format(new Date());
        assertThat(actual, is(expected));
    }

    @Test
    public void testGetDifDate() {
        assertThat(new DateSupport().getDifDate("20110331", "20110331"), is(0L));
        assertThat(new DateSupport().getDifDate("20110331", "20110401"), is(1L));
        assertThat(new DateSupport().getDifDate("20110331", "20110330"), is(-1L));
        assertThat(new DateSupport().getDifDate("20110331", "20110501"), is(31L));
        try {
            new DateSupport().getDifDate("201103xx", "20110331");
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

    @Test
    public void testAddYear() {
        assertThat(new DateSupport().addYear("20110331", 0), is("20110331"));
        assertThat(new DateSupport().addYear("20110331", 1), is("20120331"));
        assertThat(new DateSupport().addYear("20110331", -1), is("20100331"));
        assertThat(new DateSupport().addYear("20110331", 10), is("20210331"));
        try {
            new DateSupport().addYear("201103xx", 0);
            fail();
        } catch (IllegalArgumentException e) {
            assertTrue(true);
        }
    }

}
