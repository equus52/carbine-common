package equus.carbine.patternmatch;

import static equus.carbine.patternmatch.PatternMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;

import org.junit.Test;

public class PatternMatchersTest {

  @Test
  public void match_case_value() {

    BigDecimal num = BigDecimal.ZERO;
    match(num, //
        caseValue(BigDecimal.ONE, o -> fail()), //
        caseValue(BigDecimal.ZERO, o -> assertThat(o, is(num))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_value_return() {

    BigDecimal num = BigDecimal.ZERO;
    Optional<Integer> result = match(num, //
        _caseValue(BigDecimal.ONE, (BigDecimal o) -> -1), //
        _caseValue(BigDecimal.ZERO, o -> 0), //
        _caseDefault(o -> -1));
    assertThat(result.get(), is(0));
  }

  @Test
  public void match_case_default() {

    BigDecimal num = BigDecimal.ZERO;
    match(num, //
        caseValue(BigDecimal.ONE, o -> fail()), //
        caseValue(BigDecimal.TEN, o -> fail()), //
        caseDefault(o -> assertThat(o, is(num))));
  }

  @Test
  public void match_case_default_return() {

    BigDecimal num = BigDecimal.ZERO;
    Optional<Integer> result = match(num, //
        _caseValue(BigDecimal.ONE, o -> -1), //
        _caseValue(BigDecimal.TEN, o -> -1), //
        _caseDefault(o -> null));
    assertThat(result.isPresent(), is(false));
  }

  @Test
  public void match_case_class() {
    Number integer = 1;
    match(integer,//
        caseClass(Integer.class, (Integer i) -> assertThat(i, is(integer))), //
        caseClass(Double.class, (Double s) -> fail()), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_class_return() {
    Number integer = 1;
    Optional<String> result = match(integer,//
        _caseClass(Integer.class, (Integer i) -> "OK"), //
        _caseClass(Double.class, (Double s) -> "NG"), //
        _caseDefault(o -> "NG"));
    assertThat(result.get(), is("OK"));
  }

  @Test
  public void match_case_null() {
    String str = null;
    match(str, //
        caseClass(String.class, (String s) -> fail()), //
        caseNull(() -> assertThat(str, is((String) null))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_null_return() {
    String str = null;
    Optional<Integer> result = match(str, //
        _caseClass(String.class, (String s) -> -1), //
        _caseNull(() -> 0), //
        _caseDefault(o -> -1));
    assertThat(result.get(), is(0));
  }

  @Test
  public void match_case_not_null() {
    String str = "test";
    match(str, //
        caseNull(() -> fail()), //
        caseNotNull((String s) -> assertThat(s, is(str))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_not_null_return() {
    String str = "test";
    Optional<Integer> result = match(str, //
        _caseNull(() -> -1), //
        _caseNotNull((String s) -> 0), //
        _caseDefault(o -> -1));
    assertThat(result.get(), is(0));
  }

  @Test
  public void match_case_boolean() {
    {
      String str = "test";
      match(str, //
          caseBool(s -> s.equals("test2"), (String s) -> fail()), //
          caseBool(s -> s.startsWith("te"), (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = null;
      match(str, //
          caseBool(s -> s != null, (String s) -> fail()), //
          caseBool(s -> s == null, (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_boolean_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseBoolean(s -> s.equals("test2"), (String s) -> -1), //
          _caseBoolean(s -> s.startsWith("te"), (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = null;
      Optional<Integer> result = match(str, //
          _caseBoolean(s -> s != null, (String s) -> -1), //
          _caseBoolean(s -> s == null, (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_case_matcher() {
    {
      String str = "test";
      match(str, //
          caseMatcher(is("test2"), (String s) -> fail()), //
          caseMatcher(startsWith("te"), (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = null;
      match(str, //
          caseMatcher(is("test2"), (String s) -> fail()), //
          caseMatcher(is((String) null), (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_matcher_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseMatcher(is("test2"), (String s) -> -1), //
          _caseMatcher(startsWith("te"), (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = null;
      Optional<Integer> result = match(str, //
          _caseMatcher(is("test2"), (String s) -> -1), //
          _caseMatcher(is((String) null), (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_case_disjunction() {
    {
      String str = "test";
      match(str, //
          caseValues("test1", "test2", (String s) -> fail()), //
          caseValues("test1", "test", (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          caseValues("test1", "test2", (String s) -> fail()), //
          caseValues("test", "test2", (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          caseValues("test1", "test2", "test3", (String s) -> fail()), //
          caseValues("test1", "test2", "test", (String s) -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_disjunction_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseValues("test1", "test2", (String s) -> -1), //
          _caseValues("test1", "test", (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseValues("test1", "test2", (String s) -> -1), //
          _caseValues("test", "test2", (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseValues("test1", "test2", "test3", (String s) -> -1), //
          _caseValues("test1", "test2", "test", (String s) -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_option() {
    String str = "test";
    Optional<String> opt = Optional.ofNullable(str);
    match(opt, //
        caseSome(s -> assertThat(s, is(str))), //
        caseNone(() -> fail()));

    Optional<String> empty = Optional.empty();
    match(empty, //
        caseSome((String s) -> fail()), //
        caseNone(() -> assertThat(empty.isPresent(), is(false))));
  }

  @Test
  public void match_option_return() {
    String str = "test";
    Optional<String> opt = Optional.ofNullable(str);
    int result1 = match(opt, //
        _caseSome(s -> 0), //
        _caseNone(() -> -1));
    assertThat(result1, is(0));

    Optional<String> empty = Optional.empty();
    int result2 = match(empty, //
        _caseSome(s -> 0), //
        _caseNone(() -> -1));
    assertThat(result2, is(-1));
  }
}
