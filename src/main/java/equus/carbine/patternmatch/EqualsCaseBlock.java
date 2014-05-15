package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

@Value
public class EqualsCaseBlock<S> implements CaseBlock<S> {

  S matchValue;

  Consumer<S> consumer;

  @Override
  public boolean matchAndAccept(S subject) {
    if (!matchValue.equals(subject)) {
      return false;
    }
    consumer.accept(subject);
    return true;
  }

}
