package equus.carbine.patternmatch;

import static equus.carbine.patternmatch.PatternMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

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
    subject(integer).matches(//
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
    {
      String str = "test";
      match(str, //
          case_(is("test2"), (String s) -> fail()), //
          case_(startsWith("te"), (String s) -> assertThat(s, is(str))), //
          case_default(o -> fail()));
    }
    {
      String str = null;
      match(str, //
          case_(is("test2"), (String s) -> fail()), //
          case_(is((String) null), (String s) -> assertThat(s, is(str))), //
          case_default(o -> fail()));
    }
  }

  @Test
  public void match_case_null() {
    String str = null;
    match(str, //
        case_(String.class, (String s) -> fail()), //
        case_null(() -> assertThat(str, is((String) null))), //
        case_default(o -> fail()));
  }

  @Test
  public void match_case_disjunction() {
    {
      String str = "test";
      match(str, //
          case_("test1", "test2", (String s) -> fail()), //
          case_("test1", "test", (String s) -> assertThat(s, is(str))), //
          case_default(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          case_("test1", "test2", (String s) -> fail()), //
          case_("test", "test2", (String s) -> assertThat(s, is(str))), //
          case_default(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          case_("test1", "test2", "test3", (String s) -> fail()), //
          case_("test1", "test2", "test", (String s) -> assertThat(s, is(str))), //
          case_default(o -> fail()));
    }
  }

  @Test
  public void match_option() {
    String str = "test";
    Optional<String> opt = Optional.ofNullable(str);
    match(opt, //
        case_Some((String s) -> assertThat(s, is(str))), //
        case_None(() -> fail()));

    Optional<String> empty = Optional.empty();
    match(empty, //
        case_Some((String s) -> fail()), //
        case_None(() -> assertThat(empty.isPresent(), is(false))));
  }
}
