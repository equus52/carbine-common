package equus.carbine.patternmatch;

import java.util.function.Function;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import lombok.Value;

@Value
public class DefaltCaseFunction<S, R> implements CaseFunction<S, R> {
  @Nonnull
  Function<S, R> function;

  @Override
  public Result<R> matchAndApply(@Nullable S subject) {
    return Result.of(function.apply(subject));
  }

}
