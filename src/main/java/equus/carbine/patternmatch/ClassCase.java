package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class ClassCase<S, T extends S> implements CaseMatcher<S>, CaseBlockable<S, T>, CaseFunctionable<S, T> {
  @Nonnull
  private final Class<T> matchClass;

  public ClassCase(Class<T> matchClass) {
    this.matchClass = matchClass;
  }

  @Override
  public boolean match(@Nullable S subject) {
    return matchClass.isInstance(subject);
  }

  @SuppressWarnings("unchecked")
  @Override
  public T convert(S subject) {
    return (T) subject;
  }
}
