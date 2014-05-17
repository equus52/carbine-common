package equus.carbine.patternmatch;

import java.util.Optional;

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
      if (caseBlock.match(subject)) {
        caseBlock.accept(subject);
        return;
      }
    }
  }

  @SafeVarargs
  public final <R> Optional<R> matches(@Nonnull CaseFunction<S, R>... caseFunctions) {
    for (val caseFunction : caseFunctions) {
      if (caseFunction.match(subject)) {
        return Optional.ofNullable(caseFunction.apply(subject));
      }
    }
    return Optional.empty();
  }
}
