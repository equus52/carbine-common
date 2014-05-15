package equus.carbine.patternmatch;

import java.util.function.Consumer;

import org.hamcrest.Matcher;

public final class PatternMatchers {

  private PatternMatchers() {}

  public static <S> PatternMatcher<S> subject(S subject) {
    return new PatternMatcher<S>(subject);
  }

  @Deprecated
  @SafeVarargs
  public static <S> void match(S subject, CaseBlock<S>... caseBlocks) {
    new PatternMatcher<S>(subject).matches(caseBlocks);
  }

  public static <S> CaseBlock<S> case_default(Consumer<S> consumer) {
    return new DefaltCaseBlock<>(consumer);
  }

  public static <S> CaseBlock<S> case_(S matchValue, Consumer<S> consumer) {
    return new EqualsCaseBlock<S>(matchValue, consumer);
  }

  public static <S, T extends S> CaseBlock<S> case_(Class<T> matchClass, Consumer<T> consumer) {
    return new ClassCaseBlock<S, T>(matchClass, consumer);
  }

  public static <S> CaseBlock<S> case_(Matcher<S> matcher, Consumer<S> consumer) {
    return new MatcherCaseBlock<S>(matcher, consumer);
  }

}
