package equus.carbine.patternmatch;

import java.util.function.Supplier;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class NullCase<S> implements CaseMatcher<S> {

  @Override
  public boolean match(@Nullable S subject) {
    return subject == null;
  }

  public CaseBlock<S> block(@Nonnull Block block) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return NullCase.this.match(subject);
      }

      @Override
      public void accept(S subject) {
        block.apply();
      }
    };
  }

  public <R> CaseFunction<S, R> function(@Nonnull Supplier<R> supplier) {
    return new CaseFunction<S, R>() {

      @Override
      public boolean match(S subject) {
        return NullCase.this.match(subject);
      }

      @Override
      public R apply(S subject) {
        return supplier.get();
      }
    };
  }

}
