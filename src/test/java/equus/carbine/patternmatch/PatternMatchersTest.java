package equus.carbine.patternmatch;

import static equus.carbine.patternmatch.PatternMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.regex.Pattern;

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
        _caseValue(BigDecimal.ONE, o -> -1), //
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
        caseClass(Integer.class, i -> assertThat(i, is(integer))), //
        caseClass(Double.class, s -> fail()), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_class_return() {
    Number integer = 1;
    Optional<String> result = match(integer,//
        _caseClass(Integer.class, i -> "OK"), //
        _caseClass(Double.class, s -> "NG"), //
        _caseDefault(o -> "NG"));
    assertThat(result.get(), is("OK"));
  }

  @Test
  public void match_case_class_boolean() {
    Number integer = 1;
    match(integer,//
        caseClass(Integer.class, i -> i == 0, i -> assertThat(i, is(integer))), //
        caseClass(Double.class, i -> i > 0, i -> fail()), //
        caseClass(Integer.class, i -> i > 0, i -> assertThat(i, is(integer))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_class_boolean_return() {
    Number integer = 1;
    Optional<String> result = match(integer,//
        _caseClass(Integer.class, i -> i == 0, i -> "OK"), //
        _caseClass(Double.class, i -> i > 0, i -> "NG"), //
        _caseClass(Integer.class, i -> i > 0, i -> "OK"), //
        _caseDefault(o -> "NG"));
    assertThat(result.get(), is("OK"));
  }

  @Test
  public void match_case_class_matcher() {
    Number integer = 1;
    match(integer,//
        caseClass(Integer.class, is(0), i -> assertThat(i, is(integer))), //
        caseClass(Double.class, greaterThan(0.0), s -> fail()), //
        caseClass(Integer.class, greaterThan(0), i -> assertThat(i, is(integer))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_class_matcher_return() {
    Number integer = 1;
    Optional<String> result = match(integer,//
        _caseClass(Integer.class, is(0), i -> "OK"), //
        _caseClass(Double.class, greaterThan(0.0), i -> "NG"), //
        _caseClass(Integer.class, greaterThan(0), i -> "OK"), //
        _caseDefault(o -> "NG"));
    assertThat(result.get(), is("OK"));
  }

  @Test
  public void match_case_null() {
    String str = null;
    match(str, //
        caseClass(String.class, s -> fail()), //
        caseNull(() -> assertThat(str, is((String) null))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_null_return() {
    String str = null;
    Optional<Integer> result = match(str, //
        _caseClass(String.class, s -> -1), //
        _caseNull(() -> 0), //
        _caseDefault(o -> -1));
    assertThat(result.get(), is(0));
  }

  @Test
  public void match_case_not_null() {
    String str = "test";
    match(str, //
        caseNull(() -> fail()), //
        caseNotNull(s -> assertThat(s, is(str))), //
        caseDefault(o -> fail()));
  }

  @Test
  public void match_case_not_null_return() {
    String str = "test";
    Optional<Integer> result = match(str, //
        _caseNull(() -> -1), //
        _caseNotNull(s -> 0), //
        _caseDefault(o -> -1));
    assertThat(result.get(), is(0));
  }

  @Test
  public void match_case_boolean() {
    {
      int num = 5;
      match(num, //
          caseBoolean(i -> i > 5, i -> fail()), //
          caseBoolean(i -> i == 5, i -> assertThat(i, is(num))), //
          caseDefault(o -> fail()));
    }
    {
      String str = null;
      match(str, //
          caseBoolean(s -> s != null, s -> fail()), //
          caseBoolean(s -> s == null, s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_boolean_return() {
    {
      int num = 5;
      Optional<Integer> result = match(num, //
          _caseBoolean(i -> i > 5, i -> -1), //
          _caseBoolean(i -> i == 5, i -> i * 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = null;
      Optional<Integer> result = match(str, //
          _caseBoolean(s -> s != null, s -> -1), //
          _caseBoolean(s -> s == null, s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_case_matcher() {
    {
      String str = "test";
      match(str, //
          caseMatcher(is("test2"), s -> fail()), //
          caseMatcher(startsWith("te"), s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = null;
      match(str, //
          caseMatcher(is("test2"), s -> fail()), //
          caseMatcher(is((String) null), s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_matcher_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseMatcher(is("test2"), s -> -1), //
          _caseMatcher(startsWith("te"), s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = null;
      Optional<Integer> result = match(str, //
          _caseMatcher(is("test2"), s -> -1), //
          _caseMatcher(is((String) null), s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_case_regex() {
    {
      String str = "test";
      match(str, //
          caseRegex(Pattern.compile("^Te"), s -> fail()), //
          caseRegex(Pattern.compile("^te"), s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          caseRegex("^Te", s -> fail()), //
          caseRegex("^te", s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          caseRegex("^Te", Pattern.CASE_INSENSITIVE, s -> assertThat(s, is(str))), //
          caseRegex("^te", s -> fail()), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_regex_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseRegex(Pattern.compile("^Te"), s -> -1), //
          _caseRegex(Pattern.compile("^te"), s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseRegex("^Te", s -> -1), //
          _caseRegex("^te", s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseRegex("^Te", Pattern.CASE_INSENSITIVE, s -> 0), //
          _caseRegex("^te", s -> -1), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_case_disjunction() {
    {
      String str = "test";
      match(str, //
          caseValues("test1", "test2", s -> fail()), //
          caseValues("test1", "test", s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          caseValues("test1", "test2", s -> fail()), //
          caseValues("test", "test2", s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
    {
      String str = "test";
      match(str, //
          caseValues("test1", "test2", "test3", s -> fail()), //
          caseValues("test1", "test2", "test", s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_disjunction_return() {
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseValues("test1", "test2", s -> -1), //
          _caseValues("test1", "test", s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseValues("test1", "test2", s -> -1), //
          _caseValues("test", "test2", s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = "test";
      Optional<Integer> result = match(str, //
          _caseValues("test1", "test2", "test3", s -> -1), //
          _caseValues("test1", "test2", "test", s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

  @Test
  public void match_case_option() {
    String str = "test";
    Optional<String> opt = Optional.ofNullable(str);
    match(opt, //
        caseSome(s -> assertThat(s, is(str))), //
        caseNone(() -> fail()));

    Optional<String> empty = Optional.empty();
    match(empty, //
        caseSome(s -> fail()), //
        caseNone(() -> assertThat(empty.isPresent(), is(false))));
  }

  @Test
  public void match_case_option_return() {
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

  @Test
  public void match_case_boolean_2() {
    {
      int num1 = 5;
      int num2 = 9;
      // match(num1, num2, //
      // caseBoolean(i -> i > 5, i -> i > 5, (i1, i2) -> fail()), //
      // caseBoolean(i -> i == 5, i -> i == 9, (i1, i2) -> assertThat(i1, is(num1))), //
      // caseDefault((i1, i2) -> fail()));
    }
    {
      String str = null;
      match(str, //
          caseBoolean(s -> s != null, s -> fail()), //
          caseBoolean(s -> s == null, s -> assertThat(s, is(str))), //
          caseDefault(o -> fail()));
    }
  }

  @Test
  public void match_case_boolean_2_return() {
    {
      int num = 5;
      Optional<Integer> result = match(num, //
          _caseBoolean(i -> i > 5, i -> -1), //
          _caseBoolean(i -> i == 5, i -> i * 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
    {
      String str = null;
      Optional<Integer> result = match(str, //
          _caseBoolean(s -> s != null, s -> -1), //
          _caseBoolean(s -> s == null, s -> 0), //
          _caseDefault(o -> -1));
      assertThat(result.get(), is(0));
    }
  }

}
