package equus.carbine.patternmatch;

import javax.annotation.Nullable;

public interface CaseMatcher<S> {

  boolean match(@Nullable S subject);
}