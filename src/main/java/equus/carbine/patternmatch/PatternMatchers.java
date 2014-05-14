package equus.carbine.patternmatch;

import java.util.function.Consumer;

public final class PatternMatchers {

  private PatternMatchers() {}

  public static <T> void match(T obj, CaseBlock<T>... caseBlocks) {
    new PatternMatcher(obj).match(caseBlocks);
  }

  public static <T> CaseBlock<Object> case_(Class<T> clazz, Consumer<T> consumer) {
    return new ClassCaseBlock<>(clazz, consumer);
  }

  public static <T> CaseBlock<T> case_default(Consumer<T> consumer) {
    return new DefaltCaseBlock<>(consumer);
  }
}
