package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class DefaltCaseBlock<T> implements CaseBlock<T> {

  Consumer<T> consumer;

  @Override
  public boolean matchAndAccept(T subject) {
    consumer.accept(subject);
    return true;
  }

}
