package equus.carbine.patternmatch;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class NullCaseBlock<S> implements CaseBlock<S> {
  @Nonnull
  Block block;

  @Override
  public boolean match(@Nullable S subject) {
    return subject == null;
  }

  @Override
  public void accept(S subject) {
    block.apply();
  }
}
