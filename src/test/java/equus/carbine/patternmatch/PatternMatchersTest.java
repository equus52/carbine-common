package equus.carbine.patternmatch;

import static equus.carbine.patternmatch.PatternMatchers.*;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;

public class PatternMatchersTest {

  @Test
  public void match_case_value() {

    BigDecimal num = BigDecimal.ZERO;
    match(num, //
        case_(BigDecimal.ONE, o -> fail()), //
        case_(BigDecimal.ZERO, o -> assertThat(o, is(num))), //
        case_default(o -> fail()));
  }

  @Test
  public void match_case_value_return() {

    BigDecimal num = BigDecimal.ZERO;
    Optional<Integer> result = match(num, //
        _case_(BigDecimal.ONE, (BigDecimal o) -> -1), //
        _case_(BigDecimal.ZERO, o -> 0), //
        _case_default(o -> -1));
    assertThat(result.get(), is(0));
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
  public void match_case_default_return() {

    BigDecimal num = BigDecimal.ZERO;
    Optional<Integer> result = match(num, //
        _case_(BigDecimal.ONE, o -> -1), //
        _case_(BigDecimal.TEN, o -> -1), //
        _case_default(o -> null));
    assertThat(result.isPresent(), is(false));
  }

  @Test
  public void match_case_class() {
    Number integer = 1;
    match(integer,//
        case_(Integer.class, (Integer i) -> assertThat(i, is(integer))), //
        case_(Double.class, (Double s) -> fail()), //
        case_default(o -> fail()));
  }

  @Test
  public void match_case_class_return() {
    Number integer = 1;
    Optional<String> result = match(integer,//
        _case_(Integer.class, (Integer i) -> "OK"), //
        _case_(Double.class, (Double s) -> "NG"), //
        _case_default(o -> "NG"));
    assertThat(result.get(), is("OK"));
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
  public void match_case_null_return() {
    String str = null;
    Optional<Integer> result = match(str, //
        _case_(String.class, (String s) -> -1), //
        _case_null(() -> 0), //
        _case_default(o -> -1));
    assertThat(result.get(), is(0));
  }

  @Test
  public void match_case_not_null() {
    String str = "test";
    match(str, //
        case_null(() -> fail()), //
        case_not_null((String s) -> assertThat(s, is(str))), //
        case_default(o -> fail()));
  }

  @Test
  public void match_case_not_null_return() {
    String str = "test";
    Optional<Integer> result = match(str, //
        _case_null(() -> -1), //
        _case_not_null((String s) -> 0), //
        _case_default(o -> -1));
    assertThat(result.get(), is(0));
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
  public void match_case_matcher_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _case_(is("test2"), (String s) -> -1), //
          _case_(startsWith("te"), (String s) -> 0), //
          _case_default(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = null;
      Optional<Integer> result = match(str, //
          _case_(is("test2"), (String s) -> -1), //
          _case_(is((String) null), (String s) -> 0), //
          _case_default(o -> -1));
      assertThat(result.get(), is(0));
    }
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
  public void match_case_disjunction_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _case_("test1", "test2", (String s) -> -1), //
          _case_("test1", "test", (String s) -> 0), //
          _case_default(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _case_("test1", "test2", (String s) -> -1), //
          _case_("test", "test2", (String s) -> 0), //
          _case_default(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _case_("test1", "test2", "test3", (String s) -> -1), //
          _case_("test1", "test2", "test", (String s) -> 0), //
          _case_default(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_option() {
    String str = "test";
    Optional<String> opt = Optional.ofNullable(str);
    match(opt, //
        case_Some(s -> assertThat(s, is(str))), //
        case_None(() -> fail()));

    Optional<String> empty = Optional.empty();
    match(empty, //
        case_Some((String s) -> fail()), //
        case_None(() -> assertThat(empty.isPresent(), is(false))));
  }

  @Test
  public void match_option_return() {
    String str = "test";
    Optional<String> opt = Optional.ofNullable(str);
    int result1 = match(opt, //
        _case_Some(s -> 0), //
        _case_None(() -> -1));
    assertThat(result1, is(0));

    Optional<String> empty = Optional.empty();
    int result2 = match(empty, //
        _case_Some(s -> 0), //
        _case_None(() -> -1));
    assertThat(result2, is(-1));
  }
}
