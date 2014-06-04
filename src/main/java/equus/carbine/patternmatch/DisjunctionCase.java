package equus.carbine.patternmatch;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class DisjunctionCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {
  @Nonnull
  List<S> matchValues;

  @Override
  public boolean match(@Nullable S subject) {
    for (S matchValue : matchValues) {
      if (matchValue.equals(subject)) {
        return true;
      }
    }
    return false;
  }

}
