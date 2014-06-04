package equus.carbine.patternmatch;

import lombok.Value;

@Value
public class DefaltCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {

  @Override
  public boolean match(S subject) {
    return true;
  }
}
