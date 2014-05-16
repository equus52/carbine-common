package equus.carbine.patternmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.Matcher;

public final class PatternMatchers {

  private PatternMatchers() {}

  public static <S> PatternMatcher<S> subject(@Nullable S subject) {
    return new PatternMatcher<S>(subject);
  }

  @SafeVarargs
  public static <S> void match(@Nullable S subject, @Nonnull CaseBlock<S>... caseBlocks) {
    subject(subject).matches(caseBlocks);
  }

  public static <S> CaseBlock<S> case_default(@Nonnull Consumer<S> consumer) {
    return new DefaltCaseBlock<>(consumer);
  }

  public static <S> CaseBlock<S> case_(@Nonnull S matchValue, @Nonnull Consumer<S> consumer) {
    return new EqualsCaseBlock<S>(matchValue, consumer);
  }

  public static <S> CaseBlock<S> case_null(@Nonnull Block block) {
    return new NullCaseBlock<S>(block);
  }

  public static <S, T extends S> CaseBlock<S> case_(@Nonnull Class<T> matchClass, @Nonnull Consumer<T> consumer) {
    return new ClassCaseBlock<S, T>(matchClass, consumer);
  }

  public static <S> CaseBlock<S> case_(@Nonnull Matcher<S> matcher, @Nonnull Consumer<S> consumer) {
    return new MatcherCaseBlock<S>(matcher, consumer);
  }

  public static <S> CaseBlock<S> case_(@Nonnull S matchValue1, @Nonnull S matchValue2, @Nonnull Consumer<S> consumer) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    return new DisjunctionCaseBlock<S>(matchValues, consumer);
  }

  public static <S> CaseBlock<S> case_(@Nonnull S matchValue1, @Nonnull S matchValue2, @Nonnull S matchValue3,
      @Nonnull Consumer<S> consumer) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    matchValues.add(matchValue3);
    return new DisjunctionCaseBlock<S>(matchValues, consumer);
  }

  public static <T> OptionalMatcher<T> subject(@Nonnull Optional<T> subject) {
    return new OptionalMatcher<T>(subject);
  }

  public static <T> void match(@Nonnull Optional<T> subject, @Nonnull SomeCaseBlock<T> someCaseBlock,
      NoneCaseBlock noneCaseBlock) {
    subject(subject).matches(someCaseBlock, noneCaseBlock);
  }

  public static <T> SomeCaseBlock<T> case_Some(@Nonnull Consumer<T> consumer) {
    return new SomeCaseBlock<>(consumer);
  }

  public static NoneCaseBlock case_None(@Nonnull Block block) {
    return new NoneCaseBlock(block);
  }
}
