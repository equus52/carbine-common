package equus.carbine.patternmatch;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class DefaltCase<S> implements CaseMatcher<S> {

  @Override
  public boolean match(S subject) {
    return true;
  }

  public CaseBlock<S> block(@Nonnull Consumer<S> consumer) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return DefaltCase.this.match(subject);
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
        return DefaltCase.this.match(subject);
      }

      @Override
      public R apply(S subject) {
        return function.apply(subject);
      }
    };
  }

}
