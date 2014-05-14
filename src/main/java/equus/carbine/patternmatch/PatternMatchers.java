package equus.carbine.patternmatch;

import java.util.function.Consumer;

public final class PatternMatchers {

  private PatternMatchers() {}

  public static <T> void match(T subject, CaseBlock<T>... caseBlocks) {
    new PatternMatcher(subject).match(caseBlocks);
  }

  public static <T> CaseBlock<T> case_default(Consumer<T> consumer) {
    return new DefaltCaseBlock<>(consumer);
  }

  public static <T> CaseBlock<Object> case_class(Class<T> matchClass, Consumer<T> consumer) {
    return case_(matchClass, consumer);
  }

  public static <T> CaseBlock<Object> case_(Class<T> matchClass, Consumer<T> consumer) {
    return new ClassCaseBlock<>(matchClass, consumer);
  }

  public static <T> CaseBlock<T> case_(T matchValue, Consumer<T> consumer) {
    return new EqualsCaseBlock(matchValue, consumer);
  }
}
