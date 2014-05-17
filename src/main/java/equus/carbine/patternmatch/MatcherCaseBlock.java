package equus.carbine.patternmatch;

import java.util.function.Consumer;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

import org.hamcrest.Matcher;

@Value
public class MatcherCaseBlock<S> implements CaseBlock<S> {
  @Nonnull
  Matcher<S> matcher;
  @Nonnull
  Consumer<S> consumer;

  @Override
  public boolean match(@Nullable S subject) {
    return matcher.matches(subject);
  }

  @Override
  public void accept(S subject) {
    consumer.accept(subject);
  }
}
