package equus.carbine.patternmatch;

import java.util.Optional;
import java.util.function.Supplier;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class NoneCaseFunction<R> implements CaseFunction<Optional<?>, R> {
  @Nonnull
  Supplier<R> supplier;

  @Override
  public Result<R> matchAndApply(Optional<?> subject) {
    if (!subject.isPresent()) {
      return Result.of(supplier.get());
    }
    return Result.ofFalse();
  }

}
