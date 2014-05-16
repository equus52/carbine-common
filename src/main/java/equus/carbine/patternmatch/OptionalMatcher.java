package equus.carbine.patternmatch;

import java.util.Optional;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class OptionalMatcher<T> {

  @Nonnull
  Optional<T> subject;

  public final void matches(@Nonnull SomeCaseBlock<T> someCaseBlock, NoneCaseBlock noneCaseBlock) {
    if (someCaseBlock.matchAndAccept(subject)) {
      return;
    }
    noneCaseBlock.matchAndAccept(subject);
  }
}
