package equus.carbine.patternmatch;

import javax.annotation.Nullable;

public interface CaseMatcher2<S1, S2> {

  boolean match(@Nullable S1 subject1, @Nullable S2 subject2);
}