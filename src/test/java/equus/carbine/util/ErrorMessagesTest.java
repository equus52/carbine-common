package equus.carbine.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class ErrorMessagesTest {

    @Test
    public void testAdd() {
        ErrorMessages errors = new ErrorMessages();
        errors.add("message");
        assertThat(errors.hasError(), is(true));
    }

    @Test
    public void testIsError() {
        ErrorMessages errors = new ErrorMessages();
        assertThat(errors.hasError(), is(false));
        errors.add("message");
        assertThat(errors.hasError(), is(true));
    }

    @Test
    public void testGetMessage() {
        {
            ErrorMessages errors = new ErrorMessages();
            errors.add("message");
            assertThat(errors.getMessage(), is("message"));
        }
        {
            ErrorMessages errors = new ErrorMessages();
            errors.add("message1");
            errors.add("message2");
            assertThat(errors.getMessage(), is("message1" + System.getProperty("line.separator") + "message2"));
        }
    }
}
