package equus.carbine.patternmatch;

import javax.annotation.Nullable;

public interface CaseBlock<S> {

  boolean matchAndAccept(@Nullable S subject);
}
