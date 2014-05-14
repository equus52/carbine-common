package equus.carbine.patternmatch;

import static equus.carbine.patternmatch.PatternMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import lombok.experimental.ExtensionMethod;

import org.junit.Test;

@ExtensionMethod(PatternMatchers.class)
public class PatternMatchersTest {

  @Test
  public void match_class_case() {
    String str = "test";
    str.match(//
        case_(Integer.class, i -> fail()), //
        case_(String.class, s -> assertThat(s, is(str))), //
        case_default(o -> fail()));

    Integer integer = 1;
    integer.match(//
        case_(Integer.class, i -> assertThat(i, is(integer))), //
        case_(String.class, s -> fail()), //
        case_default(o -> fail()));

    BigDecimal num = BigDecimal.ZERO;
    num.match(//
        case_(Integer.class, i -> fail()), //
        case_(String.class, s -> fail()), //
        case_default(o -> assertThat(o, is(num))));
  }
}
