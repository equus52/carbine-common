package equus.carbine.patternmatch;

import java.util.Optional;
import java.util.function.Consumer;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class SomeCaseBlock<T> implements CaseBlock<Optional<T>> {
  @Nonnull
  Consumer<T> consumer;

  @Override
  public boolean matchAndAccept(@Nonnull Optional<T> subject) {
    if (subject.isPresent()) {
      consumer.accept(subject.get());
      return true;
    }
    return false;
  }

}
