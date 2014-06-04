package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class ClassCase<S, T extends S> implements CaseMatcher<S>, CaseBlockable<S, T>, CaseFunctionable<S, T> {
  @Nonnull
  Class<T> matchClass;

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
