package equus.carbine.patternmatch;

import java.util.function.Predicate;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ClassPredicateCase<S, T extends S> extends ClassCase<S, T> {
  @Nonnull
  private final Predicate<T> predicate;

  public ClassPredicateCase(Class<T> matchClass, Predicate<T> predicate) {
    super(matchClass);
    this.predicate = predicate;
  }

  @Override
  public boolean match(@Nullable S subject) {
    if (!super.match(subject)) {
      return false;
    }
    return predicate.test(convert(subject));
  }
}
