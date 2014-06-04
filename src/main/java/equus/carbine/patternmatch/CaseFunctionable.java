package equus.carbine.patternmatch;

import java.util.function.Function;

import javax.annotation.Nonnull;

public interface CaseFunctionable<S, T> extends CaseMatcher<S> {
  default <R> CaseFunction<S, R> function(@Nonnull Function<T, R> function) {
    return new CaseFunction<S, R>() {

      @Override
      public boolean match(S subject) {
        return CaseFunctionable.this.match(subject);
      }

      @Override
      public R apply(S subject) {
        return function.apply(convert(subject));
      }
    };
  }

  T convert(S subject);
}
