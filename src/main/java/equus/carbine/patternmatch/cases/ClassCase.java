package equus.carbine.patternmatch.cases;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import equus.carbine.patternmatch.CaseBlockable;
import equus.carbine.patternmatch.CaseFunctionable;
import equus.carbine.patternmatch.CaseMatcher;

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