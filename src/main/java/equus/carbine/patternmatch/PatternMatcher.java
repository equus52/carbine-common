package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import lombok.val;

@Value
public class PatternMatcher<S> {

  @Nullable
  S subject;

  @SafeVarargs
  public final void matches(@Nonnull CaseBlock<S>... caseBlocks) {
    for (val caseBlock : caseBlocks) {
      if (caseBlock.matchAndAccept(subject)) {
        return;
      }
    }
  }
}
