package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class DefaltCaseBlock<S> implements CaseBlock<S> {

  Consumer<S> consumer;

  @Override
  public boolean matchAndAccept(S subject) {
    consumer.accept(subject);
    return true;
  }

}
