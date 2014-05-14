package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class EqualsCaseBlock<T> implements CaseBlock<T> {

  T matchValue;

  Consumer<T> consumer;

  @Override
  public boolean matchAndAccept(T subject) {
    if (!matchValue.equals(subject)) {
      return false;
    }
    consumer.accept(subject);
    return true;
  }

}
