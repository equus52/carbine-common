package equus.carbine.patternmatch;

import java.util.function.Supplier;

import javax.annotation.Nonnull;

public interface NoArgCaseFanctionable<S> extends CaseMatcher<S> {

  default <R> CaseFunction<S, R> function(@Nonnull Supplier<R> supplier) {
    return new CaseFunction<S, R>() {

      @Override
      public boolean match(S subject) {
        return NoArgCaseFanctionable.this.match(subject);
      }

      @Override
      public R apply(S subject) {
        return supplier.get();
      }
    };
  }
}