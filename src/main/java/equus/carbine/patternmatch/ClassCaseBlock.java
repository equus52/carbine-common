package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class ClassCaseBlock<T> implements CaseBlock<Object> {

  Class<T> matchClass;
  Consumer<T> consumer;

  @SuppressWarnings("unchecked")
  @Override
  public boolean matchAndAccept(Object subject) {
    if (!matchClass.isInstance(subject)) {
      return false;
    }
    consumer.accept((T) subject);
    return true;
  }

}
