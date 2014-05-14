package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class ClassCaseBlock<T> implements CaseBlock<Object> {

  Class<T> clazz;
  Consumer<T> consumer;

  @SuppressWarnings("unchecked")
  @Override
  public boolean matchAndAccept(Object obj) {
    if (!clazz.isInstance(obj)) {
      return false;
    }
    consumer.accept((T) obj);
    return true;
  }

}
