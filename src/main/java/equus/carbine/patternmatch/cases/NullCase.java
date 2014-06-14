package equus.carbine.patternmatch.cases;

import javax.annotation.Nullable;

import equus.carbine.patternmatch.NothingCase;

public class NullCase<S> implements NothingCase<S> {

  @Override
  public boolean match(@Nullable S subject) {
    return subject == null;
  }

}
