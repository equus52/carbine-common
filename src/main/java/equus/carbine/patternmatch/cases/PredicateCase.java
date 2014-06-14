package equus.carbine.patternmatch.cases;

import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import equus.carbine.patternmatch.NoConvertCase;

@Value
public class PredicateCase<S> implements NoConvertCase<S> {
  @Nonnull
  Predicate<S> predicate;

  @Override
  public boolean match(@Nullable S subject) {
    return predicate.test(subject);
  }

}
