package equus.carbine.patternmatch;

import static equus.carbine.patternmatch.PatternMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.junit.Test;

public class PatternMatchersTest {

  @Test
  public void match_case_class() {
    String str = "test";
    match(str,//
        // case_(Integer.class, (Integer i) -> fail()), // compile error! type safe
        case_(String.class, (String s) -> assertThat(s, is(str))), //
        case_default(o -> fail()));

    Number integer = 1;
    match(integer,//
        case_(Integer.class, (Integer i) -> assertThat(i, is(integer))), //
        case_(Double.class, (Double s) -> fail()), //
        case_default(o -> fail()));

  }

  @Test
  public void match_case_default() {

    BigDecimal num = BigDecimal.ZERO;
    match(num, //
        case_(BigDecimal.ONE, o -> fail()), //
        case_(BigDecimal.TEN, o -> fail()), //
        case_default(o -> assertThat(o, is(num))));
  }

  @Test
  public void match_case_value() {

    BigDecimal num = BigDecimal.ZERO;
    match(num, //
        case_(BigDecimal.ONE, o -> fail()), //
        case_(BigDecimal.ZERO, o -> assertThat(o, is(num))), //
        case_default(o -> fail()));
  }

  @Test
  public void match_case_matcher() {

    String str = "test";
    match(str, //
        case_(is("test2"), (String s) -> fail()), //
        case_(startsWith("te"), (String s) -> assertThat(s, is(str))), //
        case_default(o -> fail()));
  }
}
