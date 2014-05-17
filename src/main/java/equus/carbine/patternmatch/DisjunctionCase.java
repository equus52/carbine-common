package equus.carbine.patternmatch;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class DisjunctionCase<S> implements CaseMatcher<S> {
  @Nonnull
  List<S> matchValues;

  @Override
  public boolean match(@Nullable S subject) {
    for (S matchValue : matchValues) {
      if (matchValue.equals(subject)) {
        return true;
      }
    }
    return false;
  }

  public CaseBlock<S> block(@Nonnull Consumer<S> consumer) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return DisjunctionCase.this.match(subject);
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
        return DisjunctionCase.this.match(subject);
      }

      @Override
      public R apply(S subject) {
        return function.apply(subject);
      }
    };
  }

}
