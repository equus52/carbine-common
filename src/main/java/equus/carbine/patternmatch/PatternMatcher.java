package equus.carbine.patternmatch;

import lombok.Value;
import lombok.val;

@Value
public class PatternMatcher<T> {

  T obj;

  public void match(CaseBlock<T>... caseBlocks) {
    for (val caseBlock : caseBlocks) {
      if (caseBlock.matchAndAccept(obj)) {
        return;
      }
    }
  }
}
