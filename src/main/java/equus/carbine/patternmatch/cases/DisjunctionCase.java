package equus.carbine.patternmatch.cases;

import java.util.List;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import equus.carbine.patternmatch.NoConvertCase;

@Value
public class DisjunctionCase<S> implements NoConvertCase<S> {
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
