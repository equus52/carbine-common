package equus.carbine.patternmatch.cases;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.GeneralCaseBlockFunctionable;
import lombok.Value;

@Value
public class EqualsCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {
  @Nonnull
  S matchValue;

  @Override
  public boolean match(@Nullable S subject) {
    return matchValue.equals(subject);
  }

}
