package equus.carbine.patternmatch.cases;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.GeneralCaseBlockFunctionable;
import lombok.Value;

@Value
public class DefaltCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {

  @Override
  public boolean match(S subject) {
    return true;
  }
}
