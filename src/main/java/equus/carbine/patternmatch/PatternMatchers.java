package equus.carbine.patternmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.Matcher;

import equus.carbine.patternmatch.NoneCase.NoneCaseBlock;
import equus.carbine.patternmatch.NoneCase.NoneCaseFunction;
import equus.carbine.patternmatch.SomeCase.SomeCaseBlock;
import equus.carbine.patternmatch.SomeCase.SomeCaseFunction;

public final class PatternMatchers {

  private PatternMatchers() {}

  public static <S> PatternMatcher<S> subject(@Nullable S subject) {
    return new PatternMatcher<>(subject);
  }

  @SafeVarargs
  public static <S> void match(@Nullable S subject, @Nonnull CaseBlock<S>... caseBlocks) {
    subject(subject).matches(caseBlocks);
  }

  @SafeVarargs
  public static <S, R> Optional<R> match(@Nullable S subject, @Nonnull CaseFunction<S, R>... caseFunctions) {
    return subject(subject).matches(caseFunctions);
  }

  public static <S> CaseBlock<S> case_(@Nonnull S matchValue, @Nonnull Consumer<S> consumer) {
    return new EqualsCase<>(matchValue).block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _case_(@Nonnull S matchValue, @Nonnull Function<S, R> function) {
    return new EqualsCase<>(matchValue).function(function);
  }

  public static <S> CaseBlock<S> case_default(@Nonnull Consumer<S> consumer) {
    return new DefaltCase<S>().block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _case_default(@Nonnull Function<S, R> function) {
    return new DefaltCase<S>().function(function);
  }

  public static <S, T extends S> CaseBlock<S> case_(@Nonnull Class<T> matchClass, @Nonnull Consumer<T> consumer) {
    return new ClassCase<S, T>(matchClass).block(consumer);
  }

  public static <S, T extends S, R> CaseFunction<S, R> _case_(@Nonnull Class<T> matchClass,
      @Nonnull Function<T, R> function) {
    return new ClassCase<S, T>(matchClass).function(function);
  }

  public static <S> CaseBlock<S> case_null(@Nonnull Block block) {
    return new NullCaseBlock<>(block);
  }

  public static <S> CaseBlock<S> case_(@Nonnull Matcher<S> matcher, @Nonnull Consumer<S> consumer) {
    return new MatcherCaseBlock<>(matcher, consumer);
  }

  public static <S> CaseBlock<S> case_(@Nonnull S matchValue1, @Nonnull S matchValue2, @Nonnull Consumer<S> consumer) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    return new DisjunctionCaseBlock<>(matchValues, consumer);
  }

  public static <S> CaseBlock<S> case_(@Nonnull S matchValue1, @Nonnull S matchValue2, @Nonnull S matchValue3,
      @Nonnull Consumer<S> consumer) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    matchValues.add(matchValue3);
    return new DisjunctionCaseBlock<>(matchValues, consumer);
  }

  public static <T> OptionalMatcher<T> subject(@Nonnull Optional<T> subject) {
    return new OptionalMatcher<>(subject);
  }

  public static <T> void match(@Nonnull Optional<T> subject, @Nonnull SomeCaseBlock<T> someCaseBlock,
      @Nonnull NoneCaseBlock noneCaseBlock) {
    subject(subject).matches(someCaseBlock, noneCaseBlock);
  }

  public static <T, R> R match(@Nonnull Optional<T> subject, @Nonnull SomeCaseFunction<T, R> someCaseFunction,
      @Nonnull NoneCaseFunction<R> noneCaseFunction) {
    return subject(subject).matches(someCaseFunction, noneCaseFunction);
  }

  public static <T> SomeCaseBlock<T> case_Some(@Nonnull Consumer<T> consumer) {
    return new SomeCase<T>().block(consumer);
  }

  public static <T, R> SomeCaseFunction<T, R> _case_Some(@Nonnull Function<T, R> function) {
    return new SomeCase<T>().function(function);
  }

  public static NoneCaseBlock case_None(@Nonnull Block block) {
    return new NoneCase().block(block);
  }

  public static <R> NoneCaseFunction<R> _case_None(@Nonnull Supplier<R> supplier) {
    return new NoneCase().function(supplier);
  }

}
