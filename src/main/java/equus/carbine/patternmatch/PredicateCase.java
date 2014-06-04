package equus.carbine.patternmatch;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class PredicateCase<S> implements CaseMatcher<S> {
  @Nonnull
  Predicate<S> predicate;

  @Override
  public boolean match(@Nullable S subject) {
    return predicate.test(subject);
  }

  public CaseBlock<S> block(@Nonnull Consumer<S> consumer) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return PredicateCase.this.match(subject);
      }

      @Override
      public void accept(S subject) {
        consumer.accept(subject);
      }
    };
  }

  public <R> CaseFunction<S, R> function(@Nonnull Function<S, R> function) {
    return new CaseFunction<S, R>() {

      @Override
      public boolean match(S subject) {
        return PredicateCase.this.match(subject);
      }

      @Override
      public R apply(S subject) {
        return function.apply(subject);
      }
    };
  }

}
