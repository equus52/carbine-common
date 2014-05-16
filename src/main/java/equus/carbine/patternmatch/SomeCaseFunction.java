package equus.carbine.patternmatch;

import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nonnull;

import lombok.Value;

@Value
public class SomeCaseFunction<T, R> implements CaseFunction<Optional<T>, R> {
  @Nonnull
  Function<T, R> function;

  @Override
  public Result<R> matchAndApply(@Nonnull Optional<T> subject) {
    if (subject.isPresent()) {
      return Result.of(function.apply(subject.get()));
    }
    return Result.ofFalse();
  }

}
