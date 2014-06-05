package equus.carbine.patternmatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.Matcher;

import equus.carbine.patternmatch.cases.ClassCase;
import equus.carbine.patternmatch.cases.ClassMatcherCase;
import equus.carbine.patternmatch.cases.ClassPredicateCase;
import equus.carbine.patternmatch.cases.DefaltCase;
import equus.carbine.patternmatch.cases.DisjunctionCase;
import equus.carbine.patternmatch.cases.EqualsCase;
import equus.carbine.patternmatch.cases.MatcherCase;
import equus.carbine.patternmatch.cases.NoneCase;
import equus.carbine.patternmatch.cases.NoneCase.NoneCaseBlock;
import equus.carbine.patternmatch.cases.NoneCase.NoneCaseFunction;
import equus.carbine.patternmatch.cases.NotNullCase;
import equus.carbine.patternmatch.cases.NullCase;
import equus.carbine.patternmatch.cases.PredicateCase;
import equus.carbine.patternmatch.cases.PredicateCase2;
import equus.carbine.patternmatch.cases.RegexCase;
import equus.carbine.patternmatch.cases.SomeCase;
import equus.carbine.patternmatch.cases.SomeCase.SomeCaseBlock;
import equus.carbine.patternmatch.cases.SomeCase.SomeCaseFunction;

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

  public static <S> CaseBlock<S> caseValue(@Nonnull S matchValue, @Nonnull Consumer<S> consumer) {
    return new EqualsCase<>(matchValue).block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _caseValue(@Nonnull S matchValue, @Nonnull Function<S, R> function) {
    return new EqualsCase<>(matchValue).function(function);
  }

  public static <S> CaseBlock<S> caseDefault(@Nonnull Consumer<S> consumer) {
    return new DefaltCase<S>().block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _caseDefault(@Nonnull Function<S, R> function) {
    return new DefaltCase<S>().function(function);
  }

  public static <S> CaseBlock<S> caseNull(@Nonnull Block block) {
    return new NullCase<S>().block(block);
  }

  public static <S, R> CaseFunction<S, R> _caseNull(@Nonnull Supplier<R> supplier) {
    return new NullCase<S>().function(supplier);
  }

  public static <S> CaseBlock<S> caseNotNull(@Nonnull Consumer<S> consumer) {
    return new NotNullCase<S>().block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _caseNotNull(@Nonnull Function<S, R> function) {
    return new NotNullCase<S>().function(function);
  }

  public static <S> CaseBlock<S> caseBoolean(@Nonnull Predicate<S> predicate, @Nonnull Consumer<S> consumer) {
    return new PredicateCase<S>(predicate).block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _caseBoolean(@Nonnull Predicate<S> predicate, @Nonnull Function<S, R> function) {
    return new PredicateCase<S>(predicate).function(function);
  }

  public static <S> CaseBlock<S> caseMatcher(@Nonnull Matcher<S> matcher, @Nonnull Consumer<S> consumer) {
    return new MatcherCase<S>(matcher).block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _caseMatcher(@Nonnull Matcher<S> matcher, @Nonnull Function<S, R> function) {
    return new MatcherCase<S>(matcher).function(function);
  }

  public static <S, T extends S> CaseBlock<S> caseClass(@Nonnull Class<T> matchClass, @Nonnull Consumer<T> consumer) {
    return new ClassCase<S, T>(matchClass).block(consumer);
  }

  public static <S, T extends S, R> CaseFunction<S, R> _caseClass(@Nonnull Class<T> matchClass,
      @Nonnull Function<T, R> function) {
    return new ClassCase<S, T>(matchClass).function(function);
  }

  public static <S, T extends S> CaseBlock<S> caseClass(@Nonnull Class<T> matchClass, @Nonnull Predicate<T> predicate,
      @Nonnull Consumer<T> consumer) {
    return new ClassPredicateCase<S, T>(matchClass, predicate).block(consumer);
  }

  public static <S, T extends S, R> CaseFunction<S, R> _caseClass(@Nonnull Class<T> matchClass,
      @Nonnull Predicate<T> predicate, @Nonnull Function<T, R> function) {
    return new ClassPredicateCase<S, T>(matchClass, predicate).function(function);
  }

  public static <S, T extends S> CaseBlock<S> caseClass(@Nonnull Class<T> matchClass, @Nonnull Matcher<T> matcher,
      @Nonnull Consumer<T> consumer) {
    return new ClassMatcherCase<S, T>(matchClass, matcher).block(consumer);
  }

  public static <S, T extends S, R> CaseFunction<S, R> _caseClass(@Nonnull Class<T> matchClass,
      @Nonnull Matcher<T> matcher, @Nonnull Function<T, R> function) {
    return new ClassMatcherCase<S, T>(matchClass, matcher).function(function);
  }

  public static CaseBlock<String> caseRegex(@Nonnull Pattern pattern, @Nonnull Consumer<String> consumer) {
    return new RegexCase(pattern).block(consumer);
  }

  public static <R> CaseFunction<String, R> _caseRegex(@Nonnull Pattern pattern, @Nonnull Function<String, R> function) {
    return new RegexCase(pattern).function(function);
  }

  public static CaseBlock<String> caseRegex(@Nonnull String regex, @Nonnull Consumer<String> consumer) {
    return new RegexCase(Pattern.compile(regex)).block(consumer);
  }

  public static <R> CaseFunction<String, R> _caseRegex(@Nonnull String regex, @Nonnull Function<String, R> function) {
    return new RegexCase(Pattern.compile(regex)).function(function);
  }

  public static CaseBlock<String> caseRegex(@Nonnull String regex, int flags, @Nonnull Consumer<String> consumer) {
    return new RegexCase(Pattern.compile(regex, flags)).block(consumer);
  }

  public static <R> CaseFunction<String, R> _caseRegex(@Nonnull String regex, int flags,
      @Nonnull Function<String, R> function) {
    return new RegexCase(Pattern.compile(regex, flags)).function(function);
  }

  public static <S> CaseBlock<S> caseValues(@Nonnull S matchValue1, @Nonnull S matchValue2,
      @Nonnull Consumer<S> consumer) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    return new DisjunctionCase<S>(matchValues).block(consumer);
  }

  public static <S> CaseBlock<S> caseValues(@Nonnull S matchValue1, @Nonnull S matchValue2, @Nonnull S matchValue3,
      @Nonnull Consumer<S> consumer) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    matchValues.add(matchValue3);
    return new DisjunctionCase<S>(matchValues).block(consumer);
  }

  public static <S, R> CaseFunction<S, R> _caseValues(@Nonnull S matchValue1, @Nonnull S matchValue2,
      @Nonnull Function<S, R> function) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    return new DisjunctionCase<S>(matchValues).function(function);
  }

  public static <S, R> CaseFunction<S, R> _caseValues(@Nonnull S matchValue1, @Nonnull S matchValue2,
      @Nonnull S matchValue3, @Nonnull Function<S, R> function) {
    List<S> matchValues = new ArrayList<>();
    matchValues.add(matchValue1);
    matchValues.add(matchValue2);
    matchValues.add(matchValue3);
    return new DisjunctionCase<S>(matchValues).function(function);
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

  public static <T> SomeCaseBlock<T> caseSome(@Nonnull Consumer<T> consumer) {
    return new SomeCase<T>().block(consumer);
  }

  public static <T, R> SomeCaseFunction<T, R> _caseSome(@Nonnull Function<T, R> function) {
    return new SomeCase<T>().function(function);
  }

  public static NoneCaseBlock caseNone(@Nonnull Block block) {
    return new NoneCase().block(block);
  }

  public static <R> NoneCaseFunction<R> _caseNone(@Nonnull Supplier<R> supplier) {
    return new NoneCase().function(supplier);
  }

  public static <S1, S2> PatternMatcher2<S1, S2> subject(@Nullable S1 subject1, @Nullable S2 subject2) {
    return new PatternMatcher2<S1, S2>(subject1, subject2);
  }

  @SafeVarargs
  public static <S1, S2> void match(@Nullable S1 subject1, @Nullable S2 subject2,
      @Nonnull CaseBlock2<S1, S2>... caseBlocks) {
    subject(subject1, subject2).matches(caseBlocks);
  }

  @SafeVarargs
  public static <S1, S2, R> Optional<R> match(@Nullable S1 subject1, @Nullable S2 subject2,
      @Nonnull CaseFunction2<S1, S2, R>... caseFunctions) {
    return subject(subject1, subject2).matches(caseFunctions);
  }

  public static <S1, S2> CaseBlock2<S1, S2> caseBoolean(@Nonnull Predicate<S1> predicate1,
      @Nonnull Predicate<S2> predicate2, @Nonnull BiConsumer<S1, S2> consumer) {
    return new PredicateCase2<S1, S2>(predicate1, predicate2).block(consumer);
  }

  public static <S1, S2, R> CaseFunction2<S1, S2, R> _caseBoolean(@Nonnull Predicate<S1> predicate1,
      @Nonnull Predicate<S2> predicate2, @Nonnull BiFunction<S1, S2, R> function) {
    return new PredicateCase2<S1, S2>(predicate1, predicate2).function(function);
  }

  public static <S1, S2> CaseBlock2<S1, S2> caseDefault(@Nonnull BiConsumer<S1, S2> consumer) {
    return new PredicateCase2<S1, S2>(s -> true, s -> true).block(consumer);
  }
}
