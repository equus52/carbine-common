package equus.carbine.patternmatch;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class EqualsCaseBlock<S> implements CaseBlock<S> {
  @Nonnull
  S matchValue;
  @Nonnull
  Consumer<S> consumer;

  @Override
  public boolean matchAndAccept(@Nullable S subject) {
    if (matchValue.equals(subject)) {
      consumer.accept(subject);
      return true;
    }
    return false;
  }

}
