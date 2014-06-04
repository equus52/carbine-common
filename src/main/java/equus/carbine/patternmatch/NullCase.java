package equus.carbine.patternmatch;

import javax.annotation.Nullable;

import lombok.Value;

@Value
public class NullCase<S> implements CaseMatcher<S>, NoArgCaseBlockable<S>, NoArgCaseFanctionable<S> {

  @Override
  public boolean match(@Nullable S subject) {
    return subject == null;
  }

}
