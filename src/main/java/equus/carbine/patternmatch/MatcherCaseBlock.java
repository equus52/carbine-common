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
  public boolean matchAndAccept(@Nullable S subject) {
    if (matcher.matches(subject)) {
      consumer.accept(subject);
      return true;
    }
    return false;
  }

}
