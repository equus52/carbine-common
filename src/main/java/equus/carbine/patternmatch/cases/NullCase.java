package equus.carbine.patternmatch.cases;

import javax.annotation.Nullable;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.NoArgCaseBlockable;
import equus.carbine.patternmatch.NoArgCaseFanctionable;
import lombok.Value;

@Value
public class NullCase<S> implements CaseMatcher<S>, NoArgCaseBlockable<S>, NoArgCaseFanctionable<S> {

  @Override
  public boolean match(@Nullable S subject) {
    return subject == null;
  }

}
