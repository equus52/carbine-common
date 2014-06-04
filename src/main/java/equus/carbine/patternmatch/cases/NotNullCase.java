package equus.carbine.patternmatch.cases;

import javax.annotation.Nullable;

import equus.carbine.patternmatch.CaseMatcher;
import equus.carbine.patternmatch.GeneralCaseBlockFunctionable;
import lombok.Value;

@Value
public class NotNullCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {

  @Override
  public boolean match(@Nullable S subject) {
    return subject != null;
  }

}
