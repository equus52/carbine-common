package equus.carbine.patternmatch;

import java.util.Optional;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class NoneCaseBlock implements CaseBlock<Optional<?>> {
  @Nonnull
  Block block;

  @Override
  public boolean matchAndAccept(@Nonnull Optional<?> subject) {
    if (!subject.isPresent()) {
      block.apply();
      return true;
    }
    return false;
  }

}
