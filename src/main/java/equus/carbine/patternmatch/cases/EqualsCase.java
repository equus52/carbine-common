package equus.carbine.patternmatch.cases;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import equus.carbine.patternmatch.NoConvertCase;

@Value
public class EqualsCase<S> implements NoConvertCase<S> {
  @Nonnull
  S matchValue;

  @Override
  public boolean match(@Nullable S subject) {
    return matchValue.equals(subject);
  }

}
