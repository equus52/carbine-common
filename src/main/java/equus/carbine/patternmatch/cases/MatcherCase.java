package equus.carbine.patternmatch.cases;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

import org.hamcrest.Matcher;

import equus.carbine.patternmatch.NoConvertCase;

@Value
public class MatcherCase<S> implements NoConvertCase<S> {
  @Nonnull
  Matcher<S> matcher;

  @Override
  public boolean match(@Nullable S subject) {
    return matcher.matches(subject);
  }

}
