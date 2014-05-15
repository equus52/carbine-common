package equus.carbine.patternmatch;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class ClassCaseBlock<S, T extends S> implements CaseBlock<S> {
  @Nonnull
  Class<T> matchClass;
  @Nonnull
  Consumer<T> consumer;

  @SuppressWarnings("unchecked")
  @Override
  public boolean matchAndAccept(@Nullable S subject) {
    if (matchClass.isInstance(subject)) {
      consumer.accept((T) subject);
      return true;
    }
    return false;
  }

}
