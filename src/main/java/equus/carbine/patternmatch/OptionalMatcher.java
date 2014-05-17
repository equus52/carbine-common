package equus.carbine.patternmatch;

import java.util.Optional;

import javax.annotation.Nonnull;

import lombok.Value;
import equus.carbine.patternmatch.NoneCase.NoneCaseBlock;
import equus.carbine.patternmatch.NoneCase.NoneCaseFunction;
import equus.carbine.patternmatch.SomeCase.SomeCaseBlock;
import equus.carbine.patternmatch.SomeCase.SomeCaseFunction;

@Value
public class OptionalMatcher<T> {

  @Nonnull
  Optional<T> subject;

  public void matches(@Nonnull SomeCaseBlock<T> someCaseBlock, NoneCaseBlock noneCaseBlock) {
    if (someCaseBlock.match(subject)) {
      someCaseBlock.accept(subject);
      return;
    }
    noneCaseBlock.accept(subject);
  }

  public <R> R matches(@Nonnull SomeCaseFunction<T, R> someCaseFunction, @Nonnull NoneCaseFunction<R> noneCaseFunction) {
    if (someCaseFunction.match(subject)) {
      return someCaseFunction.apply(subject);
    }
    return noneCaseFunction.apply(subject);
  }
}
