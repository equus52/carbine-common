package equus.carbine.extension;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import lombok.experimental.ExtensionMethod;

import org.junit.Test;

@ExtensionMethod(StringExtensions.class)
public class StringExtensionsTest {

  @Test
  public void test_lengthByte() {
    assertThat("".lengthByte(), is(0));
    assertThat("1".lengthByte(), is(1));
  }
}
