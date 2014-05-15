package equus.carbine.patternmatch;

import java.util.function.Consumer;

import lombok.Value;

import org.hamcrest.Matcher;

@Value
public class MatcherCaseBlock<S> implements CaseBlock<S> {

  Matcher<S> matcher;
  Consumer<S> consumer;

  @Override
  public boolean matchAndAccept(S subject) {
    if (!matcher.matches(subject)) {
      return false;
    }
    consumer.accept(subject);
    return true;
  }

}
