package equus.carbine.patternmatch.cases;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.GeneralCaseBlockFunctionable;
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
