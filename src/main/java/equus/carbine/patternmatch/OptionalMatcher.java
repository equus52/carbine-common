package equus.carbine.patternmatch;

import java.util.Optional;

import javax.annotation.Nonnull;

import lombok.Value;
import equus.carbine.patternmatch.CaseFunction.Result;

@Value
public class OptionalMatcher<T> {

  @Nonnull
  Optional<T> subject;

  public void matches(@Nonnull SomeCaseBlock<T> someCaseBlock, NoneCaseBlock noneCaseBlock) {
    if (someCaseBlock.matchAndAccept(subject)) {
      return;
    }
    noneCaseBlock.matchAndAccept(subject);
  }

  public <R> R matches(@Nonnull SomeCaseFunction<T, R> someCaseFunction, @Nonnull NoneCaseFunction<R> noneCaseFunction) {
    Result<R> resultSome = someCaseFunction.matchAndApply(subject);
    if (resultSome.isMatch()) {
      return resultSome.getReturnValue();
    }
    return noneCaseFunction.matchAndApply(subject).getReturnValue();
  }
}
