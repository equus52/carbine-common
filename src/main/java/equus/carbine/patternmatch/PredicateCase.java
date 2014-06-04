package equus.carbine.patternmatch;

import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class PredicateCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {
  @Nonnull
  Predicate<S> predicate;

  @Override
  public boolean match(@Nullable S subject) {
    return predicate.test(subject);
  }

}
