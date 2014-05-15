package equus.carbine.patternmatch;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class DefaltCaseBlock<S> implements CaseBlock<S> {
  @Nonnull
  Consumer<S> consumer;

  @Override
  public boolean matchAndAccept(@Nullable S subject) {
    consumer.accept(subject);
    return true;
  }

}
