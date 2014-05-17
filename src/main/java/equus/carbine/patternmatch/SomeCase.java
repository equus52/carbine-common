package equus.carbine.patternmatch;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class SomeCase<T> implements CaseMatcher<Optional<T>> {

  @Override
  public boolean match(@Nonnull Optional<T> subject) {
    return subject.isPresent();
  }

  public static abstract class SomeCaseBlock<T1> implements CaseBlock<Optional<T1>> {}

  public SomeCaseBlock<T> block(@Nonnull Consumer<T> consumer) {
    return new SomeCaseBlock<T>() {

      @Override
      public boolean match(Optional<T> subject) {
        return SomeCase.this.match(subject);
      }

      @Override
      public void accept(Optional<T> subject) {
        consumer.accept(subject.get());
      }
    };
  }

  public static abstract class SomeCaseFunction<T1, R> implements CaseFunction<Optional<T1>, R> {}

  public <R> SomeCaseFunction<T, R> function(@Nonnull Function<T, R> function) {
    return new SomeCaseFunction<T, R>() {

      @Override
      public boolean match(Optional<T> subject) {
        return SomeCase.this.match(subject);
      }

      @Override
      public R apply(Optional<T> subject) {
        return function.apply(subject.get());
      }
    };
  }

}
