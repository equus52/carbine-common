package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import org.hamcrest.Matcher;

public class ClassMatcherCase<S, T extends S> extends ClassCase<S, T> {
  @Nonnull
  private final Matcher<T> matcher;

  public ClassMatcherCase(Class<T> matchClass, Matcher<T> matcher) {
    super(matchClass);
    this.matcher = matcher;
  }

  @Override
  public boolean match(@Nullable S subject) {
    if (!super.match(subject)) {
      return false;
    }
    return matcher.matches(convert(subject));
  }
}
