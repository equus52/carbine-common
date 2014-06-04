package equus.carbine.patternmatch;

import javax.annotation.Nullable;

import lombok.Value;

@Value
public class NotNullCase<S> implements CaseMatcher<S>, GeneralCaseBlockFunctionable<S> {

  @Override
  public boolean match(@Nullable S subject) {
    return subject != null;
  }

}
