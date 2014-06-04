package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

import org.hamcrest.Matcher;

@Value
public class MatcherCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {
  @Nonnull
  Matcher<S> matcher;

  @Override
  public boolean match(@Nullable S subject) {
    return matcher.matches(subject);
  }

}
