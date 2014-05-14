package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class DefaltCaseBlock<T> implements CaseBlock<T> {

  Consumer<T> consumer;

  @Override
  public boolean matchAndAccept(T obj) {
    consumer.accept(obj);
    return true;
  }

}
