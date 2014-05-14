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
  public void match_case_class() {
    String str = "test";
    str.match(//
        case_(Integer.class, (Integer i) -> fail()), //
        case_class(String.class, s -> assertThat(s, is(str))), //
        case_default(o -> fail()));

    Integer integer = 1;
    integer.match(//
        case_(Integer.class, (Integer i) -> assertThat(i, is(integer))), //
        case_(String.class, (String s) -> fail()), //
        case_default(o -> fail()));

  }

  @Test
  public void match_case_default() {

    BigDecimal num = BigDecimal.ZERO;
    num.match(//
        case_(Integer.class, (Integer i) -> fail()), //
        case_(String.class, (String s) -> fail()), //
        case_default(o -> assertThat(o, is(num))));
  }

  @Test
  public void match_case_value() {

    BigDecimal num = BigDecimal.ZERO;
    num.match(//
        case_(BigDecimal.ONE, o -> fail()), //
        case_(BigDecimal.ZERO, o -> assertThat(o, is(num))), //
        case_default(o -> fail()));
  }
}
