package equus.carbine.patternmatch;

import lombok.Value;
import lombok.val;

@Value
public class PatternMatcher<S> {

  S subject;

  @SafeVarargs
  public final void matches(CaseBlock<S>... caseBlocks) {
    for (val caseBlock : caseBlocks) {
      if (caseBlock.matchAndAccept(subject)) {
        return;
      }
    }
  }
}
