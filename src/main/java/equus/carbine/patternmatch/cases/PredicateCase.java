package equus.carbine.patternmatch.cases;

import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.GeneralCaseBlockFunctionable;
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
