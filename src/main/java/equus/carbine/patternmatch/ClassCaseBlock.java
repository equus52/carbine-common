package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class ClassCaseBlock<S, T extends S> implements CaseBlock<S> {

  Class<T> matchClass;
  Consumer<T> consumer;

  @SuppressWarnings("unchecked")
  @Override
  public boolean matchAndAccept(S subject) {
    if (!matchClass.isInstance(subject)) {
      return false;
    }
    consumer.accept((T) subject);
    return true;
  }

}
