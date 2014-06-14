package equus.carbine.patternmatch.cases;

import javax.annotation.Nullable;

import equus.carbine.patternmatch.NoConvertCase;

public class NotNullCase<S> implements NoConvertCase<S> {

  public NotNullCase() {}

  public NotNullCase(Class<S> clazz) {}

  @Override
  public boolean match(@Nullable S subject) {
    return subject != null;
  }

}
