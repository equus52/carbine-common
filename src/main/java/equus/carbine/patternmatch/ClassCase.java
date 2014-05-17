package equus.carbine.patternmatch;

import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class ClassCase<S, T extends S> implements CaseMatcher<S> {
  @Nonnull
  Class<T> matchClass;

  @Override
  public boolean match(@Nullable S subject) {
    return matchClass.isInstance(subject);
  }

  public CaseBlock<S> block(@Nonnull Consumer<T> consumer) {
    return new CaseBlock<S>() {

      @Override
      public boolean match(S subject) {
        return ClassCase.this.match(subject);
      }

      @SuppressWarnings("unchecked")
      @Override
      public void accept(S subject) {
        consumer.accept((T) subject);
      }
    };
  }

  public <R> CaseFunction<S, R> function(@Nonnull Function<T, R> function) {
    return new CaseFunction<S, R>() {

      @Override
      public boolean match(S subject) {
        return ClassCase.this.match(subject);
      }

      @SuppressWarnings("unchecked")
      @Override
      public R apply(S subject) {
        return function.apply((T) subject);
      }
    };
  }
}
