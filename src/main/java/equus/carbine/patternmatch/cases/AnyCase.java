package equus.carbine.patternmatch.cases;

import equus.carbine.patternmatch.NoConvertCase;

public class AnyCase<S> implements NoConvertCase<S> {

  public AnyCase() {}

  public AnyCase(Class<S> clazz) {}

  @Override
  public boolean match(S subject) {
    return true;
  }
}
