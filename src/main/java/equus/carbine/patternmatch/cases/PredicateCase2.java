package equus.carbine.patternmatch.cases;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import equus.carbine.patternmatch.CaseBlock2;
import equus.carbine.patternmatch.CaseFunction2;
import equus.carbine.patternmatch.CaseMatcher2;

@Value
public class PredicateCase2<S1, S2> implements CaseMatcher2<S1, S2> {
  @Nonnull
  Predicate<S1> predicate1;
  @Nonnull
  Predicate<S2> predicate2;

  @Override
  public boolean match(@Nullable S1 subject1, @Nullable S2 subject2) {
    return predicate1.test(subject1) && predicate2.test(subject2);
  }

  public CaseBlock2<S1, S2> block(@Nonnull BiConsumer<S1, S2> consumer) {
    return new CaseBlock2<S1, S2>() {

      @Override
      public boolean match(S1 subject1, S2 subject2) {
        return PredicateCase2.this.match(subject1, subject2);
      }

      @Override
      public void accept(S1 subject1, S2 subject2) {
        consumer.accept(subject1, subject2);
      }

    };
  }

  public <R> CaseFunction2<S1, S2, R> function(@Nonnull BiFunction<S1, S2, R> function) {
    return new CaseFunction2<S1, S2, R>() {

      @Override
      public boolean match(S1 subject1, S2 subject2) {
        return PredicateCase2.this.match(subject1, subject2);
      }

      @Override
      public R apply(S1 subject1, S2 subject2) {
        return function.apply(subject1, subject2);
      }
    };
  }
}
