package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
