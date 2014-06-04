package equus.carbine.patternmatch.cases;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

import org.hamcrest.Matcher;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.GeneralCaseBlockFunctionable;

@Value
public class MatcherCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {
  @Nonnull
  Matcher<S> matcher;

  @Override
  public boolean match(@Nullable S subject) {
    return matcher.matches(subject);
  }

}
