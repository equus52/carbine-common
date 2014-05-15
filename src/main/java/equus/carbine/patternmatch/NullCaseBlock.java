package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class NullCaseBlock<S> implements CaseBlock<S> {
  @Nonnull
  Block block;

  @Override
  public boolean matchAndAccept(@Nullable S subject) {
    if (subject == null) {
      block.apply();
      return true;
    }
    return false;
  }

}
