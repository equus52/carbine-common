package equus.carbine.patternmatch;

import java.util.Optional;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;
import lombok.val;
import equus.carbine.patternmatch.CaseFunction.Result;

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

  @SafeVarargs
  public final <R> Optional<R> matches(@Nonnull CaseFunction<S, R>... caseFunctions) {
    for (val caseFunction : caseFunctions) {
      Result<R> result = caseFunction.matchAndApply(subject);
      if (result.isMatch()) {
        return Optional.ofNullable(result.getReturnValue());
      }
    }
    return Optional.empty();
  }
}
